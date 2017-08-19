import java.util.Scanner;

public class ReplaceString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= noOfTestCases; i++) {
            String mainString = scanner.nextLine();
            String toBeReplaced = scanner.nextLine();
            String toReplaceWith = scanner.nextLine();
            String result = replace(mainString, toBeReplaced, toReplaceWith);
            System.out.println(result);
        }
    }

    private static String replace(String mainString, String toBeReplaced, String toReplaceWith) {
        return mainString.replaceAll(toBeReplaced, toReplaceWith);
    }
}
