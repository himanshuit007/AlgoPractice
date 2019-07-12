package com.him.Linkedlist;

public class SinglyLinkedList {
	private SingleNode head;

	// head --> null
	// head --> 1->null
	// Head --> 1->2->3->4->null
	private SingleNode createNode(String item) {
		return new SingleNode(item);
	}

	public void insertAtBegining(String item) {
		SingleNode newNode = createNode(item);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertAtPosition(String item, int pos) {
		int counter = 0;
		if (pos < 0) {
			throw new RuntimeException("Postions can't be less than 0");
		}
		SingleNode newNode = createNode(item);
		if (head == null && counter != pos) {
			return;
		} else {
			SingleNode temp = head, last = null;
			while (temp != null) {
				if (counter == pos) {
					break;
				}
				last = temp;
				temp = temp.next;
				counter++;
			}
			if (counter != pos)
				throw new RuntimeException("Postions out of bound");
			newNode.next = temp;
			if (last != null)
				last.next = newNode;
			else
				head = newNode;
		}
	}

	public String deleteAtBegining() {
		String data = null;
		if (head == null)
			data = null;
		else {
			data = head.data;
			head = head.next;
		}
		return data;
	}

	public void insertAtEnding(String item) {
		SingleNode newNode = createNode(item);
		if (head == null) {
			head = newNode;
			return;
		} else {
			SingleNode temp = head, last = head;

			while (temp != null) {
				last = temp;
				temp = temp.next;
			}
			last.next = newNode;
		}
	}

	public String deleteAtEnding() {
		String data = null;
		if (head == null) {
			data = null;
		} else {// 3-null
			SingleNode temp = head, last = null, prev = null;
			while (temp != null) {
				prev = last;
				last = temp;
				temp = temp.next;
			}

			if (prev == null) {
				data = head.data;
				head = null;
			} else {
				data = prev.next.data;
				prev.next = null;

			}
		}
		return data;
	}

	public void iterate() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		SingleNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println();
	}

	public int count() {
		SingleNode temp = head;
		int counter = 0;
		while (temp != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}

	public void deleteList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		SingleNode temp;
		while (head != null) {
			temp = head;
			head = head.next;
			temp = null;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList l = new SinglyLinkedList();
		for (int j = 0; j < 10; j++) {
			l.insertAtBegining(String.valueOf(j));
		}
		l.iterate();
		System.out.println("Count " + l.count());

		for (int j = 0; j < 11; j++) {
			l.iterate();
			System.out.println(l.deleteAtBegining());
		}

		for (int j = 0; j < 10; j++) {
			l.insertAtEnding(String.valueOf(j));
		}
		l.iterate();
		System.out.println("Count " + l.count());

		for (int j = 0; j < 11; j++) {
			l.iterate();
			System.out.println(l.deleteAtEnding());
		}
		for (int j = 0; j < 10; j++) {
			l.insertAtPosition(String.valueOf(j), 1);
			l.iterate();
		}
		l.insertAtPosition(String.valueOf(000), 0);
		l.insertAtPosition(String.valueOf(999), 1);
		l.insertAtPosition(String.valueOf(0), 0);
		l.insertAtPosition(String.valueOf(9), 3);
		l.iterate();

		l.deleteList();
		System.out.println("After deleting list");
		l.iterate();
	}
}
