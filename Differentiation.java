import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

//-----------------------------------------------------------------//
/**Class which is able the compute the derivative of a given
   `ExpressionTree` with respect to a user specified variable.*/
public class Differentiation {
  //----------------------------------------------------------------//
  public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var) {
    // TODO: - implement a method which computes the derivative of the
    //         given tree `t` with respect to `var`

    ExpressionTree Tree = null;

    if(t.getData().getType() == AtomicExpression.Type.OpPlus){
      Tree = new ExpressionTree(new Plus(),differentiate(t.getLeft(),var),differentiate(t.getRight(),var));
    }

    else if(t.getData().getType() == AtomicExpression.Type.OpMinus){
      Tree = new ExpressionTree(new Minus(),differentiate(t.getLeft(),var),differentiate(t.getRight(),var));
    }

    else if(t.getData().getType() == AtomicExpression.Type.OpTimes){
        ExpressionTree treeLeft = new ExpressionTree(new Times(),differentiate(t.getLeft(),var),help(t.getRight()));
        ExpressionTree treeRight = new ExpressionTree(new Times(),help(t.getLeft()),differentiate(t.getRight(),var));
        Tree = new ExpressionTree(new Plus(),treeLeft,treeRight);
    }

    else if(t.getData().getType() == AtomicExpression.Type.OpUnaryMinus){
      Tree = new ExpressionTree(new UnaryMinus(),differentiate(t.getLeft(),var),null);
    }

    else {
      if(t.getData().toString().equals(var))
        Tree = new ExpressionTree(new Number(1));
      else
        Tree = new ExpressionTree(new Number(0));
    }

    return Tree;
  }

  public static ExpressionTree help(BinaryTree<AtomicExpression> t){
      ExpressionTree Tree = null;

      if(t.getData().getType() == AtomicExpression.Type.OpPlus){
        Tree = new ExpressionTree(new Plus(),help(t.getLeft()),help(t.getRight()));
      }

      else if(t.getData().getType() == AtomicExpression.Type.OpMinus){
        Tree = new ExpressionTree(new Minus(),help(t.getLeft()),help(t.getRight()));
      }

      else if(t.getData().getType() == AtomicExpression.Type.OpTimes){
        Tree = new ExpressionTree(new Times(),help(t.getLeft()),help(t.getRight()));
      }

      else if(t.getData().getType() == AtomicExpression.Type.OpUnaryMinus){
        Tree = new ExpressionTree(new UnaryMinus(),help(t.getLeft()),null);
      }

      else
        Tree = new ExpressionTree(new Symbol(t.getData().toString()));

      return Tree;
    }
  //----------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code with appropriate examples
    String exp = "-x*y";
    ExpressionParser p = new ExpressionParser();
    ExpressionTree tree = p.parse(exp);
    //ExpressionTree tree  = new ExpressionTree(new Plus(),  new ExpressionTree(new Symbol ("x")), new ExpressionTree(new Times(), new ExpressionTree(new Symbol ("x")), new ExpressionTree(new Symbol ("y"))));
    System.out.println("Tree : " + tree);
    System.out.println("Differentiation with respect to x : " + differentiate(tree,"x"));
    //DotViewer.displayWindow(tree,"Tree : ");
    //DotViewer.displayWindow(differentiate(tree,"y"),"Differentiation with respect to y : ");
  }
}