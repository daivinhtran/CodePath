public class IdentifyBST<E extends Comparable<E>> {

	public boolean isValidBST(TreeNode<E> root) {
        if (root == null)
            return true;
        return isValidBST(root.left, root.val, root.val, 0) && isValidBST(root.right, root.val, root.val, 1);
    }

    public boolean isValidBST(TreeNode<E> root , E min, E max, int dir) {
        if (root == null) return true;
        int dirLeft = dir;
        int dirRight = dir;
        boolean valid = true;
        boolean smaller = root.val.compareTo(max) < 0 ;
        boolean larger = root.val.compareTo(min) > 0;
        if (dir == 0) {
            valid = smaller;
            dirRight = 2;
        }
        else if (dir == 1) { 
            valid = larger;
            dirLeft = 2;
        }
        else
            valid = smaller && larger;
        return valid && isValidBST(root.left, min, root.val, dirLeft) && isValidBST(root.right, root.val, max, dirRight);
    }
	public static void main(String[] args) {
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> two = new TreeNode<>(2);
		TreeNode<Integer> three = new TreeNode<>(3);
		TreeNode<Integer> four = new TreeNode<>(4);
		TreeNode<Integer> five = new TreeNode<>(5);
		TreeNode<Integer> six = new TreeNode<>(6);
		two.left = one;
		two.right = three;
		three.right = four;
		IdentifyBST<Integer> x = new IdentifyBST<>();
		System.out.println(x.isValidBST(two));
	}
}