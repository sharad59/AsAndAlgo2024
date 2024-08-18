package Heap;

import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
//Time Complexity = nlog k (n is total nodes logk for heapify)
	static class Node {
	    int data;
	    Node next;
	 
	    Node(int key)
	    {
	        data = key;
	        next = null;
	    }
	}
	
	 static Node mergeKList(Node[] arr, int K)
	    {

	        PriorityQueue<Node> queue
	            = new PriorityQueue<>((a,b)->{return a.data-b.data;});
	        
	        Node head = new Node(0);
	        Node last = head;
	        // Push the head nodes of all
	        // the k lists in 'queue'
	        for (int i = 0; i < K; i++) {
	            if (arr[i] != null) {
	                queue.add(arr[i]);
	            }
	        }
	        // Handles the case when k = 0
	        // or lists have no elements in them
	        if (queue.isEmpty())
	            return null;
	        
			while (!queue.isEmpty()) {
				Node curr = queue.poll();
				last.next = curr;
				last = last.next;
				if (curr.next != null) {
					queue.add(curr.next);
				}
			}

	        return head.next;
	    }
	    public static void printList(Node node)
	    {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	
	    public static void main(String[] args)
	    {
	        int N = 3;
     Node[] a = new Node[N];
	       
	        // Linkedlist1
	        Node head1 = new Node(1);
	        a[0] = head1;
	        head1.next = new Node(3);
	        head1.next.next = new Node(5);
	          head1.next.next.next = new Node(7);
	       
	        // Limkedlist2
	        Node head2 = new Node(2);
	        a[1] = head2;
	        head2.next = new Node(4);
	          head2.next.next = new Node(6);
	          head2.next.next.next = new Node(8);
	       
	        // Linkedlist3
	        Node head3 = new Node(0);
	        a[2] = head3;
	        head3.next = new Node(9);
	          head3.next.next = new Node(10);
	          head3.next.next.next = new Node(11);
	 
	        Node res = mergeKList(a, N);
	 
	        if (res != null)
	            printList(res);
	        System.out.println();
	    }
}
