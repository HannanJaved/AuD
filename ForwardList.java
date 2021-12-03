import aud.Stack;
/**ForwardList represents a list with single linked nodes, that do have
   a next-pointer. */
   public class ForwardList<T> implements Iterable<T>{
    //-----------------------------------------------------------------//
    //------------- !!Do not change the following lines!! -------------//
    public String toString() {
      if (is_empty())
        return "[]";
      String rv = "[";
      Node node = head_;
      do {
        rv += node.data_.toString();
        if (node.next_ != head_)
          rv += ",";
        node = node.next_;
      } while(node != null);
      rv += "]";
      return rv;
    }

    //-----------------------------------------------------------------//
    //---------------- !!Insert your solution below!! -----------------//
    //A Node is a single element int the ring
    public class Node {
      //---------------------------------------------------------------//
      //    !!! Do not change the existing lines in class Node!!!      //
      //            !!! It is allowed to add new content !!!           //
      //       !!! It is not allowed to add a previous pointer !!!     //
      //---------------------------------------------------------------//
      public T data_;
      public Node next_ = null;

      public Node(T data, Node next) {
        data_ = data;
        next_ = next;
      }
    }

    //-----------------------------------------------------------------//
    public Node head_ = null;

    //-----------------------------------------------------------------//
    public ForwardList()
    {}

    //-----------------------------------------------------------------//
    public void push_front(T obj) {
      // TODO: implement adding elements to the front of the list
      Node x = head_;
      head_ = new Node(obj,x);
    }

    //-----------------------------------------------------------------//
    public boolean is_empty() {
      // TODO: should return `true` if the list is empty else `false`
      return head_ == null;
    }

    //-----------------------------------------------------------------//
    public void backTraverse() {
      // TODO: implement a recursive method to print out reversed
      Node x = head_;
      System.out.print("[");
      _backTraverse(x);
      System.out.println("]");
    }

    public void _backTraverse(Node x)
    {
      if( x == null)
        return;
      else{
        System.out.print(x.data_ + ",");
        _backTraverse(x.next_);
      }
    }

    //-----------------------------------------------------------------//
    public class BackIterator implements java.util.Iterator<T> {
      // TODO: implement an iterator that provides a reveres iteration
      Stack<Node> stack;
		  public BackIterator(Node node) {
			  stack = new Stack<Node>();
			  Node temp = node;
			  while (temp != null) {
				  stack.push(temp);
				  temp = temp.next_;
			}
		}
		  public boolean hasNext() {
			  if (stack.is_empty())
				  return false;
				else return true;
		}
		  public T next() {
        T next = stack.pop().data_;
			  return next;
		  }
    }

    //-----------------------------------------------------------------//
    public BackIterator iterator() {
      // TODO: return an instance of the iterator
      return new BackIterator(head_);
    }

    //-----------------------------------------------------------------//
    public static void main(String[] args) {
      // TODO: test your code with appropriate examples
      ForwardList<Integer> l = new ForwardList<>();
      System.out.println("List is empty? " + l.is_empty());
		  for(int i = 1; i < 6; i++)
      {
        System.out.println(i + " added to List!");
        l.push_front(i);
      }

      System.out.println("Elements in List : ");
      //System.out.println(l.toString());
      System.out.print("[");
      for(int el : l)
      {
        System.out.print(el + ",");
      }
      System.out.println("]");

      System.out.println("List is empty? " + l.is_empty());

      System.out.println("Elements in List in Reverse Order(Back Traversal) : ");
      l.backTraverse();

      System.out.println();
  }
}