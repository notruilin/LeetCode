class Trie {
    class TreeNode {
        public Map<Character, TreeNode> children = new HashMap();
        public boolean end;
    }
    
    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c))  node.children.put(c, new TreeNode());
            node = node.children.get(c);
        }
        node.end = true;
    }
    
    public int find(String word) {
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c))  return -1;
            node = node.children.get(c);
        }
        if (node.end)   return 1;
        return 0;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int res = find(word);
        if (res == 1)   return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int res = find(prefix);
        if (res == -1)   return false;
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
