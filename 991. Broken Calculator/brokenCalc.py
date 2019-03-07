class Solution(object):
    def brokenCalc(self, X, Y):
        """
        :type X: int
        :type Y: int
        :rtype: int
        """
        ans = 0
        while Y > X:
            ans += 1
            if Y % 2 == 0:
                Y /= 2
            else:
                Y += 1
        ans += X-Y
        return ans
