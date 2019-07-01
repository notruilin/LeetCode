class Solution:
    def largestValsFromLabels(self, values: List[int], labels: List[int], num_wanted: int, use_limit: int) -> int:
        from collections import Counter
        zipped = zip(values, labels)
        zipped = sorted(zipped,reverse = True)
        C = Counter()
        num = 0
        ans = 0
        for item in zipped:
            if C[item[1]] == use_limit: continue
            C[item[1]] += 1
            num += 1
            ans += item[0]
            if num == num_wanted: break
        return ans
