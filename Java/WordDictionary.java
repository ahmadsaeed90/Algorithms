class WordDictionary {
    
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        Node current = root;
        
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            
            if (current.children[index] == null)
                current.children[index] = new Node();
            
            current = current.children[index];
        }
        
        current.isWordEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return SearchRecursive(word, root);
    }
    
    private boolean SearchRecursive(String word, Node current) {
        
        int len = word.length();
        
        if (len == 0 && current.isWordEnd)
            return true;
        
        if (len == 0)
            return false;
        
        char c = word.charAt(0);
        
        if (c != '.') {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            return SearchRecursive(word.substring(1), current.children[index]);
        }
        else {
            
            for (int i = 0; i<current.children.length; i++) {
                if (current.children[i] != null) {
                    if (SearchRecursive(word.substring(1), current.children[i]))
                        return true;
                }
            }
            return false;
        }
    }
}

class Node {
    Node [] children;
    boolean isWordEnd;
    
    public Node() {
        children = new Node[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
