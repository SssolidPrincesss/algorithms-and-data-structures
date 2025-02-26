import java.lang.*;
import java.util.*;

public class Main {

	public static String readData(){
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
		return sequence;
	}

    public static void main(String[] args) {
		var seq = readData();

        if (isValid(seq)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static boolean isValid(String sequence) {
        Stack<Character> stack = new Stack<>();

        for (char c : sequence ) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; 
                }

                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false; 
                }
            }
        }

        return stack.isEmpty(); 
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
