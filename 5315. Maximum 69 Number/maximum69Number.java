class Solution {
    public int maximum69Number (int num) {
        List<Integer> lst = new ArrayList();
        while (num > 0) {
            lst.add(num % 10);
            num /= 10;
        }
        for (int i = lst.size() - 1; i >= 0; i--)
            if (lst.get(i) == 6) {
                lst.set(i, 9);
                break;
            }
        num = 0;
        for (int i = lst.size() - 1; i >= 0; i--)
            num = num * 10 + lst.get(i);
        return num;
    }
}
