class Solution(object):
    def oddEvenJumps(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        
        def findNext(S):
            stack = []
            nextJ = [-1] * len(A)
            for j in S:
                while stack and stack[-1] < j:
                    nextJ[stack[-1]] = j
                    stack.pop()
                stack.append(j)
            return nextJ
        
        s = sorted(range(len(A)), key = lambda x: A[x])
        odd = findNext(s)
        s = sorted(range(len(A)), key = lambda x: -A[x])
        even = findNext(s)
        
        goodForOdd = [False] * len(A)
        goodForOdd[-1] = True
        goodForEven = [False] * len(A)
        goodForEven[-1] = True
        ans = 1
        
        for i in range(len(A)-2, -1, -1):
            if even[i] > 0  and goodForEven[even[i]]:
                goodForOdd[i] = True
            if odd[i] > 0 and goodForOdd[odd[i]]:
                ans += 1
                goodForEven[i] = True
                
        return ans
    
