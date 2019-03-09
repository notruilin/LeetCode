class Solution(object):
    def findJudge(self, N, trust):
        """
        :type N: int
        :type trust: List[List[int]]
        :rtype: int
        """
        hasTrust = [False for i in range(N+1)]
        beTrusted = [0 for i in range(N+1)]
        
        for x,y in trust:
            hasTrust[x] = True
            beTrusted[y] += 1
            
        for i in range(1, N+1):
            if not hasTrust[i] and beTrusted[i] == N-1:
                return i
        return -1
    
