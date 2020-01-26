class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a, b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(b[1], a[1]));
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < restaurants.length; i++) {
            if ((veganFriendly == 0 || veganFriendly == restaurants[i][2]) && maxPrice >= restaurants[i][3] && maxDistance >= restaurants[i][4])
                ans.add(restaurants[i][0]);
        }
        return ans;
    }
}
