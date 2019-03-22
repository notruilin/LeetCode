class Solution(object):
    def maxWidthRamp(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        
        def binarySearch(d, x):
            left = 0
            right = len(d)
            while (left < right):
                mid = (left + right) / 2
                if d[mid] > x:
                    left = mid + 1
                else:
                    right = mid
            if left == len(d):
                return -1
            else:
                return left
        
        d = [A[0]]
        index = [0]
        ans = 0
        for i in range(1, len(A)):
            j = binarySearch(d, A[i])
            if j != -1:
                j = index[j]
                ans = max(ans, i - j) 
            if A[i] < d[-1]:
                d.append(A[i])
                index.append(i)
        return ans
