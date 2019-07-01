class Solution:
    def shortestCommonSupersequence(self, str1: str, str2: str) -> str:
        # 0 -> up, 1 -> left, 2 -> diagonal
        f = [[len(str1) + len(str2) for j in range(len(str2) + 1)] for i in range(len(str1) + 1)]
        ans = [[-1 for j in range(len(str2) + 1)] for i in range(len(str1) + 1)]
        for i in range(len(str1) + 1):
            f[i][0] = i
            if i != 0: ans[i][0] = 0
        for j in range(len(str2) + 1):
            f[0][j] = j
            if  j != 0: ans[0][j] = 1

        for i in range(1, len(str1) + 1):
            for j in range(1, len(str2) + 1):
                if str1[i-1] == str2[j-1]:
                    f[i][j] = f[i-1][j-1] + 1
                    ans[i][j] = 2
                if f[i-1][j] + 1 < f[i][j]:
                    f[i][j] = f[i-1][j] + 1
                    ans[i][j] = 0
                if f[i][j-1] + 1 < f[i][j]:
                    f[i][j] = f[i][j-1] + 1
                    ans[i][j] = 1

        ansStr = ""
        i, j = len(str1), len(str2)
        while ans[i][j] != -1:
            c = ""
            if ans[i][j] == 0:
                c = str1[i-1]
                i -= 1
            elif ans[i][j] == 1:
                c = str2[j-1]
                j -= 1
            else:
                c = str1[i-1]
                i -= 1
                j -= 1
            ansStr = c + ansStr
        return ansStr
        
