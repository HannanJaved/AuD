import aud.example.expr.ExpressionParser;
import aud.example.expr.ExpressionTree;
import aud.example.expr.Number;
import aud.example.expr.Plus;
import aud.example.expr.Minus;
import aud.example.expr.Divide;
import aud.example.expr.Times;
import aud.util.*;              //to use DotViewer, SingleStepper


//------------------------------------------------------------------//
public class ExampleExpression  {
  //----------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: create an appropriate example which uses ExpressionParser
    //       and ExpressionTree
		String test = "5 + (3 * (( 7 / 2) - 1))";
		ExpressionTree test2 = new ExpressionTree(
					new Plus(),
		    			new ExpressionTree(
							new Times(),
		    				new ExpressionTree(
		    						new Minus(),
		    							new ExpressionTree(new Divide(),
		    								new ExpressionTree(new Number(7)),
		    								new ExpressionTree(new Number(2))),
									new ExpressionTree(new Number(1))),
							new ExpressionTree(new Number(3))),
		    		new ExpressionTree(new Number(5)));

		ExpressionParser x = new ExpressionParser();
		x.setVerbose(true);
		ExpressionTree T = x.parse(test);

		System.out.println("\nFirst Input : " + T);
		System.out.println("Inorder : "+T.inorder());
		System.out.println("Postorder : "+T.postorder());
		System.out.println("Preorder : " +T.preorder());

		System.out.println("Value of the Expression : " + T.getValue());

		System.out.println("\nSecond Input : " + test2);
		System.out.println("Inorder : "+test2.inorder());
		System.out.println("Postorder : "+test2.postorder());
		System.out.println("Preorder : " +test2.preorder());

		System.out.println("Value of the Expression : " + test2.getValue());

		DotViewer tree = DotViewer.displayWindow(T, "Tree 1 Output:");
		tree.display(T);

		DotViewer tree2 = DotViewer.displayWindow(test2, "Tree 2 Output:");
		tree2.display(test2);
	}
}