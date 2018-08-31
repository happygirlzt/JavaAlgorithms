/**
 * Using Stack to implement the inorder traversal of binary tree
 * Created on 2018-08-26
 * @author happygirlzt
 *
 */

import java.util.Stack;

public class InorderTraversal {
	public void iterative(TreeNode root) {
		Stack<TreeNode> st = new Stack<>();
		
		TreeNode cur = root;
	
		while (cur != null || !st.empty()) {
			// Reach the leftmost node
			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			
			cur = st.pop();
			
			cur = cur.right;
		}
	}
	
	public void inOrder(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) inOrder(root.left);
		System.out.println(root.val + " ");
		if (root.right != null) inOrder(root.right);
	}
}
