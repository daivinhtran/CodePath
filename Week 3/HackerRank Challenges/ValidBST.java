/*input
5
3
1 2 3
3
2 1 3
6
3 2 1 5 4 6
4
1 3 4 2
5
3 4 5 1 2
*/
import java.util.*;

public class ValidBST {

	static class Node{
		int data;
		boolean left = false;
		boolean right = false;
		int min;
		int max;
		Node(int data, int min, int max) {
			this.data = data;
			this.min = min;
			this.max = max;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int queries = scan.nextInt();
		for (int query = 0; query < queries; query++) {
			int n = scan.nextInt();
			int[] nodes = new int[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = scan.nextInt();
			}
			System.out.println(isValid(nodes));
			// System.out.println("---------");
		}
	}
	public static String isValid(int[] nodes) {
		int n = nodes.length;
		Stack<Node> stack = new Stack<>();
		stack.add(new Node(nodes[0], 1, n));
		// System.out.println(stack.peek().data);
		for (int i = 1; i < n; i++) {

			while (!stack.isEmpty() && (nodes[i] > stack.peek().max || nodes[i] < stack.peek().min)) {
				// System.out.println(stack.peek().data);
				stack.pop();
			}

			//System.out.println(temp.data+" min ="+temp.min+" max= "+temp.max);
			if (stack.isEmpty()) {
				// System.out.println("Empty stack");
				return "NO";
			}
			Node temp = stack.peek();
			if (nodes[i] < temp.data) {
				if (temp.left == true || temp.right == true)
					return "NO";
				temp.left = true;
				stack.add(new Node(nodes[i], temp.min, temp.data));
			}
			else {
				if (temp.right == true)
					return "NO";
				temp.right = true;
				stack.add(new Node(nodes[i], temp.data, temp.max));	
			}


		}
		return "YES";
	}
}
(A(B(D(E(G))))(C(F)))