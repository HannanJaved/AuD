import aud.*;		  	//to use BinaryTree<T>
import aud.util.*; 		// to use DotViewer, SingleStepper
import java.util.Iterator;

public class IntBinTree extends BinaryTree<Integer> {
	//---------------------------------------------------------------//
	public IntBinTree(int data) {
		super(data);
	}

	//---------------------------------------------------------------//
	public IntBinTree(int data, IntBinTree left, IntBinTree right) {
		super(data, left, right);
	}

	//---------------------------------------------------------------//
	public int height() {
		return _height(this);
	}

	public int _height(BinaryTree<Integer> tree) {	//Helper function to find height
		// TODO: implement to return the height of the current (sub-)tree
		if (tree == null) {
			return 0;
		} else {
			int Height = 1;			// min height = 0
  			int LeftHeight = _height(tree.getLeft());		//Find height of left sub-tree
			int RightHeight = _height(tree.getRight());		//Find height of right sub-tree
			if (LeftHeight > RightHeight)
				return Height + LeftHeight;
			else
				return Height + RightHeight;
		}
	}

	//---------------------------------------------------------------//
	public int maxSum() { // TODO: Implementation
		int LeftSum = _maxSum(this.getLeft());
		int RightSum = _maxSum(this.getRight());
		if (LeftSum > RightSum)
			return LeftSum;
		else
			return RightSum;
	}

	public int _maxSum(BinaryTree<Integer> tree) {		//Helper function to calculate Sum
		// TODO: implement to return bigger sum of the left/right subtree
		if (tree == null) {
			return 0;
		} else {
			return tree.getData() + _maxSum(tree.getLeft()) + _maxSum(tree.getRight());	//Find sum of individual sub-trees and add together
		}
	}

	//---------------------------------------------------------------//
	public int maxPath() {
		// TODO: implement to return the maximum sum of all possible paths
		return _maxPath(this);
	}

	public int _maxPath(BinaryTree<Integer> tree) {	//Helper function to find the maximum path
		if (tree == null) {
			return 0;
		} else {
			int LeftPath = _maxPath(tree.getLeft());
			int RightPath = _maxPath(tree.getRight());
			if (LeftPath == 0) 						//(tree.getLeft() == null)
				return tree.getData() + RightPath;	//If there is no Left Node then RightNode value to be returned
			else if (RightPath == 0)				//(tree.getRight() == null)
				return tree.getData() + LeftPath;	//If there is no Right Node then Left Node value to be returned
			else{
				if (LeftPath > RightPath)
					return tree.getData() + LeftPath;
				else
					return tree.getData() + RightPath;
			}
		}
	}

	//---------------------------------------------------------------//
	public static void main(String[] args) {
		// TODO: test your code with appropriate examples

		IntBinTree parent = new IntBinTree(-8);
		IntBinTree child = new IntBinTree(4);
		IntBinTree child2 = new IntBinTree(1);
		IntBinTree c1child1 = new IntBinTree(6);
		IntBinTree c1child2 = new IntBinTree(-11);
		IntBinTree c2child1 = new IntBinTree(5);
		IntBinTree c2child2 = new IntBinTree(7);
		IntBinTree extra = new IntBinTree(10);

		parent.setLeft(child); 			// 4
		parent.setRight(child2);	   	// 1
		child.setLeft(c1child1);		// 6
		child.setRight(c1child2);		// -11
		child2.setLeft(c2child1);		// 5
		child2.setRight(c2child2);		// 7
		c1child1.setLeft(extra);		//10

		//DotViewer.displayWindow(parent, "Output: ");

		System.out.println(parent.height());
		System.out.println(parent.maxSum());
		System.out.println(parent.maxPath());
	}
}