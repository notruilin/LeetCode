class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        for (int i = 0; ;i++) {
            if (candies >= i + 1) {
                ans[i % num_people] += i + 1;
                candies -= i + 1;
            }
            else {
                ans[num_people - 1] += candies;
                break;
            }
        }
        return ans;
    }
}
