inp = open('in.txt','r')
out = open('out.txt','w')
T = int(inp.readline())


for i in range(1,T+1) :
    N,K = inp.readline().split()
    N = int(N) ; K = int(K)
    onPattern = '1'*N # all ones
    s = bin(K) 
    if ( s[len(s)-N:] == onPattern ) : 
        out.write("Case #%s: ON\n"%i)
    else :
        out.write ("Case #%s: OFF\n"%i)
