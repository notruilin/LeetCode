class Solution(object):
    def addToArrayForm(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: List[int]
        """
        A[-1] += K
        if not A[0]: return [0]
        i = len(A) - 1
        while A[0] >= 10 or i != 0:
            if i == 0 and A[i] >= 10:
                A.insert(0, 0)
                i += 1
            A[i-1] = A[i-1] + A[i] / 10
            A[i] %= 10
            i -= 1
        return A
