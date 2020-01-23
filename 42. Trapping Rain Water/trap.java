class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int maxV = 0;
        for (int i = 0; i < height.length; i++) {
            maxV = Math.max(maxV, height[i]);
            left[i] = maxV;
        }
        maxV = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxV = Math.max(maxV, height[i]);
            right[i] = maxV;
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++)
            sum += Math.min(left[i], right[i]) - height[i];
        return sum;
    }
}
