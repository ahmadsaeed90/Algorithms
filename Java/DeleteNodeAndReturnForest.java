import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodeAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //11.28
        
        var roots = new ArrayList<TreeNode>();
        var set = new HashSet<Integer>();
        
        for (var v : to_delete)
            set.add(v);
        
        /*
            delete a node
                1. set parent pointer to null
                2. if parent is null for a non deleted node, add it to result
        */
        delNodesRecursive (root, roots, null, set);
        return roots;
    }
    
    public void delNodesRecursive(TreeNode node, List<TreeNode> roots, TreeNode parent, Set<Integer> toDelete) {
        
        if (node == null) return;
        boolean isDeleted = false;
        
        if (toDelete.contains(node.val)) {
            isDeleted = true;
            if (parent != null) {
                parent.left = parent.left == node? null: parent.left;
                parent.right = parent.right == node? null: parent.right;                
            }
        }
        else if (parent == null) {
            roots.add(node);
        }
        
        var nextParent = isDeleted ? null: node;
        
        delNodesRecursive(node.left, roots, nextParent, toDelete);
        delNodesRecursive(node.right, roots, nextParent, toDelete);
    }
    class TreeNode {
    	 int val;
    	 TreeNode left;
    	 TreeNode right;
    	 TreeNode() {}
    	 TreeNode(int val) { this.val = val; }
    	 TreeNode(int val, TreeNode left, TreeNode right) {
    		 this.val = val;
    	     this.left = left;
    	     this.right = right;
    	 }
    }
}