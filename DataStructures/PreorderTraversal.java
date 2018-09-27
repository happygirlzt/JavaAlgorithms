package DataStructures;

/**
 * Preorder traversal iteratively and recursively.
 * 
 * @author happygirlzt
 *
 */
import java.util.Stack;

public class PreorderTraversal {
	public void iterative(TreeNode root) {
		if (root == null) return;
		
		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;
		st.push(cur);
		
		while (!st.isEmpty()) {
			cur = st.pop();
			System.out.println(cur.val + " ");
			
			if (cur.right != null) {
				st.push(cur.right);
			}
			
			if (cur.left != null) {
				st.push(cur.left);
			}
		}
	}

	public void preOrder(TreeNode root) {
		 if (root == null) return;
		 
		 System.out.println(root.val + " ");
		 if (root.left != null) preOrder(root.left);
		 if (root.right != null) preOrder(root.right);
	}
}
