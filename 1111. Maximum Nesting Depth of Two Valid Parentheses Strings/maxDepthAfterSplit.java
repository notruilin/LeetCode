class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int count = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                ++count;
                stack.push(i);
            }
            else {
                ans[i] = count % 2;
                ans[stack.pop()] = count % 2;
                --count;
            }
        }
        return ans;
    }
}
