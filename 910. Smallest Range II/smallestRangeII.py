class Solution:
    def smallestRangeII(self, A: List[int], K: int) -> int:
        A = sorted(A)
        ans = A[len(A) - 1] - A[0]
        for i in range(len(A) - 1):
            cmin = min(A[i + 1] - K, A[0] + K)
            cmax = max(A[i] + K, A[len(A) - 1] - K)
            ans = min(ans, cmax - cmin)
        return ans
    
