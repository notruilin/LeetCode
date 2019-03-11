class Solution:
    def clumsy(self, N: int) -> int:
        op = ['*','//','+','-']
        s = ""
        for i in range(N, 0, -1):
            s += str(i) + (op[(N-i)%4] if i > 1 else "")
        return eval(s)
    
