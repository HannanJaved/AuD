public class MySList implements Iterable<Integer>
{
	public String toString() {
    	if (empty())
      		return "[]";
    	String rv = "[";
    	Node node = head_;
    	do {
      		rv += node.data_;
      		if (node.next_ != null)
        	rv += ",";
      		node = node.next_;
    	} while(node != null);
    	rv += "]";
    	return rv;
  	}

  	class Node
	{
		int data_;

		Node next_ = null;
		public Node(int data, Node next)
		{
			data_ = data;
			next_ = next;
		}
	}

	Node head_ = null;

	public MySList(){}

  	public boolean empty()
	{
    	if (head_ == null)
      		return true;
    	return false;
	}

	public void push_back(int data)
	{
		if (empty())
		{
			head_ = new Node(data, null);
		}
    	else{
			Node n = head_;
			while (n.next_ != null)
				n = n.next_;
			n.next_ = new Node(data, null);
  		}
	}

	public class Iterator implements java.util.Iterator<Integer>
	{
		Node node_ = null;
		public Iterator(Node node)
		{
			node_ = node;
		}

		public boolean hasNext()
		{
			while (node_ != null && node_.data_ % 2 == 0){
          		node_ = node_.next_;
			}
			return node_ != null;
		}

		public Integer next()
		{
			if (hasNext())
			{
				int data = node_.data_;
				node_ = node_.next_;
				return data;
			}
			else
				return null;
		}

		public void remove(int obj)
		{
  		    //laut Aufgabe kann leer sein.
		}
	}

	public Iterator iterator()
	{
		return new Iterator(head_);
	}


	public static void main(String[] args)
	{
		int[] x = {85, 72, 93, 81, 74, 42};
		MySList Slist = new MySList();

    	System.out.print("The SList is : ");
			for (Integer i : x){
				Slist.push_back(i);
    		}

		System.out.println(Slist.toString());
    	System.out.print("Odd numbers: ");

		for (int el : Slist){
			System.out.print(el + " ");
    	}
	}
}