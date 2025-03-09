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
        var pSum = polkaSum(seq);
		System.out.println(pSum);
    }

    public static int polkaSum(String seq){
        Stack<Integer> result = new Stack<>();
        int var1, var2;

        for (Character val : seq.toCharArray()){
            if (Character.isDigit(val)){
                result.push(val - '0');
            }
            else if(val.equals('+')){
                var2 = result.pop();
                var1 = result.pop();
                result.push(var1 + var2);
            }
            else if(val.equals('-')){
                var2 = result.pop();
                var1 = result.pop();
                result.push(var1 - var2);
            }
            else if(val.equals('*')){
                var2 = result.pop();
                var1 = result.pop();
                result.push(var1 * var2);
            }
            else if(val.equals('/')){
                var2 = result.pop();
                var1 = result.pop();
                result.push(var1 / var2);
            }
        }
        return result.pop();
    }
}