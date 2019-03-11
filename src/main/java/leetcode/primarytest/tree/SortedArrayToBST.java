package leetcode.primarytest.tree;

public class SortedArrayToBST {
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5};
		new SortedArrayToBST().sortedArrayToBST(nums);
	}
	
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (nums.length == 1) return root;
        BuildBST(nums, 0, mid - 1, root, true);
        BuildBST(nums, mid + 1, nums.length - 1, root, false);
        return root;
    }
    
    public void BuildBST(int[] nums, int start, int end, TreeNode parent, boolean left) {
    	if (start > end) return;
    	int mid = start + (end - start) / 2;
    	TreeNode node = new TreeNode(nums[mid]);
    	if (left) parent.left = node;
    	else parent.right = node;
    	if (start == end) return;
    	BuildBST(nums, start, mid - 1, node, true);
    	BuildBST(nums, mid + 1, end, node, false);
    }
}
