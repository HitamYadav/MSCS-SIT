//By Hitam Yadav

import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {

    private static class Node<E> { //Private static inner class of the Treap class.
        public E data;
        public int priority;
        public Node<E> right;
        {
            right = null;
        }

        public Node<E> left;

        {
            left = null;
        }


        public Node(E data, int priority) {
            if (data != null) {
                this.data = data;
                this.priority = priority;
            } else {
                throw new NullPointerException("This causes an Error");
            }

        }

        public void rotateRight() { //rotating right

            Node<E> temp_node = new Node<E>(this.data, this.priority);

            if (this.left == null) {
                return;
            } else {
                if (this.right != null) {
                    temp_node.right = this.right;
                    if (this.left.right != null) {
                        temp_node.left = this.left.right;
                    }
                } else {
                    if (this.left.right != null) {
                        temp_node.left = this.left.right;
                    }
                }
                this.data = this.left.data;
                this.priority = this.left.priority;
                this.right = temp_node;

                if (this.left.left == null) {
                    this.left = null;
                } else {
                    this.left = this.left.left;
                }
            }
        }

        public void rotateLeft() { //rotating left
            Node<E> temp_node;
            temp_node = new Node<E>(this.data, this.priority);
            if (this.right == null) {
                return;
            } else {
                if (this.left == null) {
                    if (this.right.left != null) {
                        temp_node.right = this.right.left;
                    }
                } else {
                    temp_node.left = this.left;
                    if (this.right.left != null) {
                        temp_node.right = this.right.left;
                    }
                }
                this.data = this.right.data;
                this.priority = this.right.priority;
                this.left = temp_node;

                if (this.right.right == null) {
                    this.right = null;
                } else {
                    this.right = this.right.right;
                }
            }
        }

        public String toString() { // prints the string
            return data.toString();
        }
    }

    private Random priorityGenerator;
    private Node<E> root;


    public Treap() { // creating an empty treap
        this.root = null;
        this.priorityGenerator = new Random();
    }

    public Treap(long seed) { // creating an empty treap
        if (seed > 0) {
            this.priorityGenerator = new Random(seed); // initializing priorityGenerator using the newRandom(seed)
            this.root = null;
        } else {
            throw new NullPointerException(" This is an error, seed cannot be 0 or less");
        }
    }

    boolean add(E key) {

        return add(key, this.priorityGenerator.nextInt());
    }

    void reheap(Stack<Node<E>> stack, Node<E> test) { // restore heap invariant
        Node<E> pre;
        pre = stack.pop();
        if (pre != null && pre.priority < test.priority) {
            do {
                if (test.data.compareTo(pre.data) < 0) {
                    pre.rotateRight();
                    if (stack.isEmpty()) {
                        return;
                    }
                } else {
                    pre.rotateLeft();
                    if (stack.isEmpty()) {
                        return;
                    }
                }
                pre = stack.pop();
            } while (pre != null && pre.priority < test.priority);
        }
    }

    boolean add(E key, int priority) {
        if (key == null || priority < 0) {
            throw new NullPointerException("Error");
        }

        if (this.root == null) {
            this.root = new Node<>(key, priority);

            return true;
        }

        Node<E> root = this.root;
        Stack<Node<E>> stack;
        stack = new Stack<Node<E>>();

        if (root != null) {
            do {
                stack.push(root);
                if (((Comparable<E>) root.data).compareTo(key) == 0) {
                    return false;
                } else if (((Comparable<E>) root.data).compareTo(key) > 0) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            } while (root != null);
            root = stack.peek();
            if (((Comparable<E>) root.data).compareTo(key) > 0) {
                Node<E> node = new Node<E>(key, priority);
                stack.peek().left = node;
                stack.push(node);
            } else {
                Node<E> node = new Node<E>(key, priority);
                stack.peek().right = node;
                stack.push(node);
            }
        } else {
            root = stack.peek();
            if (((Comparable<E>) root.data).compareTo(key) > 0) {
                Node<E> node = new Node<E>(key, priority);
                stack.peek().left = node;
                stack.push(node);
            } else {
                Node<E> node = new Node<E>(key, priority);
                stack.peek().right = node;
                stack.push(node);
            }
        }

        Node<E> node;
        node = stack.pop();
        reheap(stack, node);

        return true;
    }

    boolean delete(E key) {
        if (find(key) == true ) {
            root = delete(key, root);
            return true;
        }
        else if (root != null) {
            root = delete(key, root);
            return true;
        } else {
            return false;
        }
    }

    private Node<E> delete(E value, Node<E> previous) {
        if (previous == null) {
            return previous;
        } else {
            if (previous.data.compareTo(value) > 0) {
                previous.left = delete(value, previous.left);
            } else {
                if (previous.data.compareTo(value) < 0) {
                    previous.right = delete(value, previous.right);
                } else {
                    if (previous.left == null) {
                        previous = previous.right;
                    } else if (previous.right == null) {
                        previous = previous.left;
                    } else if (previous.right.priority < previous.left.priority) {
                        previous.rotateRight();
                        previous.right = delete(value, previous.right);
                    } else {
                        previous.rotateLeft();
                        previous.left = delete(value, previous.left);
                    }
                }
            }
        }
        return previous;
    }



    private boolean find(Node<E> root, E key) {
        if (root== null) {
            return false;
        }
        else if (key.compareTo(root.data) == 0) {
            return true;
        } else if (key.compareTo(root.data) < 0) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }



    public boolean find(E key) {
        if (key == null) {
           return false;
        }

        return find(this.root, key);
    }


    private void preorderTraverse(Node<E> node, int depth, StringBuilder test) {
        for (int i = 1; i < depth; i++) {
            test.append(" ");
        }
        if (node != null) {
            test.append("(key=");
            test.append(node.toString());
            test.append(", priority=");
            test.append(node.priority);
            test.append(")");
            test.append("\n");
            preorderTraverse(node.left, depth + 1, test);
            preorderTraverse(node.right, depth + 1, test);
        } else {
            test.append("null\n");
        }
    }


    public String toString() {
        StringBuilder test;
        test = new StringBuilder();
        preorderTraverse(root, 1, test);
        return test.toString();
    }


    public static void main(String[] args) {
        // Initialize Tree
        Treap testTree;
        testTree = new Treap<>();

        // Adding elements
        testTree.add('p', 99);
        testTree.add('g', 80);
        testTree.add('u', 75);
        testTree.add('a', 60);
        testTree.add('j', 65);
        testTree.add('r', 40);
        testTree.add('z', 47);
        testTree.add('w', 32);
        testTree.add('v', 21);
        testTree.add('x', 25);

        // Deleting Elements
       testTree.delete('z');
        System.out.println(testTree.toString());
        testTree.add('z',47);
        System.out.println(testTree.find('m'));

        // Finding Elements
        System.out.println(testTree.toString());
        //System.out.println(testTree.find(3));
    }
}