class Solution:
    def largestSumAfterKNegations(self, A: List[int], K: int) -> int:
        while K:
            K -= 1
            
            index = 0
            for i in range(len(A)):
                if A[i] < A[index]:
                    index = i
            if A[index] < 0:
                A[index] = -A[index]
                continue
                
            index = -1
            for i in range(len(A)):
                if A[i] >= 0 and (index == -1 or abs(A[i]) <= abs(A[index])):
                    index = i
            A[index] = -A[index]

        return sum(A)
        
