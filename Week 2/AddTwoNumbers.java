public class AddTwoNumbers {
	public static void main(String[] args) {
		Integer[] listValues1 = new Integer[] {1 };
		LinkedListNode<Integer> head1 = new LinkedListNodeImpl<>();
        head1.setValuesFromArray(listValues1);

        Integer[] listValues2 = new Integer[] {9, 9, 9};
        LinkedListNode<Integer> head2 = new LinkedListNodeImpl<>();
        head2.setValuesFromArray(listValues2);

        LinkedListNode<Integer> headSum = add(head1,head2);
    	LinkedListNode<Integer> current = headSum;
        while (current != null) {
        	System.out.print(current.getValue()+(current.getNext()==null?"":"->"));
        	current = current.getNext();
        }

	}
	public static LinkedListNode<Integer> add(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
		LinkedListNode<Integer> headSum = new LinkedListNodeImpl<>();
		LinkedListNode<Integer> currentSum = headSum;
		LinkedListNode<Integer> current1 = head1;
		LinkedListNode<Integer> current2 = head2;
		int carry = 0;
		while (current1 != null || current2 != null) {
			int digit1 = (current1 != null) ? current1.getValue() : 0;
			int digit2 = (current2 != null) ? current2.getValue() : 0;
			int sum = (digit1 + digit2 + carry);
			currentSum.setValue(sum % 10);
			carry = sum / 10;
			current1 = (current1 != null) ? current1.getNext() : null;
			current2 = (current2 != null) ? current2.getNext() : null;
			if (current1 != null || current2 !=null || carry == 1) {
				currentSum.setNext(new LinkedListNodeImpl<Integer>());
				currentSum = currentSum.getNext();
			}
		}
		if (carry == 1)
			currentSum.setValue(1);
		return headSum;

	}

}