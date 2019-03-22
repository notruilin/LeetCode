class Solution(object):
    def isRationalEqual(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: bool
        """
        
        def changeStr(i, str):
            rep = str[i:-1]
            str = str[:i-1]
            str = str + rep * 20
            return str
        
        def transNum(str):
            if str.find("(") == -1:
                if str[-1] == '.':
                    str = str[:len(str)-1]
            else:
                str = changeStr(str.find("(")+1, str)
            return float(str)
        
        return transNum(S) == transNum(T)
        
