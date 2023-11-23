package sll_book;

public class SLLNode<E> {
    protected E element;    // element of the node
    protected SLLNode<E> succ;  // pointer towards the next node

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    public SLLNode<E> reverseList(SLLNode<E> node) {
        SLLNode<E> prev = null;
        SLLNode<E> curr = node;
        SLLNode<E> next;

        while (curr != null) {
            next = curr.succ;
            curr.succ = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
