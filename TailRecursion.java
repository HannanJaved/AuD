public class TailRecursion {
  static int sum = 1;
  static int i = 1;
    // Compute power 2^n recursively.
    //
    // The computation must use _tail recursion_!
    // Note: This requires the implementation of a tail recursive
    //       auxiliary method that is called by pow2()!)
    //
    public static int pow2(int n) {
      if( n != 0 )
        return (2 * pow2(n-1));
      else
        return 1;
    }

    // Compute the sum of factors (divisors) of n
    // The factors include 1 but exclude n, e.g., sumFactors(6) ==
    // 1+2+3 == 6 .
    //
    // The computation must use _tail recursion_!
    //
    public static int factors(int n, int i)
    {
        // Checking if the number is less than N
        if (i < n) {
            if (n % i == 0) {
                //System.out.println("Factors : " + i);
                sum += i;
            }
            return factors(n, i + 1);
        }else{
          int x = sum;
          sum = 1;
          return x;
        }
      }

    public static int sumFactors(int n) {
      //System.out.print("Sum of the Factors of " + n +" : ");
      if(n == 1)
        return 1;
      else
        return factors(n, 2);
    }
    // Test your implementation.
    //
    public static void main(String[] args) {
      System.out.println(pow2(6));
      System.out.println(sumFactors(5));
    }
  }