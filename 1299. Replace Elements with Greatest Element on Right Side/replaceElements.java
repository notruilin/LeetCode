class Solution {
    public int[] replaceElements(int[] arr) {
        int maxValue = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = maxValue;
            maxValue = Math.max(maxValue, tmp);
        }
        return arr;
    }
}
