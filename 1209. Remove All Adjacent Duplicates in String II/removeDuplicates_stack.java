class Solution {
    class Pair {
        public char c;
        public int num;
        public Pair(char c, int num) {
            this.c = c;
            this.num = num;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack();
        
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() || stack.peek().c != s.charAt(i)) {
                stack.push(new Pair(s.charAt(i), 1));
            }
            else {
                if (stack.peek().num == k - 1) {
                    for (int j = 0; j < k - 1; j++)
                        stack.pop();
                }
                else {
                    stack.push(new Pair(s.charAt(i), stack.peek().num + 1));
                }
            }
        }
        
        StringBuilder builder = new StringBuilder(stack.size());
        for(Pair p: stack)  builder.append(p.c);
        return builder.toString();
    }
}
