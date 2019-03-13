class Solution:
    def commonChars(self, A: List[str]) -> List[str]:
        ans = collections.Counter(A[0])
        for i in range(1, len(A)):
            ans = collections.Counter(ans) & collections.Counter(A[i])
        return list(ans.elements())
