import aud.Stack;

public class RecursionToStack {
         // TODO: implementation
         public static int whatStack(int n) {
            Stack<Integer> st = new Stack<Integer>();
            int sum = 0;

            if(n < 10)
                return n;
            else{
                while (n > 0) {
                    st.push(n);   //1234 -> 123 -> 12  ->1
                    n /= 10;      //123  -> 12  -> 1
                }
                System.out.print("The sum of : ");
                while (!st.is_empty())
                {
                    n = st.pop() % 10;  // 1, 2, 3, 4
                    System.out.print(n + " + ");
                    sum += n;  // 1+2 -> 3+3 -> 6+4
                }
                    return sum;
            }
        }

    public static void main(String args[]) {
     // TODO: test
        int test = 1234;
        System.out.println(test);
        System.out.println(" = " + whatStack(test));
    }
 }