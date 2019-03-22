class Solution(object):
    def uniquePathsIII(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        
        N = len(grid)
        M = len(grid[0])
        nonObstacle = 0
        visited = [[False for j in range(M)] for i in range(N)]
        dx = [0, 0, 1, -1]
        dy = [1, -1, 0 ,0]
        for i in range(N):
            for j in range(M):
                if grid[i][j] == 1:
                    start = (i,j)
                if grid[i][j] != -1:
                    nonObstacle += 1
        self.ans = 0
        
        def valid(x, y):
            if x >= 0 and x < N and y >= 0 and y < M and grid[x][y] != -1 and not visited[x][y]:
                return True
            return False
        
        def dfs(x, y, step):
            if grid[x][y] == 2:
                if step == nonObstacle:
                    self.ans += 1
                    return
            for i in range(4):
                if valid(x+dx[i], y+dy[i]):
                    visited[x+dx[i]][y+dy[i]] = True
                    dfs(x+dx[i], y+dy[i], step+1)
                    visited[x+dx[i]][y+dy[i]] = False
        
        step = 1
        visited[start[0]][start[1]] = True
        dfs(start[0], start[1], step)
        return self.ans
    
