import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Task2 {
    public static class LinkedListNode{
        int val;
        LinkedListNode next;
    
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };
    
    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }
    
	static LinkedListNode removeNodes(LinkedListNode list, int x) {
        LinkedListNode head = list;
        while (head.val > x)
            head = head.next;
        LinkedListNode current = head;
        while (current != null) {
            while (current.next !=null && current.next.val > x)
                current.next = current.next.next;
            current = current.next;
        }
        return head;

    }
    
}