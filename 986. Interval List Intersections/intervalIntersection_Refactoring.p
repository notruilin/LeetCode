# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def intervalIntersection(self, A, B):
        """
        :type A: List[Interval]
        :type B: List[Interval]
        :rtype: List[Interval]
        """
        ans = []
        i = j = 0
        while i < len(A) and j < len(B):
            start = max(A[i].start, B[j].start)
            end = min(A[i].end, B[j].end)
            if start <= end:
                ans.append(Interval(start, end))
            while i < len(A) and (A[i].end < start or A[i].end == end):
                i += 1
            while j < len(B) and (B[j].end < start or B[j].end == end):
                j += 1
        return ans
    
