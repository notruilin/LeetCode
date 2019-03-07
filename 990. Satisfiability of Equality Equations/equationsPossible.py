class Solution(object):
    def equationsPossible(self, equations):
        """
        :type equations: List[str]
        :rtype: bool
        """
        
        parent = [x for x in range(27)]
        rank = [0 for _ in range(27)]
        
        def find(x):
            if parent[x] == x:
                return x
            else:
                parent[x] = find(parent[x])
                return parent[x]
        
        def unite(x, y):
            x = find(x)
            y = find(y)
            if rank[x] < rank[y]:
                parent[x] = y
            else:
                parent[y] = x
                if rank[x] == rank[y]:
                    rank[x] += 1
        
        def same(x, y):
            if find(x) == find(y):
                return True
            return False
        
        def toNum(char):
            return ord(char) - ord('a')
        
        for eq in equations:
            if eq[1] == "=":
                unite(toNum(eq[0]), toNum(eq[-1]))
                
        for eq in equations:
            if eq[1] == "!":
                if same(toNum(eq[0]), toNum(eq[-1])):
                    return False
                
        return True
    
