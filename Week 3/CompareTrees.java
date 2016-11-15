public class CompareTrees {
	public static <E> boolean compareTree(TreeNode<E> root1, TreeNode<E> root2) {
		if (root1 == null && root2 == null)
			return true;
		if (equalNode(root1,root2))
			return compareTree(root1.left, root2.left) && compareTree(root1.right, root2.right);
		return false;
	}
	public static <E> boolean equalNode(TreeNode<E> root1, TreeNode<E> root2) {		
		if (root1 == null || root2 == null)
			return false;
		return root1.val.equals(root2.val);

	}
	public static void main(String[] args) {
		TreeNode<Integer> zero = new TreeNode<>(0);
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> two = new TreeNode<>(2);
		TreeNode<Integer> zero1 = new TreeNode<>(0);
		TreeNode<Integer> one1 = new TreeNode<>(1);
		TreeNode<Integer> two1 = new TreeNode<>(2);
		zero.left = one;
		zero.right = two;
		zero1.left = one1;
		zero1.right = two1;
		System.out.println(compareTree(zero, zero1));
	}
}