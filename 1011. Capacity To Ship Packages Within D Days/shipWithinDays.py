class Solution(object):
    def shipWithinDays(self, weights, D):
        """
        :type weights: List[int]
        :type D: int
        :rtype: int
        """
        def checkLimit(limit):
            sums, days = 0, 0
            for i in range(len(weights)):
                sums += weights[i]
                if sums > limit:
                    days += 1
                    if (days >= D):
                        return False
                    sums = weights[i]
            return True
                    
        left, right = max(weights), sum(weights)
        while (left < right):
            mid = (left + right) // 2
            if (checkLimit(mid)):
                right = mid
            else:
                left = mid + 1
        return left
        
