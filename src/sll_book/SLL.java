package sll_book;

public class SLL<E> {
    private SLLNode<E> first;   // first node in the list

    public SLL() {
        // create an empty SLL
        this.first = null;
    }

    // methods of SLL

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp.element;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += "->" + tmp.element;
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, null);
        ins.succ = first;
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadeniot jazol e null");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = new SLLNode<E>(o, null);
        } else {
            insertFirst(o);
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            // if first!=before
            while (tmp.succ != before && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (!tmp.element.equals(o) && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element.equals(o)) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return null;
    }

    public void deleteList() {
        first = null;
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public int size() {
        int listSize = 0;
        SLLNode<E> tmp = first;
        while (tmp != null) {
            listSize++;
            tmp = tmp.succ;
        }
        return listSize;
    }

    public void mirror() {
        if (first != null) {
            // m = nextSucc, p = tmp, q = next
            SLLNode<E> tmp = first;
            SLLNode<E> newSucc = null;
            SLLNode<E> next;

            while (tmp != null) {
                next = tmp.succ;
                tmp.succ = newSucc;
                newSucc = tmp;
                tmp = next;
            }
            first = newSucc;
        }
    }

    public void rearrange() {
        // 1. fin the middle of the list
        SLLNode<E> middle = this.getFirst();
        for (int i = 1; i < this.size() / 2; i++)
            middle = middle.succ;
        System.out.print(middle.element);

        // 2. divide the list into 2 halves
        // node1, first node from the first half 1->2->3
        // node2, first node from the second half 4->5
        SLLNode<E> node1 = this.getFirst();
        SLLNode<E> node2 = middle.succ;
        middle.succ = null;

        // 3. reverse the second half 5->4
        node2.reverseList(node2);

        // 4. alternately merge the lists
        SLLNode<E> node = new SLLNode<E>(null, null);   // auxiliary node

        // curr is pointer towards the auxiliary node
        // from where the new list will be created
        SLLNode<E> curr = node;
        while (node1 != null || node2 != null) {
            // first add a node from the first list
            if (node1 != null) {
                curr.succ = node1;
                curr = curr.succ;
                node1 = node1.succ;
            }

            // then add a node from the second list
            if (node2 != null) {
                curr.succ = node2;
                curr = curr.succ;
                node2 = node2.succ;
            }
        }

        // remove the auxiliary node
        node = node.succ;
    }
}
