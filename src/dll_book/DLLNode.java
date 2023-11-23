package dll_book;

public class DLLNode<E> {
    protected E element;    // елементот на јазелот
    protected DLLNode<E> pred, succ;    // покажвачи кон претходниот и следниот јазел

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }
}
