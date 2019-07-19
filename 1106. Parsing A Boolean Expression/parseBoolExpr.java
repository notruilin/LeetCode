class Solution {
    private boolean charToBoolean(char c) {
        if (c == 't')   return true;
        return false;
    }
    
    private char booleanToChar(boolean b) {
        if (b)   return 't';
        return 'f';
    }
    
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ',')   continue;
            
            if (c == ')' || c == '}') {
                List<Boolean> list = new ArrayList();
                
                char start;
                if (c == ')')   start = '(';
                else    start = '{';
                while (true) {
                    char val = stack.pop();
                    if (val == start)   break;
                    list.add(charToBoolean(val));
                }
                
                char f = stack.pop();
                boolean b = list.get(0);
                switch (f) {
                    case '!':
                        b = !b;
                        break;
                    case '|':
                        for (boolean expr: list)
                            b |= expr;
                        break;
                    case '&':
                        for (boolean expr: list)
                            b &= expr;
                        break;
                }
                stack.push(booleanToChar(b));
            }
            else {
                stack.push(c);
            }
        }
        return charToBoolean(stack.pop());
    }
}
