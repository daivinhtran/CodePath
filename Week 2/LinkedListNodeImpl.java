public class LinkedListNodeImpl<E> implements LinkedListNode<E> {
    private E value = null;
    private LinkedListNode next;

    public LinkedListNodeImpl() {
        value = null;
    }

    @Override
    public E getValue() {
        return value;
    }
    @Override
    public void setValue(E value) {
        this.value = value;
    }
    @Override
    public LinkedListNode<E> getNext() {
        return this.next;
    }
    @Override
    public void setNext(LinkedListNode<E> next) {
        this.next = next;
    }
    @Override
    public void setValuesFromArray(E[] listValues) {
        if (listValues != null || listValues.length != 0) {
            this.setValue(listValues[0]);
            LinkedListNode current = this;
            int count = 0;
            while (++count < listValues.length) {
                current.setNext(new LinkedListNodeImpl<E>());
                current = current.getNext();
                current.setValue(listValues[count]);
                
            }
        }
    }
}