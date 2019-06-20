class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        i = 0
        length = len(arr)
        while i < length:
            if arr[i] == 0:
                arr.insert(i, 0)
                i += 1
                arr.pop(-1)
            i += 1
        
