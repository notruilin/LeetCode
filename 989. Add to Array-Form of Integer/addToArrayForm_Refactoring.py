class Solution(object):
    def addToArrayForm(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: List[int]
        """
        A[-1] += K
        for i in range(len(A)-1, 0, -1):
            A[i-1] += A[i]/10
            A[i] = A[i] % 10
        return list(int(c) for c in str(A[0])) + A[1:]
