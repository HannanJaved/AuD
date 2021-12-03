import aud.RedBlackTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;
//-----------------------------------------------------------------//
public class RedBlackExample {
  //---------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: Test your example with DotViewer and SingleStepper
    RedBlackTree<Integer, Integer> Tree = new RedBlackTree<>();
    DotViewer viewer = DotViewer.displayWindow(Tree, " RB Tree : ");
    SingleStepper stepper = new SingleStepper("Red Black Tree : ");
    int[] example = {6, 7, 3, 4, 2, 1};
    for(int i = 0; i < example.length; i++)
    {
      stepper.halt("insert '" + example[i] + "'");
      Tree.insert(example[i],example[i]);
      viewer.display(Tree);
    }
    stepper.halt("End");
  }
}