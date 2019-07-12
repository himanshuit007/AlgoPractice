package com.him.Linkedlist;

public class SingleNode {
	String data;
	SingleNode next;

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	public SingleNode(String data) {
		super();
		this.data = data;
	}

}