class Solution:
    def clumsy(self, N: int) -> int:
        if N == 1:
            return 1
        if N == 2:
            return 2
        if N == 3:
            return 6
        nums = []
        op = ['*','/','+','-']
        i = 0
        last = N
        N -= 1
        while (N):
            if op[i] == '*':
                last *= N
            if op[i] == '/':
                last = int(last / N)
            if op[i] == '+':
                nums.append(last)
                nums.append(N)
            if op[i] == '-':
                last = N
            i += 1
            N -= 1
            if i == 4:
                i = 0
        if i != 3:
            nums.append(last)
        j = 0
        print(nums)
        ans = nums[0]
        for i in range(1, len(nums)):
            if j == 0:
                ans += nums[i]
            else:
                ans -= nums[i]
            j += 1
            if j == 2:
                j = 0
        return ans
    
