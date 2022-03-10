import java.util.Scanner;
import java.util.Stack;

/* Test cases
○ Valid Input (numbers)
try (Integer.parseInt(input) {
   continue processing if valid
} catch (NumberFormatException e) {
    prompt user that their input was invalid
    restart prompting process
}
○ Valid Operators
switch (s) {
    case +
    case -
    ...
    default:
        invalid operator or number
        restart prompting process
}
○ Empty Input
    if (input.length == null || input.length == 0) {
        prompt please enter a valid expression
        restart prompting process
    }
○ No operator in input
after taking input implement another switch
switch (s) {
    case +
    case -
    ...
    default:
        no operator
        restart prompting process
}
○ Difference between 1, 2, and/or 3 digit number (think of how to use space characters)
    Handled in function by input.split(" ") then parsing the number
 */

public class PostFixCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Intake from user
        System.out.println("Enter postfix expression to calculate: ");
        String input = sc.nextLine();
        sc.close();

        // Split intake at spaces and store the result as a array of strings
        String[] deconstructed = input.split(" ");

        // Initialize stack of integers
        Stack<Integer> stk = new Stack<>();

        // For every string in the deconstructed input
        for (String s : deconstructed) {
            // Check if the string matches any case
            switch (s) {
                case "+" -> add(stk);
                case "-" -> sub(stk);
                case "*" -> mul(stk);
                case "/" -> div(stk);
                default -> {
                    stk.push(Integer.parseInt(s));
                    System.out.println("Pushed -> " + s);
                }
            }
        }
        // Handling of straggler that isn't followed by arithmetic
        if (stk.size() > 1) System.out.printf("Stack size exceeds expected, straggler element '%d' will be removed\n", stk.pop());
        System.out.printf("\nResult = %d\n", stk.pop());
    }

    // error handling for invalid stack items
    public static boolean valid(Stack<Integer> stk){
        if (stk.size() < 2) {
            System.out.println("Cannot perform arithmetic on limited stack");
            return false;
        }
        return true;
    }

    /*
        Calculator logic
        ================
        1. Check and ensure stack has enough elements to perform arithmetic
        2. Pop two elements from stack
        3. Store elements in variables
        4. Perform arithmetic with variables (supported: addition, subtraction, multiplication, division)
        5. Push result to stack
     */
    public static void add(Stack<Integer> stk) {
        if (!valid(stk)) return;

        System.out.println("Performing addition");
        // pop two operands
        int a = stk.pop();
        int b = stk.pop();

        stk.push(a + b);
    }
    public static void sub(Stack<Integer> stk) {
        if (!valid(stk)) return;

        System.out.println("Performing subtraction");
        // pop two operands
        int a = stk.pop();
        int b = stk.pop();

        // order changed to ensure predictable result
        stk.push(b - a);
    }
    public static void mul(Stack<Integer> stk) {
        if (!valid(stk)) return;

        System.out.println("Performing multiplication");
        // pop two operands
        int a = stk.pop();
        int b = stk.pop();

        stk.push(a * b);
    }
    public static void div(Stack<Integer> stk) {
        if (!valid(stk)) return;

        System.out.println("Performing division");
        // pop two operands
        int a = stk.pop();
        int b = stk.pop();

        // order changed to ensure predictable result
        stk.push(b / a);
    }

    /*
        Analysis
        ========
        Time complexity: O(N) - operations scale linearly with input
        Space complexity: O(N) - stack size scales with input
     */
}