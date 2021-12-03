import aud.BinaryTree;
import aud.util.DotViewer;

public class BuildBinTree {
	public static void main(String[] args) {
		// TODO: implement a class to visualise the binary tree
		BinaryTree<String> parent = new BinaryTree<String>("-8");
		BinaryTree<String> child = new BinaryTree<String>("4");
		BinaryTree<String> child2 = new BinaryTree<String>("1");
		BinaryTree<String> c1child1 = new BinaryTree<String>("6");
		BinaryTree<String> c1child2 = new BinaryTree<String>("-11");
		BinaryTree<String> c2child1 = new BinaryTree<String>("5");
		BinaryTree<String> c2child2 = new BinaryTree<String>("7");

		parent.setLeft(child); 			// 4
		parent.setRight(child2);	   	// 1
		child.setLeft(c1child2);		// 6
		child.setRight(c1child1);		// -11
		child2.setLeft(c2child1);		// 5
		child2.setRight(c2child2);		// 7

		System.out.println("Preorder: " + parent.preorder().toString());
        System.out.println("Inorder: " + parent.inorder().toString());
		System.out.println("Postorder: " + parent.postorder().toString());
		System.out.println("Levelorder: " + parent.levelorder().toString());

		DotViewer tree = DotViewer.displayWindow(parent, "Output:");
		tree.display(parent);
	}
}