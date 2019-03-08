class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh = set()
        for x in range(len(grid)):
            for y in range(len(grid[0])):
                if grid[x][y] == 1:
                    fresh.add((x,y))
        
        def checkNeighRotten(x,y):
            for dx,dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                if x+dx >= 0 and x+dx < len(grid) and y+dy >=0 and y+dy < len(grid[0]):
                    if grid[x+dx][y+dy] == 2:
                        return True
            return False
        
        ans = 0
        while fresh:
            change = []
            for x,y in list(fresh):
                if checkNeighRotten(x,y):
                    change.append((x,y))
                    fresh.remove((x,y))
            if not change: 
                break
            else:
                for x,y in change:
                    grid[x][y] = 2
            ans += 1
        
        if fresh:
            return -1
        else:
            return ans
