# This script runs scala programs against input files 
# Assumptions: 
# 1. This script exists in the same folder beside the Scala program 
# 2. The folder contains only one .scala file, which contains the Main method
# 3. Input file name is "input" (defined below in constants section)
# The output file will be named "output"
# Parameters
# c Compiles the scala files
# p prints the output AFTER wrting the file

# Constants/Options
IN=".in" # input file extensioon
OUT=".out" # output file extension
PACKAGE_PREFIX="com" # package com.abdulradi.codejam.blah.blah
# End Constants/Options # Rest is the logic
 
class=$(ls *.scala | awk -F'.' '{print $1}')
package=$(cat *.scala | grep package | awk -F' ' '{print $2}')
fullClassName=$(echo $package.$class)
if [[ $* == *c* ]]; then
    printf "Compiling %s\n" $(echo *.scala)
    rm -rf $PACKAGE_PREFIX
    scalac *.scala
else
    echo "Not compiling, Hope the old classes still exists."     
fi

for f in *$IN; do 
    outFileName=$(echo $f | awk -F$IN '{print $1}')$OUT
    rm -f $outFileName
    cat $f | scala $package.$class > $outFileName
    printf "Generated %s\n" $outFileName
done

if [[ $* == *p* ]]; then
    cat $outFileName
else
    echo "Done"
fi 
