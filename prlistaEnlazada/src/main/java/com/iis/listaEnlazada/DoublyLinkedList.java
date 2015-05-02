package com.iis.listaEnlazada;

public class DoublyLinkedList<Data> {

	public class DoublyLinkedNode {
		private DoublyLinkedNode prev;
		private DoublyLinkedNode next;
		private Data data;
	}

	private DoublyLinkedNode firstNode;
	private DoublyLinkedNode lastNode;

	public DoublyLinkedList() {
		firstNode = null;
		lastNode = null;
	}

	public void Forwards() {
		DoublyLinkedNode node = this.firstNode;
		while (node != null) {
			System.out.println(node.data + " -> ");
			node = node.next;
		}
	}

	public void Backwards() {
		DoublyLinkedNode node = this.lastNode;
		while (node != null) {
			System.out.println(node.data + " -> ");
			node = node.prev;
		}
	}

	public void insertAfter(DoublyLinkedNode node, DoublyLinkedNode newNode) {
		newNode.prev = node;
		newNode.next = node.next;
		if (node.next == null) {
			lastNode = newNode;
		} else {
			node.next.prev = newNode;
			node.next = newNode;
		}
	}

	public void insertBefore(DoublyLinkedNode node, DoublyLinkedNode newNode) {
		newNode.prev = node.prev;
		newNode.next = node;
		if (node.prev == null) {
			firstNode = newNode;
		} else {
			node.prev.next = newNode;
			node.prev = newNode;
		}
	}

	public void insertBeginning(DoublyLinkedNode newNode) {
		if (firstNode == null) {
			firstNode = newNode;
			lastNode = newNode;
			newNode.prev = null;
			newNode.next = null;
		} else {
			insertBefore(firstNode, newNode);
		}
	}

	public void insertEnd(DoublyLinkedNode newNode) {
		if (lastNode == null) {
			insertBeginning(newNode);
		} else {
			insertAfter(lastNode, newNode);
		}
	}

	public void remove(DoublyLinkedNode node) {
		if (node.prev == null) {
			firstNode = node.next;
		} else {
			node.prev.next = node.next;
		}
		if (node.next == null) {
			lastNode = node.prev;
		} else {
			node.next.prev = node.prev;
		}
		node = null;
	}
}
