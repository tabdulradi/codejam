from math import ceil

def get_max_googlers(line):
    params = line.split()
    surprising_count = int(params[1])
    min_score_sum = int(params[2]) * 3 - 2
    max_googlers = 0
    for total in [int(t) for t in params[3:]]:
        if total >= min_score_sum: 
            max_googlers += 1
        elif surprising_count > 0 and total > 1 and total >= min_score_sum-2:
            max_googlers += 1
            surprising_count -= 1

    return max_googlers

def file_handler(f):
    for i in range(int(f.readline())):
        yield "Case #%s: %s" % (i+1, get_max_googlers(f.readline()))

import sys
for line in file_handler(sys.stdin):
    print line
