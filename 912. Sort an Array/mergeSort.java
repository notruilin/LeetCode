class Solution {
    void mergeLists(List<Integer> nums, int left, int right) {
        List<Integer> leftNums = new ArrayList();
        List<Integer> rightNums = new ArrayList();
        int count = (right - left) + 1;
        for (int i = left; i < left + count / 2; i++)
            leftNums.add(nums.get(i));
        for (int i = left + count / 2; i <= right; i++)
            rightNums.add(nums.get(i));
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (i >= leftNums.size() || (j < rightNums.size() && leftNums.get(i) > rightNums.get(j))) {
                nums.set(k, rightNums.get(j));
                j++;
            }
            else {
                nums.set(k,leftNums.get(i));
                i++;
            }
        }
    }
    
    void mergeSort(List<Integer> nums, int left, int right) {
        if (left == right)  return;
        int count = (right - left) + 1;
        mergeSort(nums, left, left + count / 2 - 1);
        mergeSort(nums, left + count / 2, right);
        mergeLists(nums, left, right);
    }
    
    public List<Integer> sortArray(int[] nums) {
        List<Integer> lst = new ArrayList();
        for (int x: nums)   lst.add(x);
        mergeSort(lst, 0, lst.size() - 1);
        return lst;
    }
}
