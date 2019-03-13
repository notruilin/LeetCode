class Solution:
    def isValid(self, S: str) -> bool:
        while S:
            index = S.find("abc")
            if index == -1:
                return False
            else:
                S = S[:index] + S[index + 3:]
        return True
