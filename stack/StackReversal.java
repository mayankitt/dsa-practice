package stack;

import java.util.Scanner;
import java.util.Stack;

class StackReversal {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input (positive integer) elements to be pushed into stack as a single space separated string: ");
        String iString = scanner.nextLine();
        String[] elements = iString.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String e : elements) {
            int element = -1;
            try {
                element = Integer.parseInt(e);
            }
            catch(NumberFormatException ex) {
                System.err.println("Error in input! See stack trace below:");
                ex.printStackTrace();
            }
            stack.push(element);
        }
        System.out.println("Initial state of the stack: " + stack);
        stack = reverseStack(stack);
        System.out.println("Final state of the stack: " + stack);
        scanner.close();
    }

    public static Stack<Integer> reverseStack(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int topELement = stack.pop();
            reverseStack(stack);
            reverseStackHelper(stack, topELement);
            return stack;
        }
        return stack;
    }

    private static void reverseStackHelper(Stack<Integer> stack, int topELement) {
        if (stack.isEmpty()) {
            stack.push(topELement);
            return;
        }
        int currentTop = stack.pop();
        reverseStackHelper(stack, topELement);
        stack.push(currentTop);
    }
}