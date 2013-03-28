from collections import deque

inp = open('in.txt','r')
out = open('out.txt','w')

T = int(inp.readline())
for i in range(T) :
    R,K,N = inp.readline().split()
    R = int(R) ; K = int(K) ; N = int(N) 
    queStr = inp.readline().split()
    que = deque()
    # convert stack to ints 
    for s in queStr : que.append(int(s))
    del(queStr) # save memory
    # loop for R times , times roller will play
    euros = 0 
    for j in range(R) : 
        pplCount = 0
        for k in range(N) :
        # check for enuf seats
            if  ( pplCount + que[0] <= K ) :
                # good , jump into seats ;)
                pplCount += que[0]
                euros += que[0]
                que.append(que.popleft())
            else : 
                # opsss, thats enuf 
                break 
    out.write ("Case #%s: %s\n"%(i+1,euros))
            
            
        

#        out.write ("Case #%s: OFF\n"%i)
