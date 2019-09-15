class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                List<Character> str = new ArrayList();
                while (true) {
                    char c = stack.pop();
                    if (c == '(') {
                        for (int j = 0; j < str.size(); j++) {
                            stack.push(str.get(j));
                        }
                        break;
                    }
                    else    str.add(c);
                }
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        
        List<Character> arrayListChar = new ArrayList();
        while (!stack.empty()) {
            arrayListChar.add(stack.pop());
        }
        
        Iterator<Character> it = arrayListChar.iterator();
        StringBuilder sb = new StringBuilder();

        while(it.hasNext()) {
            sb.append(it.next());
        }
        
        return sb.reverse().toString();
    }
}
