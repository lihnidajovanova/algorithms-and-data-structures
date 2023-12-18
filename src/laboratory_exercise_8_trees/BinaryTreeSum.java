package laboratory_exercise_8_trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BNode<E> {
    public E info;
    public BNode<E> left;
    public BNode<E> right;

    static int LEFT = 1;
    static int RIGHT = 2;

    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }

    public BNode() {
        this.info = null;
        left = null;
        right = null;
    }

    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
}

class BTree<E extends Comparable<E>> {
    public BNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(E info) {
        root = new BNode<>(info);
    }

    public void makeRoot(E elem) {
        root = new BNode<>(elem);
    }

    public void makeRootNode(BNode<E> node) {
        root = node;
    }

    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        BNode<E> tmp = new BNode<>(elem);
        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }
        return tmp;
    }

    public BNode<E> addChildNode(BNode<E> node, int where, BNode<E> tmp) {
        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }
        return tmp;
    }
}

public class BinaryTreeSum {
    public static BNode<Integer> findNode(BNode<Integer> root, int element) {
        BNode<Integer> node;

        if (root == null)
            return null;

        if (root.info == element)
            return root;

        node = findNode(root.left, element);

        if (node == null)
            node = findNode(root.right, element);

        return node;
    }

    public static int sumNodes(BNode<Integer> root, int element, char c) {
        if (root == null)
            return 0;

        if (c == '<') {
            if (root.info < element)
                return root.info + sumNodes(root.left, element, c) + sumNodes(root.right, element, c);
            else
                return sumNodes(root.left, element, c) + sumNodes(root.right, element, c);
        } else {
            if (root.info > element)
                return root.info + sumNodes(root.left, element, c) + sumNodes(root.right, element, c);
            else
                return sumNodes(root.left, element, c) + sumNodes(root.right, element, c);
        }
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<BNode<Integer>> nodes = new ArrayList<>();
        BTree<Integer> tree = new BTree<>();

        for (i = 0; i < N; i++)
            nodes.add(new BNode<>());

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes.get(index).info = Integer.parseInt(st.nextToken());
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes.get(Integer.parseInt(st.nextToken())), BNode.LEFT, nodes.get(index));
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes.get(Integer.parseInt(st.nextToken())), BNode.RIGHT, nodes.get(index));
            } else {
                // this node is the root
                tree.makeRootNode(nodes.get(index));
            }
        }

        int baranaVrednost = Integer.parseInt(br.readLine());

        br.close();

        // vasiot kod ovde   // your code here
        // printSubtreeSums(tree.root, baranaVrednost);
        BNode<Integer> root = findNode(tree.root, baranaVrednost);

        System.out.printf("%d %d", sumNodes(root.left, baranaVrednost, '<'), sumNodes(root.right, baranaVrednost, '>'));
    }

    /*    // calculate and print the subtree sums
        public static void printSubtreeSums(BNode<Integer> node, int baranaVrednost) {
            if (node == null)
                return;

            if (node.info == baranaVrednost) {
                int leftSum = sumLowerValues(node.left, baranaVrednost);
                int rightSum = sumGreaterValues(node.right, baranaVrednost);

                System.out.println(leftSum + " " + rightSum);
            } else if (node.info < baranaVrednost)
                printSubtreeSums(node.right, baranaVrednost);
            else
                printSubtreeSums(node.left, baranaVrednost);
        }

        // calculate the sum of values lower than the given value in the subtree
        private static int sumLowerValues(BNode<Integer> node, int value) {
            if (node == null)
                return 0;

            int sum = 0;

            if (node.info < value)
                sum += node.info;

            sum += sumLowerValues(node.left, value);
            sum += sumLowerValues(node.right, value);

            return sum;
        }

        // calculate the sum of values greater than the given value in the subtree
        private static int sumGreaterValues(BNode<Integer> node, int value) {
            if (node == null)
                return 0;

            int sum = 0;

            if (node.info > value)
                sum += node.info;

            sum += sumGreaterValues(node.left, value);
            sum += sumGreaterValues(node.right, value);

            return sum;
        }*/
}