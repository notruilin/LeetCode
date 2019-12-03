class Solution {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> odd = new ArrayList();
        List<Integer> even = new ArrayList();
        for (int x: A) {
            if (x % 2 == 0)
                even.add(x);
            else
                odd.add(x);
        }
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = even.get(0);
                even.remove(0);
            }
            else {
                A[i] = odd.get(0);
                odd.remove(0);
            }
        }
        return A;
    }
}
