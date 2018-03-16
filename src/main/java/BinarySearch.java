import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strArr = scanner.nextLine();
        int[] element = createIntArray(strArr);
        int inputElement = Integer.parseInt(scanner.nextLine());
        boolean isPresent = searchElement(inputElement, element);
        if(isPresent){
            System.out.println("Present");
        }else {
            System.out.println("Not present");
        }
    }

    private static boolean searchElement(int inputElement, int[] element) {
        //to do
        return false;
    }

    private static int[] createIntArray(String strArr) {
        String[] strings = strArr.split(" ");
        int length = strings.length;
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }
}
