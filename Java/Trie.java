class Trie {

    private Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        int len = word.length();
        var current = root;
        
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            
            if (current.children[index] == null)
                current.children[index]=new Node();
            
            current = current.children[index];
        }
        
        current.isWordEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Node current = findNode(word);
        
        return current != null && current.isWordEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = findNode(prefix);
        
        return current != null;
    }
    
    private Node findNode(String str) {
        int len = str.length();
        var current = root;
        
        for (int i = 0; i < len; i++) {
            int index = str.charAt(i) - 'a';
            
            if (current.children[index] == null)
                return null;
            
            current = current.children[index];
        }
        
        return current;
    }
}

class Node {
    public Node [] children;
    public boolean isWordEnd;
    
    public Node() {
        children = new Node[26];
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
