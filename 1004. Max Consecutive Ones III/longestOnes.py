class Solution:
    def longestOnes(self, A: List[int], K: int) -> int:
        left = 0
        ans = 0
        for i in range(len(A)):
            if A[i] == 0:
                K -= 1
            if K < 0:
                while left <= i and A[left] == 1:
                    left += 1
                if left < i:
                    left += 1
                    K += 1
            if K >= 0:
                ans = max(ans, i - left + 1)
        return ans
