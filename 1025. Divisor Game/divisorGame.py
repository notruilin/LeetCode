class Solution(object):
    def divisorGame(self, N):
        """
        :type N: int
        :rtype: bool
        """
        # 0, 1, 2, 3
        firstWin = [False, False, True, False]
        for i in range(4, N+1):
            flag = False
            for j in range(1, i):
                if i % j == 0:
                    if not firstWin[i-j]:
                        flag = True
                        break
            firstWin.append(flag)
        return firstWin[N]
    
