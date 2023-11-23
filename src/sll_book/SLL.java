package sll_book;

public class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
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
        // SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            //ako first!=before
            while (tmp.succ != before && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                tmp.succ = new SLLNode<E>(o, before);
                ;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
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

    public SLLNode<E> getFirst() {
        return first;
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

    public void merge(SLL<E> in) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
    }

    public void mirror() {
        if (first != null) {
            // m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while (tmp != null) {
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }
    }

    public void insert(E data) {
        SLLNode<E> newNode = new SLLNode<>(data);
        if (first == null) {
            first = newNode;
        } else {
            SLLNode<E> current = first;
            while (current.succ != null) {
                current = current.succ;
            }
            current.succ = newNode;
        }
    }

    public void rearrange() {
        if (first == null || first.succ == null) {
            return;
        }

        // Најди го средниот јазол со техниката на брз и бавен покажувач
        SLLNode<E> slow = first;
        SLLNode<E> fast = first;

        while (fast.succ != null && fast.succ.succ != null) {
            slow = slow.succ;
            fast = fast.succ.succ;
        }

        // Преврти го вториот дел од листата
        SLLNode<E> secondHalf = reverseList(slow.succ);
        slow.succ = null;

        // Спои ги двата дела на листата
        SLLNode<E> firstHalf = first;
        while (firstHalf != null && secondHalf != null) {
            SLLNode<E> temp1 = firstHalf.succ;
            SLLNode<E> temp2 = secondHalf.succ;

            firstHalf.succ = secondHalf;
            secondHalf.succ = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }

    private SLLNode<E> reverseList(SLLNode<E> node) {
        SLLNode<E> prev = null;
        SLLNode<E> current = node;

        while (current != null) {
            SLLNode<E> nextNode = current.succ;
            current.succ = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public void printList() {
        SLLNode<E> current = first;
        while (current != null) {
            System.out.print(current.element);
            if (current.succ != null) {
                System.out.print("->");
            }
            current = current.succ;
        }
        System.out.println();
    }
}
