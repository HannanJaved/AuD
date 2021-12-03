import aud.Stack;

public class TPalindrome {

    public static boolean isTPalindrome(String text) {
        Stack<Character> St = new Stack<Character>();
        String test = "";
        char[] Ch = text.toCharArray();
        for (char a : Ch) {
            if (a == ')') {
                while (St.top() != '(') {
                    test += St.pop();
                }
                St.pop();

                if (isPalindrome(test))
                    St.push('*');
                else
                    return false;

                test = "";
            } else
                St.push(a);
        }

        while (!St.is_empty()) {
            test += St.pop();
        }
        return isPalindrome(test);
    }

    public static boolean isPalindrome(String text) {
        String Rtext = reverse(text);
        return text.equals(Rtext);
    }

    public static String reverse(String text) {
        Stack<Character> test = new Stack<Character>();
        String result = "";
        for (char c : text.toCharArray()) {
            test.push(c);
        }
        while (!test.is_empty()) {
            result += test.pop();
        }
        return result;
    }

    public static void main(String[] args) {

        String test = "abc(abba)(u)cba";
        if (isTPalindrome(test))
            System.out.println(test + " is a TPalindrome!");
        else
            System.out.println(test + " is not a TPalindrome");

    }
}