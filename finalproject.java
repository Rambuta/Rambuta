import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class finalproject {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = new ArrayList<>();
        getUserInputs(10, inputList, scanner);

        System.out.println("Original List:");
        displayList(inputList);

        Collections.sort(inputList, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        System.out.println("\nSorted List based on length in ascending order:");
        displayList(inputList);

        System.out.println("\nDo you want to run again? (yes/no)");
        String runAgain = scanner.nextLine().toLowerCase();
        if (runAgain.equals("yes")) {
            main(args);
        } else {
            System.out.println("Exiting the program. Goodbye!");
        }

        scanner.close();
    }

    private static void getUserInputs(int count, List<String> inputList, Scanner scanner) {
        if (count > 0) {
            System.out.print("Enter a string: ");
            String userInput = scanner.nextLine();

            if (!isNumeric(userInput)) {
                inputList.add(userInput);
                getUserInputs(count - 1, inputList, scanner);
            } else {
                System.out.println("Invalid input! Please enter a non-numeric string.");
                getUserInputs(count, inputList, scanner);
            }
        }
    }

    private static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void displayList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}
