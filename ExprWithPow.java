import aud.example.expr.*;
import aud.util.*;
import aud.Queue;

public class ExprWithPow extends ExpressionParser2 {

	//function taken from ExpressionParser2 and changes made where necessary
	protected ExpressionTree product(int level) {
	verbose(level,"<product>");

    // temporary storage
    Queue<ExpressionTree> expr = new Queue<ExpressionTree>();
    Queue<Integer>        op   = new Queue<Integer>();

    ExpressionTree tree = pow(level+1);	//changed to "pow" from "factor"

    // parse iteratively
    while (lookahead()==Tokenizer.TIMES || lookahead()==Tokenizer.DIVIDE) {
      op.enqueue(lookahead());
      nextToken();
      expr.enqueue(pow(level+1));	//changed to "pow" from "factor"
    }

    // setup tree
    while (!op.is_empty()) {
      if (op.dequeue()==Tokenizer.TIMES)
        tree=new ExpressionTree(new Times(),tree,expr.dequeue());
      else
        tree=new ExpressionTree(new Divide(),tree,expr.dequeue());
    }
    return tree;
  }

    protected ExpressionTree pow(int level) {
        verbose(level, "<power>");

        ExpressionTree tree = factor(level + 1);
        if (lookahead() == Tokenizer.POWER) {
            nextToken();
            tree = new ExpressionTree(new Power(), tree, pow(level + 1));
		}
        return tree;
    }

    public static void main(String[] args) {
		String test = "2^2";
        ExpressionParser p = new ExprWithPow();
        p.setVerbose(true);
        ExpressionTree tree = p.parse(test);
        DotViewer.displayWindow(tree, "");
        System.out.println(test + " = " + tree.getValue());
    }
}