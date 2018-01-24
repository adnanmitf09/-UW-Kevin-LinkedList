package com.upwork.kevin;
/**
 * Design an int type singly linkedlist class, and then implement some functions below using the self designed class.
 * Can not use Java built in List interface
	1. Append an element into the linkedlist
	2. Remove the tail element from a linkedlist
	3. Remove all element in the linkedlist that is great than a target value
 * @author MuhammadAdnan
 * @since Jan 24, 2018
 */
public class SinglyLinkedList {

	/**
	 * Node structure
	 */
	public class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}	

	// head node
	private Node head;

	// Required functions
	// 1. Append an element into the linkedlist
	public void appendElement(int value) {
		Node dataNode = new Node(value); 
		if(null == head) {  // if list is empty, assign node to the head
			head = dataNode;
		}else {  // otherwise, add new node to the end
			Node tempNode = head;
			while(null != tempNode.next) {
				tempNode = tempNode.next;
			}
			tempNode.next = dataNode;
		}
	}

	// 2. Remove the tail element from a linkedlist
	public void removeTail() {
		if(null != head) {  // if head is null, there is no node
			if(null == head.next) { // there is only one node which is tail as well, remove it
				head = null;
			}else {

				Node tempNode = head;
				Node nextNode = tempNode.next;
				while(null != nextNode.next) {
					tempNode = nextNode;
					nextNode = tempNode.next;
				}
				tempNode.next = null;
			}
		}
	}

	// 3. Remove all element in the linkedlist that is great than a target value
	public void removeGreaterThan(int value) {
		if(null != head) {  // if head is null, there is no node
			if(null == head.next) { // there is only one node
				if(head.data > value) {
					head = null;
				}
			}else {

				Node preNode = head;
				//special case
				if(head.data > value) {
					head = head.next;
				}
				Node currentNode = preNode.next;
				while(null != currentNode) {
					if(currentNode.data > value) {
						preNode.next = currentNode.next;
						if(null == currentNode.next) {
							break;	
						}
						currentNode = preNode.next;

					}else {
						preNode = currentNode;
						currentNode = preNode.next;
					}

				}
			}
		}
	}
	@Override
	public String toString() {
		String data = "[";

		if(null != head) {  
			Node tempNode = head;
			while(null != tempNode) {
				data+=tempNode.data;
				tempNode = tempNode.next;
				if(null != tempNode) {
					data+=",";
				}

			}

		}
		data += "]";

		return data;
	}

	
	public static void main(String[] args) {
		// Test
		System.out.println("Testing...");
		System.out.println("Appending Element...");
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.appendElement(178);
		singlyLinkedList.appendElement(4);
		singlyLinkedList.appendElement(100);
		singlyLinkedList.appendElement(45);
		singlyLinkedList.appendElement(67);
		singlyLinkedList.appendElement(89);
		singlyLinkedList.appendElement(95);
		singlyLinkedList.appendElement(156);
		System.out.println(singlyLinkedList);

		System.out.println("Removing Tail...");
		singlyLinkedList.removeTail();
		System.out.println(singlyLinkedList);


		int n = 50;
		System.out.println(String.format("Removing Greater than %d ...",n));
		singlyLinkedList.removeGreaterThan(n);
		System.out.println(singlyLinkedList);
		


		
	}

}