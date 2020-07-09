/**
 * Created by happygirlzt on 9 Jul 2020
 * 
 * Range sum query https://leetcode.com/problems/range-sum-query-mutable/
 */
public class SegmentTree {
    // Memory Limit Exceeded Error!!!
    class NumArray {
        int[] tree;
        int n;
        int[] a;
        // Build the segment tree
        private void buildTree(int[] nums, int node, int start, int end) {
            // System.out.println(Arrays.toString(tree));
            if (start == end) {
                tree[node] = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                buildTree(nums, 2 * node, start, mid);
                buildTree(nums, 2 * node + 1, mid + 1, end);
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }
    
        public NumArray(int[] nums) {
            n = nums.length;
            if (n == 0) return;
            a = new int[n + 1];
            tree = new int[(int) Math.pow(2, n)];
            System.arraycopy(nums, 0, a, 1, n);
            buildTree(a, 1, 1, n);
        }
    
        private void updateTree(int node, int start, int end, int i, int val) {
            if (start == end) {
                tree[node] = val;
                a[i] = val;
            } else {
                int mid = start + (end - start) / 2;
                if (start <= i && i <= mid) { // left part
                    updateTree(node * 2, start, mid, i, val);
                } else {
                    updateTree(node * 2 + 1, mid + 1, end, i, val);
                }
    
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }
    
        public void update(int i, int val) {
            updateTree(1, 1, n, i + 1, val);
        }
    
        public int sumRange(int i, int j) {
            return query(1, 1, n, i + 1, j + 1);
        }
    
        private int query(int node, int start, int end, int i, int j) {
            // outside
            if (j < start || i > end) return 0;
            if (i <= start && end <= j) return tree[node];
            int mid = start + (end - start) / 2;
            return query(node * 2, start, mid, i, j) + query(node * 2 + 1, mid + 1, end, i, j);
        }
    }

    // Use TreeNode
    class NumArray {
        class TreeNode {
            TreeNode left, right;
            int start, end;
            int sum;
            public TreeNode(int s, int e) {
                left = null;
                right = null;
                start = s;
                end = e;
            }
        }

        TreeNode root = null;
        private TreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) return null;
            TreeNode res = new TreeNode(start, end);
            if (start == end) {
                res.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                res.left = buildTree(nums, start, mid);
                res.right = buildTree(nums, mid + 1, end);
                res.sum = res.left.sum + res.right.sum;
            }

            return res;
        }

        public NumArray(int[] nums) {            
            root = buildTree(nums, 0, nums.length - 1);
        }
        
        private void update(TreeNode root, int i, int val) {
            if (root.start == root.end) {
                root.sum = val;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (i <= mid) {
                    update(root.left, i, val);
                } else {
                    update(root.right, i, val);
                }

                root.sum = root.left.sum + root.right.sum;
            }
        }
        public void update(int i, int val) {
            update(root, i, val);
        }
        

        private int query(TreeNode root, int i, int j) {
            if (j == root.end && i == root.start) {
                return root.sum;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (j <= mid) {
                    return query(root.left, i, j);
                } else if (i >= mid + 1) {
                    return query(root.right, i, j);
                } else {
                    return query(root.right, mid + 1, j) + query(root.left, i, mid);
                }
            }
        }
        public int sumRange(int i, int j) {
            return query(root, i, j);
        }
    }
}