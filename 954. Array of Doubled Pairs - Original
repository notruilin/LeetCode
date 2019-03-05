class Solution(object):
    def canReorderDoubled(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        A = sorted(A, key = abs)
        count = {}
        for x in A:
            if x in count:
                count[x] += 1
            else:
                count[x] = 1 
        while (A):
            if A[0] * 2 in count and count[A[0]*2] > 0:
                count[A[0] * 2] -= 1
                count[A[0]] -= 1
                A.remove(A[0]*2)
                A.remove(A[0])
            else:
                return False
        return True
    
