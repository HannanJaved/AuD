import aud.DList;

public class MyDList<T> extends DList<T> {

	public MyDList() {
		super();
	}

	public void append(MyDList<T> li) {
		if (this == li) {
			MyDList<T> Copy = new MyDList<T>();
			Copy.append(this);
			this.append(Copy);
		} else {
			ForwardIterator x = li.iterator();
			for (int i = 0; i < li.size(); i++) {
				this.push_back(x.next());
			}
		}
	}

	public void insert(int n, MyDList<T> li) {
		if (this == li) {
			MyDList<T> temp = new MyDList<T>();
			temp.append(this);
			this.insert(n, temp);
		} else {
			ForwardIterator x = this.iterator();
			for (int i = 0; i < n; i++) {
				x.next();
			}
			for (T obj : li) {
				this.insert_before(x, obj);
			}
		}
	}

	public static void main(String[] args) {
		MyDList<Integer> TestList = new MyDList<Integer>();
		MyDList<Integer> TestList2 = new MyDList<Integer>();
		for (int i = 1; i < 6; i++) {
			TestList.push_back(i * 5);
			TestList2.push_back(i);
		}
		System.out.println("List 1 is : " + TestList.toString());
		System.out.println("List 2 is : " + TestList2.toString());

		// TestList.append(TestList);
		TestList.append(TestList2);
		System.out.println("List 2 appended to List 1 : ");
		System.out.println("List 1 is now : " + TestList.toString());
		System.out.println("List 2 is now : " + TestList2.toString());

		TestList2.insert(3, TestList);
		System.out.println("List 1 added to Position 3 of List 2!");
		System.out.println("List 1 is now : " + TestList.toString());
		System.out.println("List 2 is now : " + TestList2.toString());
	}
}