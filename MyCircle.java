public class MyCircle<T> {
    class Node {
        T data_ = null;
        Node next_ = null;
        Node prev_ = null;

        Node(T obj, Node prv, Node nxt) {
            data_ = obj;
            prev_ = prv;
            next_ = nxt;
        }
    }

    protected Node head_ = null;

    public MyCircle() {
        head_ = null;
    }

    public T front() {
        return head_.data_;
    }

    @Override
    public String toString() {
        if (empty())
            return "[]";
        String rv = "[";
        Node node = head_;
        do {
            rv += node.data_.toString();
            if (node.next_ != head_)
                rv += ",";
            node = node.next_;
        } while (node != head_);
        rv += "]";
        return rv;
    }

    public int size() {
        if (this.empty())
            return 0;
        Node n = head_.next_;
        int size = 1;
        while (!n.equals(head_)) {
            n = n.next_;
            size++;
        }
        return size;
    }

    public boolean empty() {
        return head_ == null;
    }

    public void push_back(T obj) {
        if (!empty()) {
            Node n = new Node(obj, head_.prev_, head_);
            head_.prev_.next_ = n;
            head_.prev_ = n;
        } else {
            head_ = new Node(obj, null, null);
            head_.next_ = head_;
            head_.prev_ = head_;
        }
    }

    public void pop_front() {
        if (this.size() == 1)
            head_ = null;
        if (this.size() == 0) {
            System.out.println("Empty!");
            return;
        }
        Node prev = head_.prev_;
        head_ = head_.next_;
        head_.prev_ = prev;
        prev.next_ = head_;
    }

    public static void main(String[] args) {
        MyCircle<Integer> circle = new MyCircle<>();
        for (int i = 1; i < 6; i++) {
            circle.push_back(i);
        }

        System.out.println("Circle : " + circle.toString());

        for (int i = 0; i < 5; i++) {
            System.out.println("Size of circle is : " + circle.size());
            circle.pop_front();
            System.out.println("Element popped! New Circle : " + circle.toString());
        }
    }
}