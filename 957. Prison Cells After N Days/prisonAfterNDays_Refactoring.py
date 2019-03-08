class Solution(object):
    def prisonAfterNDays(self, cells, N):
        """
        :type cells: List[int]
        :type N: int
        :rtype: List[int]
        """
        
        def nextDay(cells):
            newC = []
            for i in range(1, len(cells)-1):
                if cells[i-1] == cells[i+1]:
                    newC.append(1)
                else:
                    newC.append(0)
            return [0] + newC +[0]
        
        dict = {}
        while N:
            N -= 1
            cells = nextDay(cells)
            if str(cells) in dict:
                N %= dict[str(cells)] - N
            else:
                dict[str(cells)] = N
        return cells
