package br.unisinos.lab2.mindmap;

public class Node<E> {
	private E element;
	private Node<E> prev;
	private Node<E> next;

	public Node(E e) {
		element = e;
		prev = next = null;
	}

	public E getElement() {
		return element; 
	}

	public Node<E> getSon() { 
		return prev;
	}

	public Node<E> getBrother() { 
		return next;
	}

	public void setElement(E e) { 
		element = e; 
	}

	public void setSon(Node<E> p) {
		prev = p; 
	}

	public void setBrother(Node<E> n) {
		next = n; 
	}
}

