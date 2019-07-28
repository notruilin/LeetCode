class Solution(object):
    def alphabetBoardPath(self, target):
        """
        :type target: str
        :rtype: str
        """
        ans = ""
        
        start = 0
        for k in range(len(target)):
            if (k > 0 and target[k-1] == target[k]):
                ans += '!'
                continue
            c = target[k]
            if (start == 25):
                ans += 'U'
                start = 20
            if c == 'z':
                end = 20
            else:
                end = ord(c) - ord('a')
            d = abs(end // 5 - start // 5)
            for i in range(d):
                if (end < start):
                    ans += 'U'
                else:
                    ans += 'D'
            d = abs(end % 5 - start % 5)
            for i in range(d):
                if (end % 5 < start % 5):
                    ans += 'L'
                else:
                    ans += 'R'
            if c == 'z' and (k == 0 or (k > 0 and target[k-1] != 'z')):
                ans += 'D'
            ans += '!'
            if (c == 'z'):
                start = 25
            else:
                start = end
        return ans
