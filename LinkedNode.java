public class LinkedNode<T> {

    T data_ = null;
    LinkedNode<T> next_ = null;

    public LinkedNode() {
    }

    public LinkedNode(T value, LinkedNode<T> NextNode) { // constructor
        data_ = value;
        next_ = NextNode;
    }

    public T getData() { // getter
        return data_;
    }

    public LinkedNode<T> getNext() {
        return next_;
    }

    public void setData(T value) { // setter
        data_ = value;
    }

    public void setNext(LinkedNode<T> NextNode) { // setter
        next_ = NextNode;
    }

    public String toText() {
        LinkedNode<T> LN1 = new LinkedNode<T>(); // initialize stuff
        String text = "";
        LN1.setData(data_);
        LN1.setNext(next_);

        while (true) {
            if (LN1.data_ != null)
                text = text + LN1.data_.toString() + " ";

            LN1.setData(LN1.next_.getData());
            LN1.setNext(LN1.next_.getNext());

            if (LN1.next_ == null) {
                if (LN1.data_ != null)
                    text = text + LN1.data_.toString();
                break;
            }
        }
        return text;
    }

    public static void main(String[] args) {
        LinkedNode<String> tonight = new LinkedNode<String>();
        LinkedNode<String> tom = new LinkedNode<String>();
        LinkedNode<String> tomNight = new LinkedNode<String>();

        tonight.setData("Ausschlafen");
        tonight.setNext(tom);

        tom.setData("Spielabend");
        tom.setNext(tomNight);

        tomNight.setData("Schlafen gehen");

        System.out.println(tonight.toText());
    }
}