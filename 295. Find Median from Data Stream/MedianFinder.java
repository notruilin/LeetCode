class MedianFinder {
    List<Integer> lst;

    /** initialize your data structure here. */
    public MedianFinder() {
        lst = new ArrayList();
    }
    
    private int binarySearch(int num) {
        int left = 0, right = lst.size();
        lst.add(Integer.MAX_VALUE);
        while (left < right) {
            int mid = (left + right) / 2;
            if (lst.get(mid) <= num)
                left = mid + 1;
            else
                right = mid;
        }
        lst.remove(lst.size() - 1);
        return left;
    }
    
    public void addNum(int num) {
        int index = binarySearch(num);
        lst.add(index, num);
    }
    
    public double findMedian() {
        if (lst.size() % 2 != 0)    return lst.get(lst.size() / 2);
        return (lst.get(lst.size()/2-1) + lst.get(lst.size()/2)) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
