//  bearbeitet von youssef haj ayed, wael jallali und Hannan Mahadik
package aud;

public class SimpleTree<T extends Comparable<T>> {

    public class Node {


      //  private SimpleTree<T> parent;

        private SimpleTree<T> leftChild = new SimpleTree<T>();
        private SimpleTree<T> rightChild = new SimpleTree<T>();

        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node(SimpleTree<T> parent, T data) {
      //      this.parent = parent;
            this.data = data;
        }
    }

    private Node root = null;

    public SimpleTree() {

    }


    private SimpleTree(SimpleTree<T> parent, T data) {
        root = new Node(parent, data);
    }

    public void add(T obj) {

        if (root == null)
            root = new Node(obj);
        else {
            SimpleTree<T> currentNode = this;

            while (!currentNode.root.data.equals(obj)) {
                // Go right
                if (currentNode.root.data.compareTo(obj) < 0) {
                    if (currentNode.root.rightChild.isEmpty()) {
                        currentNode.root.rightChild = new SimpleTree<T>(currentNode, obj);
                        break;
                    } else
                        currentNode = currentNode.root.rightChild;

                }
                // Go left
                else if (currentNode.root.data.compareTo(obj) > 0) {
                    if (currentNode.root.leftChild.isEmpty()) {
                        currentNode.root.leftChild = new SimpleTree<T>(currentNode, obj);
                        break;
                    } else
                        currentNode = currentNode.root.leftChild;

                }
            }
        }
    }

    public boolean contains(T obj) {
        if (root == null) {
            return false;
        } else {
            if (root.data.equals(obj))
                return true;
           // Compare right
            if (root.data.compareTo(obj) < 0)
                return root.rightChild.contains(obj);
            // Compare left
            else
                return root.leftChild.contains(obj);
        }

    }

    public boolean isEmpty() {
        return root == null;
    }

    public String toString() {

    	String outPut = "";
        if (isEmpty())
            return outPut;

        if (this.root.leftChild != null)
          outPut = outPut + this.root.leftChild.toString();

        outPut = outPut + this.root.data.toString() + " ";

        if (this.root.rightChild != null)
            outPut = outPut + this.root.rightChild.toString();

        return outPut ;
    }

    public static void main(String[] args) {
        SimpleTree<Integer> myTree = new SimpleTree<Integer>();

        myTree.add(4);
        myTree.add(2);
        myTree.add(4);
        myTree.add(6);
        myTree.add(10);
        myTree.add(12);
        myTree.add(7);
        System.out.println("Tree inorder : ");
        System.out.println(myTree.toString());

        System.out.println("Does the tree contain the number '2' : ");
        System.out.println(myTree.contains(2));

        System.out.println("Does the tree contain the number '13' : ");
        System.out.println(myTree.contains(13));
    }
}