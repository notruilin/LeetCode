class Solution:
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        A.sort()
        i = 0
        while K:
            if i < len(A) and A[i] < 0:
                A[i] = -A[i]
                i += 1
                K -= 1
            else:
                break
    
        if K % 2 != 0:
            return sum(A) - (min(A) * 2)
        else:
            return sum(A)
