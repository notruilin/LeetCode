class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        
        def swapCount(nums, other, aimNum):
            count = 0
            for i in range(len(nums)):
                if nums[i] != aimNum:
                    if other[i] == aimNum:
                        count += 1
                    else:
                        return math.inf
            return count

        ans = min(swapCount(A,B,A[0]), swapCount(A,B,B[0]), swapCount(B,A,A[0]), swapCount(B,A,B[0]))
        if ans == math.inf:
            return -1
        return ans
    
