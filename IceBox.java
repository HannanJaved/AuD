//---------------------------------------------------------------//
/**Container that can store food elements.*/
public class IceBox {
  //---------------------------------------------------------------//
  // TODO: attributes and constructor
  	private Food[] table;
	private int capacity;

	public IceBox(int capacity) {
		this.capacity = capacity;
		table = new Food[capacity];
	}

	public int add(Food obj) {
		// TODO: attributes and constructor
		int x = 0;
		x = obj.hashCode() % capacity;
		if (x < 0) {
			x += capacity;
		}

		int counter = 0;

		while (table[x] != null) {
			counter++;
			x = (x + (counter * counter)) % capacity;
		}

		table[x] = obj;

		return counter;
	}

	public boolean contains(Food obj) {
		// TODO: attributes and constructor
		int pos = obj.hashCode() % capacity;
		int start = pos;
		int i = 1;

		while (table[pos] != null) {
			if (table[pos].equals(obj))
				return true;
			pos = (start + i * i) % capacity;
			i++;
			if (pos == start)
				break;
		}
		return false;
	}

	public String toString() {
		String result = "";
		for(Food f : table){
			if(f != null){
				result += f.toString() + "\n";
			}
		}
		return result;
	}

  //---------------------------------------------------------------//
  public static void main(String[] args) {
    // TODO: test your code
	Food Orange = new Food("Fruit", "Orange");
	Food Spinach = new Food("Vegetable", "Spinach");
	Food Apple = new Food("Fruit", "Apple");

	IceBox fridge = new IceBox(3);
	fridge.add(Orange);
	fridge.add(Spinach);

	System.out.println(fridge.toString());

	System.out.println(fridge.contains(Apple));
	fridge.add(Apple);
	System.out.println(fridge.contains(Apple));

	System.out.println(fridge.toString());
  }
}