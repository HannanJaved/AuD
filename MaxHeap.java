import java.util.*;

//-----------------------------------------------------------------//
public class MaxHeap<T extends Comparable<T>> {
  //-----------------------------------------------------------------//
  //------------- !!Do not change the following lines!! -------------//
  public String toString() {
    return heap_.toString();  // don't change because of backend
  }

  //---------------------------------------------------------------//
  //--------------- !!Insert your solution below!! ----------------//
  private ArrayList<T> heap_;  // or Vector

  //---------------------------------------------------------------//
  public MaxHeap() {
    // TODO: implementation
    heap_ = new ArrayList<T>();
  }

  //---------------------------------------------------------------//
  public MaxHeap(T[] arr) {
    // TODO: construct a heap from array a (use downHeap)
    this();
    for(T x : arr){
      heap_.add(x);
    }
    for(int i = heap_.size() - 1; i >= 0; --i){
      downHeap(i);
    }
  }

  //---------------------------------------------------------------//
  public ArrayList<T> getHeap(){
    // TODO: implementation
    return heap_;
  }

  //---------------------------------------------------------------//
  public int getSize() {
    // TODO: implementation
    return heap_.size();
  }

  //---------------------------------------------------------------//
  public boolean isEmpty() {
    // TODO: implementation
    return heap_.isEmpty();
  }

  //---------------------------------------------------------------//
  public void downHeap(int n) {
    // TODO: implementation
    T x = heap_.get(n);
    while(n <= heap_.size() / 2 - 1){
      int i = 2 * ( n + 1 ) - 1 ;
      if(i < heap_.size() - 1 && heap_.get(i).compareTo(heap_.get(i + 1)) < 0){
        i++;
      }
      if(x.compareTo(heap_.get(i)) >= 0)
       break;
      heap_.set(n, heap_.get(i));
      n = i;
    }
    heap_.set(n, x);
  }

  //---------------------------------------------------------------//
  public void insert(T obj) {
    // TODO: implementation, use upHeap
    heap_.add(obj);
    upHeap(heap_.size() - 1);
  }

  //---------------------------------------------------------------//
  private void upHeap(int n) {
    // TODO: implementation
    T x = heap_.get(n);
        while(n > 0 && x.compareTo(heap_.get((n + 1) / 2 - 1)) > 0) {
            heap_.set(n, heap_.get((n + 1) / 2 - 1));
            n = (n + 1) / 2 - 1;
      }
        heap_.set(n, x);
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code with appropriate examples
    Character[] list = {'X', 'T', 'O', 'G', 'S', 'M', 'N', 'A', 'E', 'R', 'A', 'I'};
    MaxHeap<Character> mh = new MaxHeap<Character>(list);
    System.out.println(mh.toString());
    System.out.println(mh.getSize());
    mh.insert('Y');
    System.out.println(mh.toString());
    System.out.println(mh.getSize());
  }
}