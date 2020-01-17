class Solution {
    public String countAndSay(int n) {
        List<Character> lst = new ArrayList();
        lst.add('1');
        for (int i = 1; i < n; i++) {
            List<Character> next = new ArrayList();
            char c = lst.get(0);
            int count = 0;
            for (char x: lst) {
                if (x == c)     ++count;
                else {
                    next.add((char) ((int)'0' + count));
                    next.add(c);
                    count = 1;
                    c = x;
                }
            }
            next.add((char) ((int)'0' + count));
            next.add(c);
            lst = next;
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch : lst) { 
            sb.append(ch); 
        }
        return sb.toString();
    }
}
