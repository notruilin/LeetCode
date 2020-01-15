class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = arr[0], ans = Integer.MAX_VALUE, best = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int tmp = (int) Math.rint((target - sum) / (double)(arr.length - i));
            tmp = Math.min(tmp < arr[i-1] ? arr[i-1] : tmp, arr[i] - 1);
            int cur = Math.abs(target - sum - tmp * (arr.length - i));
            if (best > cur) {
                best = cur;
                ans = tmp;
            }
            else {
                if (best == cur && tmp < ans)
                    ans = tmp;
            }
            sum += arr[i];
        }
        if (target / arr.length < arr[0]) {
            ans = (int) Math.rint(target / (double)arr.length);
            best = 0;
        }
        if (Math.abs(sum - target) < best)
            ans = arr[arr.length - 1];
        return ans;
    }
}
