/*
Challenge 4 - Path Sum with BFS
Write a program that takes as its input an instance 
of TreeNode<Integer> representing the root of a BST and 
a target int value and returns a boolean value which is 
true if the tree contains a path between the root and any
leaf such that the sum of all the values of the nodes on
the path equal the target value.

Hint: Use a breadth-first search

Example: Given a target value of 22 and a BST
 with the followingstructure:

BST:
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
The path 5→4→11→2 sums to 22, so the output in this case would be true.
 */
import java.util.Queue;
import java.util.LinkedList;
public class PathSum {
	public static boolean pathSumDFS(TreeNode<Integer> root, int target) {
		if (root == null) 
			return (target == 0);
		return pathSumDFS(root.left, target - root.val) || pathSumDFS(root.right, target - root.val);
	}
	public static boolean pathSumBFS(TreeNode<Integer> root, int target) {
		Queue<TreeNode<Integer>> queueNode = new LinkedList<>();
		Queue<Integer> queueTarget = new LinkedList<>();
		queueNode.add(root);
		queueTarget.add(target);
		while (!queueNode.isEmpty()) {
			TreeNode<Integer> node = queueNode.poll();
			int targetNum = queueTarget.poll();
			if (node.left == null && node.right == null && targetNum == node.val)
				return true;
			if (node.left != null) {
				queueNode.add(node.left);
				queueTarget.add(targetNum - node.val);
			}
			if (node.right != null) {
				queueNode.add(node.right);
				queueTarget.add(targetNum - node.val);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		TreeNode<Integer> five = new TreeNode<>(5);
		TreeNode<Integer> four = new TreeNode<>(4);
		TreeNode<Integer> eight = new TreeNode<>(8);
		TreeNode<Integer> four2 = new TreeNode<>(4);
		TreeNode<Integer> thirteen = new TreeNode<>(13);
		TreeNode<Integer> one = new TreeNode<>(1);
		TreeNode<Integer> two = new TreeNode<>(2);
		TreeNode<Integer> seven = new TreeNode<>(7);
		TreeNode<Integer> eleven = new TreeNode<>(11);
		five.left = four;
		five.right = eight;
		four.left = eleven;
		eight.left = thirteen;
		eight.right = four2;
		eleven.left = seven;
		eleven.right = two;
		four2.right = one;
		System.out.println(pathSumBFS(five,22));

	}
}