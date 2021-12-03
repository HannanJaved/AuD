import aud.SList;
import java.util.function.Predicate;

public class IntSList {
    SList<Integer> li;

    public IntSList() {
        li = new SList<>();
    }

    @Override
    public String toString() {
        return li.toString();
    }

    public void push_front(int obj) {
        li.push_front(obj);
    }

    public static Predicate<Integer> Even() {
        return x -> x % 2 == 0;
    }

    public static Predicate<Integer> G42() {
        return x -> x > 42;
    }

    /*
     * public static Predicate<Integer> Odd() { // Falls ungerade Zahlen ausgegeben
     * sollten return x -> x % 2 != 0; }
     *
     * public static Predicate<Integer> G74() { return x -> x > 74; }
     */

    public IntSList filter(Predicate<Integer> check) {
        IntSList FinalArray = new IntSList();
        for (int i : li) {
            if (check.test(i))
                FinalArray.push_front(i);
        }
        return FinalArray;
    }

    public static void main(String[] args) {
        IntSList list = new IntSList();
        list.push_front(85);
        list.push_front(72);
        list.push_front(93);
        list.push_front(81);
        list.push_front(74);
        list.push_front(42);
        System.out.println("List: " + list.toString());

        IntSList Test1 = list.filter(Even());
        System.out.println("Even numbers list: " + Test1);

        IntSList Test2 = list.filter(G42());
        System.out.println("List with numbers >42: " + Test2);

        /*
         * IntSList Test3 = Test.filter(Odd()); System.out.println("Odd numbers array: "
         * + Test3);
         *
         * IntSList Test4 = Test.filter(G74());
         * System.out.println("Array with numbers >74: " + Test4);
         */
    }
}