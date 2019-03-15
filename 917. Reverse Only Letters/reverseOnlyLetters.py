class Solution:
    def reverseOnlyLetters(self, S: str) -> str:
        lst = list(S)
        left = 0
        right = len(lst) - 1
        while left < right:
            while left < len(S) and not str.isalpha(lst[left]):
                left += 1
            while right > 0 and not str.isalpha(lst[right]):
                right -= 1
            if left < right and left < len(S) and right > 0:
                lst[left], lst[right] = lst[right], lst[left]
                left += 1
                right -= 1
        return "".join(lst)
