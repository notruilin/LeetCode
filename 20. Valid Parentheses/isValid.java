class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (stack.empty())  return false;
                char c = stack.pop();
                if ((s.charAt(i) == ')' && c == '(') || (s.charAt(i) == ']' && c == '[') || (s.charAt(i) == '}' && c == '{'))
                    continue;
                else
                    return false;
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if (!stack.empty())  return false;
        return true;
    }
}
