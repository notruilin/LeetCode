class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList();
        int wordCount = 0, spaceCount = -1, start = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordCount + spaceCount + 1 + words[i].length() <= maxWidth) {
                wordCount += words[i].length();
                spaceCount++;
            }
            else {
                int num = Math.max(1, i - start - 1);
                int totalSpaceNum = maxWidth - wordCount;
                int avgSpaceNum = (maxWidth - wordCount) / num;
                int extraSpaceNum = (maxWidth - wordCount) % num;
                StringBuilder line = new StringBuilder();
                for (int j = start; j < i - 1; j++) {
                    line.append(words[j]);
                    for (int k = 0; k < avgSpaceNum; k++) {
                        line.append(" ");
                    }
                    if (extraSpaceNum > 0) {
                        line.append(" ");
                        extraSpaceNum--;
                    }
                }
                line.append(words[i-1]);
                num = maxWidth - line.length();
                for (int j = 0; j < num; j++)
                    line.append(" ");
                ans.add(line.toString());
                
                wordCount = words[i].length();
                spaceCount = 0;
                start = i;
            }
        }
        StringBuilder line = new StringBuilder();
        for (int i = start; i < words.length - 1; i++) {
            line.append(words[i]);
            line.append(" ");
        }
        line.append(words[words.length - 1]);
        int num = maxWidth - line.length();
        for (int i = 0; i < num; i++)
            line.append(" ");
        ans.add(line.toString());
        return ans;
    }
}
