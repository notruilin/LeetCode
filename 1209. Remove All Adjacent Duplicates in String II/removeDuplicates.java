class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayList<Character> lst = new ArrayList();
        for (int i = 0; i < s.length(); i++)
            lst.add(s.charAt(i));
        while (true) {
            boolean del = false;
            int i = 1, count = 1;
            while (i < lst.size()) {
                if (i > 0 && lst.get(i) == lst.get(i-1)) {
                    ++count;
                    if (count == k) {
                        del = true;
                        int index = i - k + 1;
                        for (int j = 0; j < k; j++) {
                            lst.remove(index);
                        }
                        i -= k;
                        count = 0;
                    }
                }
                else {
                    count = 1;
                }
                ++i;
            }
            if (!del)   break;
        }
        
        StringBuilder builder = new StringBuilder(lst.size());
        for(Character ch: lst)  builder.append(ch);
        return builder.toString();
    }
}
