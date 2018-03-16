import java.util.Scanner;
import java.util.Stack;

public class StringReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        reverseString(scanner.nextLine());
    }

    private static void reverseString(String name) {
        Stack<Character> stack = new Stack<>();
        pushCharByChar(name, stack);
        System.out.println(reverseStrFromStack(name, stack));
    }

    private static String reverseStrFromStack(String name, Stack<Character> stack) {
        String reversedStr = "";
        for (int i = 0; i < name.length(); i++) {
            reversedStr = reversedStr + stack.pop();
        }
        return reversedStr;
    }

    private static void pushCharByChar(String name, Stack<Character> stack) {
        for (int i = 0; i < name.length(); i++) {
            stack.push(name.charAt(i));
        }
    }
}
