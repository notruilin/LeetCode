class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> ans = new ArrayList();
        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j <= text.length(); j++) {
                for (int k = 0; k < words.length; k++) {
                    if (words[k].equals(text.substring(i,j))) {
                        int[] newAns = new int[2];
                        newAns[0] = i;
                        newAns[1] = j-1;
                        ans.add(newAns);
                        break;
                    }
                }
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
