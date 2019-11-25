class Solution {
    
    private int binarySearchHead(String[] products, int index, char c, int left, int right) {
        if (left == -1) return -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (products[mid].length() - 1 < index || products[mid].charAt(index) < c)
                left = mid + 1;
            else
                right = mid;
        }
        if (products[left].length() - 1 < index || products[left].charAt(index) != c)  left = -1;
        return left;
    }
    
    private int binarySearchTail(String[] products, int index, char c, int left, int right) {
        if (left == -1) return -1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (products[mid].length() - 1 < index || products[mid].charAt(index) > c)
                right = mid - 1;
            else
                left = mid;
        }
        if (products[left].length() - 1 < index || products[left].charAt(index) != c)  left = -1;
        return left;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList();
        Arrays.sort(products);
        int left = 0, right = products.length - 1;
        
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> words = new ArrayList();
            left = binarySearchHead(products, i, searchWord.charAt(i), left, right);
            right = binarySearchTail(products, i, searchWord.charAt(i), left, right);
            if (left != -1) {
                for (int j = left; j <= left + 2 && j <= right; j++) {
                    words.add(products[j]);
                }
            }
            ans.add(words);
        }
        
        return ans;
    }
}
