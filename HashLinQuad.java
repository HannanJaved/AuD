import java.util.Random;

//-----------------------------------------------------------------//
/** simple Hashtable with linear/quadratic probing
    capacity is big enough */
// import java.util.Arrays;

public class HashLinQuad {
  //---------------------------------------------------------------//
  private int[] table_;    // array of buckets or slots
  private int size_;       // current number of elements
  private int capacity_;

  // TODO: Constructor
  public HashLinQuad(int capacity){
	  this.capacity_ = capacity;
	  table_ = new int[capacity];
	  size_ = 0;
	}
  //---------------------------------------------------------------//
  public int addLin(int obj) {
    // linear probing
    // return number of collisions
    int hashvalue = obj % table_.length;
		int h = hashvalue;
		int collisions = 0;

		if (table_[hashvalue] == 0){
			table_[hashvalue] = obj;
		}
    else if ( table_[hashvalue] != 0 ){

      collisions++;
      int i = 0;
      while( table_[hashvalue] != 0 ){
      	hashvalue = ( i + h ) % table_.length;
        i++;
    }

      table_[ hashvalue ] = obj;
      size_++;

    }
		return collisions;
  }

  //---------------------------------------------------------------//
  public int addQuad(int obj) {
    // quadratic probing
    // return number of collisions
    int hashvalue = obj % table_.length;
    int h = hashvalue;
  	int collisions = 0;

    if ( table_[ hashvalue] == 0){
      table_[ hashvalue ] = obj;
    }
    else if ( table_[ hashvalue ] != 0){
      collisions++;
      int i = 0;
      while( table_[ hashvalue ] != 0){
		    hashvalue = ((int)Math.pow(i, 2) + h) % table_.length;
        i++;
      }
      table_[ hashvalue ] = obj;
      size_++;
    }
    return collisions;
  }

  //---------------------------------------------------------------//
  public String toString() {
    // TODO: implementation
    String output = "[";

		for(int i = 0; i < table_.length; i++){
		 if(table_[i] != 0){
			output += " " + table_[i] + ',';
		 }
		}

		return output + ']';
    // return Arrays.toString(table_); gibt auch 0 Werte zurueck
  }

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test with hashtable-capacity of 1259 and 1000 random values
    //im Aufgabe steht capacity 1249 und nicht 1259
    HashLinQuad l = new HashLinQuad(1249);
	  HashLinQuad q = new HashLinQuad(1249);
    int linear = 0, quad = 0; //linear und quadratic collisions
    Random random = new Random();
    int[] test = new int[1000];

    for(int i = 0; i < test.length; i++){
      test[i] = random.nextInt(10000);
    }

    for(int i = 0; i < test.length; i++){
      linear += l.addLin(test[i]);
      quad += q.addQuad(test[i]);
    }

    System.out.println("Linear collisions : " + linear);
    System.out.println("Quadratic collisions : " + quad);
    // System.out.println(l.toString());
    // System.out.println(q.toString());
  }
}