/*
Challenge 5 - Path Sums with DFS
Write a program that takes as its input an instance of TreeNode<Integer> representing the root of a BST and a target int value and returns an int[][] containing the node values of all paths between the root and any leaf such that the sum of all the values of the nodes on the path equal the target value.

Hint: Use a depth-first search

Example: Given a target value of 22 and a BST with the following structure:

BST:
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \    / \
    7    2  5   1
There exist two paths from root to leaf that sum to 22: 5→4→11→2 and 5→8→4→5, so the output in this case would be an array of two arrays containing those values:

int[][] output = {
  { 5, 4, 11, 2 },
  { 5, 8, 4, 5 }
};
 */
import java.util.*;
public class AllPathSum {
	public static int[][] allPathSum(TreeNode<Integer> root, int target) {
		List<int[]> allPath = new ArrayList<>();
		LinkedList<Integer> currentPath = new LinkedList<>();
		currentPath.add(root.val);
		allPathSum(root, target, allPath, currentPath);
		int[][] ans = new int[allPath.size()][];
		int count = 0;
		for (int[] x : allPath) {
			ans[count++] = x;
		}
		return ans;
	}
	public static void allPathSum(TreeNode<Integer> root, int target, List<int[]> allPath, LinkedList<Integer> currentPath) {
		if (root.left == null && root.right == null) 
			if (target == root.val)
				allPath.add(toInt(currentPath));
				
		if (root.left != null) {
			currentPath.add(root.left.val);
			allPathSum(root.left, target - root.val, allPath, currentPath);
			currentPath.removeLast();
		}
		if (root.right != null) {
			currentPath.add(root.right.val);
			allPathSum(root.right, target - root.val, allPath, currentPath);
			currentPath.removeLast();
		}
		
		
	}
	public static int[] toInt(List<Integer> arr) {
		int[] ans = new int[arr.size()];
		int i = 0;
		for (int x : arr)
			ans[i++] = x;
		return ans;
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
		TreeNode<Integer> five2 = new TreeNode<>(5);
		five.left = four;
		five.right = eight;
		four.left = eleven;
		eight.left = thirteen;
		eight.right = four2;
		eleven.left = seven;
		eleven.right = two;
		four2.right = one;
		four2.left = five2;
		toString(allPathSum(five,22));
	}
	public static void toString(int[][] a) {
		for (int[] x: a) {
			for (int y:x)
				System.out.print(y+" ");
			System.out.println();
		}
	}
}