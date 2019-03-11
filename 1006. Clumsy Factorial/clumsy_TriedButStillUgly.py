class Solution:
    def clumsy(self, N: int) -> int:
        if N == 1:
            return 1
        copyN = N
        nums = []
        op = ['*','/','+','-']
        cal = N
        N -= 1
        i = 0
        while N:
            if op[i] == '*':
                cal *= N
            elif op[i] == '/':
                cal = int(cal/N)
            elif op[i] == '+':
                if copyN - N > 4:
                    cal -= N
                else:
                    cal += N
            else:
                nums.append(cal)
                cal = N
            i += 1
            if i == 4:  i = 0
            N -= 1
        # the last operation isn't '-'
        nums.append(cal)
        ans = nums[0]
        for x in nums[1:]:
            ans -= x
        return ans
    
