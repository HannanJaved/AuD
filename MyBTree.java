import java.util.Random;
import aud.BTree;
import aud.KTreeNode;
import aud.util.*;
import java.util.*;

public class MyBTree<Key extends Comparable<Key>> extends BTree<Key>{
    public MyBTree(int m){
        super(m);
    }

    public int getHeight(){
        int h = 0;
		KTreeNode<Key> root = root();
		while (root.getChild(0) != null){
		    root = root.getChild(0);
		    h++;
		}
		return ++h;
    }

    public static void main(String[] args){
        BTree<Integer> test = new BTree<>(2);

        int a[] = {6, 18, 22, 3, 11, 16, 7, 10, 1, 8, 12};
        for(int i : a)
        {
            test.insert(i);
        }

        DotViewer.displayWindow(test, "Tree: ");

        Random x = new Random();
        MyBTree<Integer> test2 = new MyBTree<>(2);
        for(int i = 0; i < 1000000; i++)
        {
            test2.insert(x.nextInt(1000000));
        }
        System.out.println("Height : " + test2.getHeight());
    }
}

//bearbeitet bei Hannan Mahadik und Shashank Shorya