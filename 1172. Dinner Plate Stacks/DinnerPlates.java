class DinnerPlates {
    TreeMap<Integer, Integer> leftTree = new TreeMap();
    TreeMap<Integer, Integer> rightTree = new TreeMap();
    List<Stack<Integer>> stackList = new ArrayList();
    int capacity;
    
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }
    
    public void push(int val) {
        int index;
        if (leftTree.size() == 0) {
            stackList.add(new Stack<Integer>());
            index = stackList.size() - 1;
            leftTree.put(index, 1);
            rightTree.put(index, 1);
        }
        else {
            index = leftTree.firstKey();
        }
        stackList.get(index).push(val);
        if (stackList.get(index).size() == capacity) {
            leftTree.remove(index);
        }
    }
    
    public int pop() {
        if (rightTree.size() == 0)  return -1;
        int index = rightTree.lastKey();
        return popAtStack(index);
    }
    
    public int popAtStack(int index) {
        if (stackList.get(index).size() == 0) return -1;
        int val = stackList.get(index).pop();
        if (stackList.get(index).size() == 0) {
            leftTree.remove(index);
            rightTree.remove(index);
        }
        if (stackList.get(index).size() == capacity - 1) {
            leftTree.put(index, 1);
        }
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
