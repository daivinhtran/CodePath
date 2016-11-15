public class CountLeafNodes {
	public static <E> int countLeaf(TreeNode<E> root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		else
			return (countLeaf(root.left) + countLeaf(root.right));
	}
	public static void main(String[] args) {
		TreeNode<Integer> zero = new TreeNode<>(0);
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> two = new TreeNode<>(2);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> four = new TreeNode<>(4);
		TreeNode<Integer> five = new TreeNode<>(5);
		TreeNode<Integer> six = new TreeNode<>(6);
		two.left = one;
		two.right = three;
		three.right = four;
		three.left = zero;
		System.out.println(countLeaf(two));
	}
	
}