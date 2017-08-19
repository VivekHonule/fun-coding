import java.util.Scanner;

public class MinimumTogglesToPartition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = scanner.nextInt();
        for (int i = 1; i <= noOfTestCases; i++) {
            int noOfElements = scanner.nextInt();
            scanner.nextLine();
            String arrayElementsStr = scanner.nextLine();
            String[] splitElements = arrayElementsStr.split("\\s");
            int[] elements = createIntArray(splitElements, noOfElements);
            int count = updateFirstAndLastElement(elements, noOfElements);
            count = adjustFlag(elements, count, noOfElements);
            System.out.println(count);

        }
    }

    private static int adjustFlag(int[] elements, int count, int noOfElements) {
        int previousElement = 0;
        for (int i = 1; i < noOfElements - 1; i++) {
            boolean ifPartitioned = checkIfPartitioned(elements, noOfElements);
            if (ifPartitioned) {
                return count;
            }

            if (elements[i] == 1) {
                int nextElement = elements[i + 1];
                if (previousElement == 0 && nextElement == 0) {
                    elements[i] = 0;
                    count++;
                } else if (previousElement == 0 && nextElement == 1) {
                    previousElement = nextElement;
                } else if (previousElement == 1 && nextElement == 0) {
                    elements[i] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkIfPartitioned(int[] elements, int noOfElements) {
        int previousElement = 0;
        for (int i = 1; i < noOfElements - 1; i++) {
            if (elements[i] == 0) {
                if (previousElement == 1)
                    return false;
            } else {
                previousElement = 1;
            }
        }
        return true;
    }

    private static int updateFirstAndLastElement(int[] elements, int noOfElements) {
        int count = 0;
        int firstElement = elements[0];
        int lastElemet = elements[noOfElements - 1];
        if (firstElement != 0) {
            elements[0] = 0;
            count++;
        }
        if (lastElemet != 1) {
            elements[noOfElements - 1] = 1;
            count++;
        }
        return count;
    }

    private static int[] createIntArray(String[] splitElements, int noOfElement) {
        int[] elements = new int[noOfElement];
        for (int i = 0; i < noOfElement; i++) {
            String str = splitElements[i].trim();
            int element = Integer.parseInt(str);
            elements[i] = element;
        }
        return elements;
    }
}
