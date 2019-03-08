class Solution:
    def minAreaFreeRect(self, points: List[List[int]]) -> float:
        
        def calDis(p1, p2):
            return (p1[0]-p2[0])**2.0 + (p1[1]-p2[1])**2.0
        
        ans = math.inf
        check = set()
        for point in points:
            check.add(str(point))
        
        for a in points:
            for b in points:
                if a == b: continue
                for c in points:
                    if a == c or b == c: continue
                    if calDis(a,b) + calDis(b,c) == calDis(a,c):
                        d = [a[0] + c[0] - b[0], a[1] + c[1] - b[1]]
                        if str(d) in check:
                            ans = min(ans, math.sqrt(calDis(a,b)) * math.sqrt(calDis(b,c)))
        if ans == math.inf:
            return 0
        else:
            return ans
        
