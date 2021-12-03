import aud.util.*;        //to use DotViewer, SingleStepper
import aud.BinaryTree;    //to use BinaryTree<T>
import aud.Queue;         //to use Queue<T>

//------------------------------------------------------------------//
public class MyBinTree<T> extends BinaryTree<T> {
  //----------------------------------------------------------------//
  public MyBinTree(T data) {
    super(data);
  }

  //----------------------------------------------------------------//
  public MyBinTree(T data,MyBinTree<T> left,MyBinTree<T> right) {
    super(data, left, right);
  }

  //----------------------------------------------------------------//
  public int maxWidth() {
    // TODO:
    // - implement to return the maximum width of the binary tree
    // - you can use a queue for your solution
    Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
    BinaryTree<T> Tree = null;
    queue.enqueue(this);
    queue.enqueue(null);      // null is added to queue to differentiate between each level
    int width = 0, thisLevel_width = 0;

    do {
      Tree = queue.dequeue();

      if (Tree == null) {
        width = width > thisLevel_width ? width : thisLevel_width;
        thisLevel_width = 0;
        if (!queue.is_empty()) {
            queue.enqueue(null);
          }
          continue;
      }

      thisLevel_width++;

      if (Tree.getRight() != null) {
        queue.enqueue(Tree.getRight());
        }

      if (Tree.getLeft() != null) {
        queue.enqueue(Tree.getLeft());
        }
    } while(!queue.is_empty());
      return width;
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code with appropriate examples
    MyBinTree<Integer> parent = new MyBinTree<>(-8);
		MyBinTree<Integer> child = new MyBinTree<>(4);
		MyBinTree<Integer> child2 = new MyBinTree<>(1);
		MyBinTree<Integer> c1child1 = new MyBinTree<>(6);
		MyBinTree<Integer> c1child2 = new MyBinTree<>(-11);
		MyBinTree<Integer> c2child1 = new MyBinTree<>(5);
		MyBinTree<Integer> c2child2 = new MyBinTree<>(7);
		MyBinTree<Integer> extra = new MyBinTree<>(10);

		parent.setLeft(child); 			// 4
		parent.setRight(child2);	   	// 1
		child.setLeft(c1child1);		// 6
		child.setRight(c1child2);		// -11
		child2.setLeft(c2child1);		// 5
		child2.setRight(c2child2);		// 7
		c1child1.setLeft(extra);		//10

    DotViewer tree = DotViewer.displayWindow(parent, "Output:");
		tree.display(parent);

    System.out.println(parent.maxWidth());
  }
}