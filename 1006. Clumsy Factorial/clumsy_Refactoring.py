class Solution:
    def clumsy(self, N: int) -> int:
        if N == 1: return 1
        ans = None
        cal = N
        for i in range(N-1, 0, -1):
            op = (N-i-1) % 4
            if op == 0:
                cal *= i
            elif op == 1:
                cal //= i
            elif op == 2:
                cal += -i if N - i > 4 else i
            else:
                ans = cal if ans == None else ans-cal
                cal = i
        ans = cal if ans == None else ans-cal
        return ans
       
