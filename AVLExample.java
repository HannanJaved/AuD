import aud.AVLTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

public class AVLExample {
  public static void main(String[] args) {
      // TODO: Test with DotViewer and SingleStepper

    AVLTree<Integer,Object> AVLtree = new AVLTree<>();
    SingleStepper stepper = new SingleStepper("SingleStepper");
    DotViewer viewer = DotViewer.displayWindow(AVLtree, "AVL Tree : ");

    int example[] = {14, 15, 17, 7, 5, 10, 16};
    for(int i = 0; i < example.length; i++){
      stepper.halt("insert '"+ example[i] +"'");
      AVLtree.insert(example[i],null);
      viewer.display(AVLtree);
    }
    stepper.halt("End");
   }
}