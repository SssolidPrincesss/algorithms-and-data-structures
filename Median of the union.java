import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); 
        int l = scanner.nextInt(); 

        List<List<Integer>> sequences = new ArrayList<>(); 

        
        for (int i = 0; i < n; i++) {
            List<Integer> sequence = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                sequence.add(scanner.nextInt());
            }
            sequences.add(sequence);
        }

      
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> mergedSequence = new ArrayList<>();
                mergedSequence.addAll(sequences.get(i));
                mergedSequence.addAll(sequences.get(j));

                Collections.sort(mergedSequence); 
                System.out.println(mergedSequence.get(l - 1)); 

            }
        }
    }
}
