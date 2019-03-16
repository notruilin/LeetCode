class Solution:
    def numRookCaptures(self, board: List[List[str]]) -> int:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 'R':
                    x, y = i, j
        
        ans = 0
        dx = [-1, 1, 0, 0]
        dy = [0, 0, -1, 1]
        for i in range(4):
            tx, ty = x + dx[i], y + dy[i]
            while tx >= 0 and tx < len(board) and ty >= 0 and ty < len(board[0]) and board[tx][ty] == '.':
                tx += dx[i]
                ty += dy[i]
            if tx >= 0 and tx < len(board) and ty >= 0 and ty < len(board[0]) and board[tx][ty] == 'p':
                ans += 1
        return ans
