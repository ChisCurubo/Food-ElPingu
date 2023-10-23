package co.edu.upb.estructuras.listas;

import co.edu.upb.estructuras.node.Node;

import java.io.Serializable;
/**
 *@author ChristianRodriguez
 */
public class DoubleListNode<T extends Serializable> extends Node<T> implements Serializable {
    private static final long serialVersionUID = 2525693509033756847L;
    DoubleListNode<T> next;
    DoubleListNode<T> prev;


    public DoubleListNode() {
        super();
        this.next = null;
        this.prev = null;
    }

    public DoubleListNode(T object) {
        super(object);
        this.next = null;
        this.prev = null;
    }

    public DoubleListNode(T object, DoubleListNode<T> next) {
        super(object);
        this.next = next;
        this.prev = null;
    }

    public DoubleListNode(T object, DoubleListNode<T> next, DoubleListNode<T> previus) {
        super(object);
        this.next = next;
        this.prev = previus;
    }

    public DoubleListNode<T> getNext() {
        return this.next;
    }

    public void setNext(DoubleListNode<T> next) {
        this.next = next;
    }

    public DoubleListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleListNode<T> prev) {
        this.prev = prev;
    }
}


