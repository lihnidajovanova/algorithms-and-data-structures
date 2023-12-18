/*
package laboratory_exercise_8_trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

interface Tree<E> {
    ////////////Accessors

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator
    public Iterator<E> children(Node<E> node);

}

interface Node<E> {
    public E getElement();

    public void setElement(E elem);

    int compareTo(E e);
}


class SLLTree<E> implements Tree<E> {
    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {
        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }

    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i = 0; i < level; i++)
            System.out.print(" ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>) node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level + 1);
            tmp = tmp.sibling;
        }
    }

    public void printTree() {
        printTreeRecursive(root, 0);
    }

    //PATH !!!!
    public void PATH(Node<E> node) {

        if (((SLLNode<E>) node).parent == null)
            System.out.print("c:/");
        else {
            PATH(((SLLNode<E>) node).parent);
            System.out.print("" + ((SLLNode<E>) node).element.toString() + "/");
        }

    }

    //PRINT
    public void PRINT() {
        printTreeRecursive(root, 0);
    }


    //BACK
    public Node<E> BACK(Node<E> node) {
        node = ((SLLNode<E>) node).parent;
        return node;

    }

    //COMPARE
    public int COMPARE(Node<E> a, Node<E> b) {
        SLLNode<E> c = (SLLNode<E>) a;
        SLLNode<E> d = (SLLNode<E>) b;
        return c.element.compareTo(d.element);

    }

    //CREATE
    public Node<E> CREATE(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;

        curr.firstChild = tmp;
        tmp.parent = curr;

        SORT(curr.firstChild);
        return tmp;
    }

    //SORT so zamena na vrednost na ELEMENT,FIRSTCHILD,i parents na FIRSTCHILD
    public void SORT(Node<E> node) {
        SLLNode<E> tmp1 = (SLLNode<E>) node;
        SLLNode<E> tmp2 = (SLLNode<E>) node;
        SLLNode<E> pomParent = null;
        SLLNode<E> pomChild = null;
        E pom = null;

        while (tmp1 != null) {
            tmp2 = tmp1;

            while (tmp2 != null) {
                if (tmp2.element.compareTo(tmp1.element) < 0) {
                    pom = tmp1.element;
                    pomChild = tmp1.firstChild;

                    tmp1.element = tmp2.element;
                    tmp1.firstChild = tmp2.firstChild;
                    pomParent = tmp1.firstChild;
                    while (pomParent != null) {
                        pomParent.parent = tmp1;
                        pomParent = pomParent.sibling;
                    }

                    tmp2.element = pom;
                    tmp2.firstChild = pomChild;
                    pomParent = tmp2.firstChild;
                    while (pomParent != null) {
                        pomParent.parent = tmp2;
                        pomParent = pomParent.sibling;
                    }

                }

                tmp2 = tmp2.sibling;

            }
            tmp1 = tmp1.sibling;

        }

    }

    //POSTAVI se postavuva node na pocetok zaedno so site negovi child
    public void postavi(Node<E> parent, Node<E> child) {

        SLLNode<E> dete = (SLLNode<E>) child;
        SLLNode<E> tmp = new SLLNode<E>(dete.element);
        SLLNode<E> roditel = (SLLNode<E>) parent;
        tmp.sibling = roditel.firstChild;
        roditel.firstChild = tmp;
        tmp.parent = roditel;
        tmp.firstChild = dete.firstChild;


    }

    //OPEN od cel prostor (ima kolizija na iminja)so koristenje na druga klasa PomosnaCLASS kade se cuva staticki objekt

    public SLLNode<E> OPEN(String elem) {

        SEARCH(root, elem);
        return PomosnaCLASS.tmp;
    }

    //OPEN vo daden FOLDER
    public SLLNode<E> OPEN(Node<E> node, String elem) {
        SLLNode<E> folder = (SLLNode<E>) node;
        SLLNode<E> tmp = folder.firstChild;
        while (tmp != null) {
            if (((String) tmp.element).equals(elem))
                return tmp;
            tmp = tmp.sibling;

        }
        return tmp;
    }


    //DELETE od cel prostor (isti iminja kolizija!)so koristenje na druga klasa PomosnaCLASS kade se cuva staticki objekt
    public void DELETE(String elem) {

        SEARCH(root, elem);
        remove(PomosnaCLASS.tmp);
    }

    //DELETE vo daden FOLDER
    public void DELETE(Node<E> node, String elem) {
        SLLNode<E> folder = (SLLNode<E>) node;
        SLLNode<E> tmp = folder.firstChild;
        while (tmp != null) {
            if (((String) tmp.element).equals(elem)) {
                remove(tmp);
                return;
            }
            tmp = tmp.sibling;

        }

    }

    //gi izminuva site elementi i ako najde ednakov ke go stavi vo PomosnaCLASS static promenlivata
    public void SEARCH(Node<E> node, String elem) {

        SLLNode<E> curr = (SLLNode<E>) node;
        if (node == null)
            return;

        SLLNode<E> tmp;
        if (((String) curr.element).equals(elem)) {
            PomosnaCLASS.tmp = curr;
        }

        tmp = ((SLLNode<E>) node).firstChild;
        while (tmp != null) {
            SEARCH(tmp, elem);
            tmp = tmp.sibling;
        }
    }
}

class SLLNode<P> implements Node<P> {
    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }

    @Override
    public int compareTo(P e) {
        return element.compareTo(e);
    }

}

//se koristi zaradi static tmp inace useless
class PomosnaCLASS {
    public static SLLNode tmp;
}

public class WindowsExplorer {
    public static void main(String[] args) throws Exception {
        int i, j, k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];

        for (i = 0; i < N; i++)
            commands[i] = br.readLine();

        br.close();

        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");

        // vasiot kod stoi ovde
        Node<String> current = tree.root;
        String niza[];

        for (i = 0; i < N; i++) {
            //ako vlezot se sostoi od 2 zborovi
            if (commands[i].contains(" ")) {
                niza = commands[i].split(" ");
            }

            //ako vlezot e od 1 komanda (zbor)
            else {
                niza = new String[1];
                niza[0] = commands[i];
            }

            if (niza[0].equals("CREATE"))
                tree.CREATE(current, niza[1]);

            if (niza[0].equals("OPEN"))
                current = tree.OPEN(current, niza[1]);

            if (niza[0].equals("DELETE"))
                tree.DELETE(current, niza[1]);

            if (niza[0].equals("PATH")) {
                tree.PATH(current);
                System.out.println("");
            }

            if (niza[0].equals("PRINT"))
                tree.PRINT();

            if (niza[0].equals("BACK"))
                current = tree.BACK(current);
        }
    }
}*/
