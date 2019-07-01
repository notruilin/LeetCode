class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        N = len(grid)
        
        def checkValid(x, y):
            if x >= 0 and y >= 0 and x < N and y < N:
                return True
            return False
        
        if grid[0][0] == 1 or grid[N - 1][N - 1] == 1:
            return -1
        q = [(0,0,1)]
        visited = [[False for j in range(N)] for i in range(N)]
        while len(q):
            pos = q.pop(0)
            x = pos[0]
            y = pos[1]
            cost = pos[2]
            for dx in range(-1, 2):
                for dy in range(-1, 2):
                    newx = x + dx
                    newy = y + dy
                    if checkValid(newx, newy) and not visited[newx][newy] and grid[newx][newy] == 0:
                        if newx == N - 1 and newy == N - 1:
                            return cost + 1
                        q.append((newx, newy, cost + 1))
                        visited[newx][newy] = True
        return -1
    
