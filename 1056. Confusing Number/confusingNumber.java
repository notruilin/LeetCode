class Solution {
    public boolean confusingNumber(int N) {
        Integer[] numsA = {0,1,6,8,9};
        List<Integer> nums = Arrays.asList(numsA);
        boolean nonOne = false;
        int oldN = N, newN = 0;
        while (N > 0) {
            int i = N % 10;
            if (!nums.contains(i))   return false;
            if (i == 6) i = 9;
            else {
                if (i == 9) i = 6;
            }
            newN = newN * 10 + i;
            N /= 10;
        }
        if (oldN == newN) return false;
        return true;
    }
}
