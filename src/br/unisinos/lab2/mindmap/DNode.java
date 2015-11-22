package br.unisinos.lab2.mindmap;

public class DNode<E> {
    protected E element;
    protected DNode<E> son;
    protected DNode<E> bro;

    public DNode(E e) {
        element = e;
        son = bro = null;
    }

    public E getElement() {
        return element; 
    }

    public DNode<E> getSon() { 
        return son;
    }

    public DNode<E> getBro() { 
        return bro;
    }

    public void setElement(E e) { 
        element = e; 
    }

    public void setSon(DNode<E> p) {
        son = p; 
    }

    public void setBro(DNode<E> n) {
        bro = n; 
    }
}
