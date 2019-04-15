class Solution(object):
    def camelMatch(self, queries, pattern):
        """
        :type queries: List[str]
        :type pattern: str
        :rtype: List[bool]
        """
        ans = []
        for query in queries:
            index = 0
            for i in range(len(pattern)):
                while index < len(query) and not pattern[i] == query[index]:
                    index += 1
                if index < len(query) and pattern[i] == query[index]:
                    query = query[:index] + query[index+1:]
                else:
                    ans.append(False)
                    query = ""
                    break
            
            if query == "": continue
            ans.append(True)
            for i in range(len(query)):
                if query[i].isupper():
                    ans[-1] = False
                    break
        return ans
