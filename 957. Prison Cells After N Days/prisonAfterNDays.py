class Solution(object):
    def prisonAfterNDays(self, cells, N):
        """
        :type cells: List[int]
        :type N: int
        :rtype: List[int]
        """
        f = [[0 for j in range(len(cells))] for i in range(1001)]
        for i in range(len(cells)):
            f[0][i] = cells[i]
        dict = {}
        now = 0
        startTurn = 0
        oneTurn = -1
        while now < N:
            now += 1
            for i in range(1, len(cells)-1):
                if f[now-1][i-1] == f[now-1][i+1]:
                    f[now][i] = 1
                else:
                    f[now][i] = 0
                f[now][0] = 0
                f[now][len(f[1-now])-1] = 0
            ha = str(f[now])
            if ha in dict:
                startTurn = dict[ha]
                oneTurn = now - dict[ha]
                break
            else:
                dict[ha] = now
        if oneTurn == -1:
            return f[now]
        else:
            newN = N - startTurn
            return f[startTurn + newN % oneTurn]
    
