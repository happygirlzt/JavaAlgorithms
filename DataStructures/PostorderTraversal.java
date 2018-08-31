
/**
 * Postorder traversal iteratively and recursively
 * @author happygirlzt
 *
 */
import java.util.Stack;

public class PostorderTraversal {
	public void iteratively(TreeNode root) {
		if (root == null)
			return;
		// Create two stacks
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		TreeNode cur = root;
		s1.push(cur);

		// Run while s1 is not empty()
		while (!s1.isEmpty()) {
			cur = s1.pop();
			s2.push(cur);

			if (cur.left != null) {
				s1.push(cur.left);
			}

			if (cur.right != null) {
				s1.push(cur.right);
			}
		}
		
		// All nodes are in s2
		while (!s2.isEmpty()) {
			TreeNode tmp = s2.pop();
			System.out.println(tmp.val + " ");
		}
	}
	
	public void postOrder(TreeNode root) {
		if (root == null) return;
		
		if (root.left != null) postOrder(root.left);
		if (root.right != null) postOrder(root.right);
		System.out.println(root.val + " ");
 	}
}
