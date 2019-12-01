class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList();
        if ((tomatoSlices - 2*cheeseSlices) % 2 != 0)
            return ans;
        int x = (tomatoSlices - 2*cheeseSlices) / 2;
        if (x < 0 || cheeseSlices - x < 0)
            return ans;
        ans.add(x);
        ans.add(cheeseSlices - x);
        return ans;
    }
}
