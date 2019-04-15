class Solution(object):
    def removeOuterParentheses(self, S):
        """
        :type S: str
        :rtype: str
        """
        P = []
        stack = []
        tmp = ""
        for c in S:
            if c == "(":
                stack.append("(")
                tmp += "("
            else:
                tmp += ")"
                stack.pop()
                if (len(stack) == 0):
                    P.append(tmp)
                    tmp = ""
        for i in range(len(P)):
            P[i] = P[i][1:len(P[i]) - 1]
        return "".join(P)
        
