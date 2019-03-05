class Solution(object):
    def canReorderDoubled(self, A):
        """
        :type A: List[int]
        :rtype: bool
        """
        count = collections.Counter(A)
        A = sorted(A, key = abs)
        for x in A:
            if count[x] == 0:
                continue
            if count[x*2] >= count[x]:
                count[x * 2] -= count[x]
                count[x] = 0
            else:
                return False
        return True
    
