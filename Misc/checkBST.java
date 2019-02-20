/**
 * Created on 20 Feb 2019 by happygirlzt
 * 
 */

public class checkBST {
    // Iteratively
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (prev != null) {
                if (root.val <= prev.val) return false;
            }
            
            prev = root;
            root = root.right;
        }
        
        return true;
    }

    // Recursively
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) return true;
        // ATTENTION: We have to gurantee that the 
        // min, max not equal to the original value
        if (min != Long.MIN_VALUE && root.val <= min) return false;
        if (max != Long.MAX_VALUE && root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}