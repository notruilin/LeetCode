class Solution(object):
    def canReorderDoubled(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        count = collections.Counter(A)
        for x in sorted(A, key = abs):
            if count[x] == 0:
                continue
            if count[x*2] < count[x]:
                return False
            count[x * 2] -= count[x]
            count[x] = 0
                
        return True
