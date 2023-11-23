package sll_book;

public class SLLNode<E> {
    protected E element;    // element of the node
    protected SLLNode<E> succ;  // pointer towards the next node

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    public SLLNode(E element) {
        this.element = element;
        this.succ = null;
    }
}