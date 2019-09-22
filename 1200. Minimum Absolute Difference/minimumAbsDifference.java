class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int N = arr.length, minn = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            minn = Math.min(minn, arr[i] - arr[i-1]);
        }
        List<List<Integer>> ans = new ArrayList();
        for (int i = 1; i < N; i++) {
            if (arr[i] - arr[i-1] == minn) {
                List<Integer> pair = new ArrayList();
                pair.add(arr[i-1]);
                pair.add(arr[i]);
                ans.add(pair);
            }
        }
        return ans;
    }
}
