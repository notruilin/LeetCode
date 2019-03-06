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
            while i < len(A) and A[i].end < B[j].start:
                i += 1
            if i >= len(A): break
            while j < len(B) and B[j].end < A[i].start:
                j += 1
            if j >= len(B): break
            if A[i].start > B[j].end or B[j].start > A[i].end: continue
            ans.append(Interval(max(A[i].start, B[j].start), min(A[i].end, B[j].end)))
            if A[i].end < B[j].end:
                i += 1
            else:
                if A[i].end == B[j].end:
                    i += 1
                j += 1
        return ans
