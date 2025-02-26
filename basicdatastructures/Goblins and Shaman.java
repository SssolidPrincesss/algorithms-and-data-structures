/*
этот код почему-то проходит не все тесты, и после множества 
попыток и даже испольховния чата гпт я не могу найти причину 
неправильной работы кода. Я понмаю, что эту задачу очень легко решить, 
используя более современые структуры данных, но мне очень интересно разобраться
с реализацией, где используются стеки и очереди 
*/
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void goblinQueue() {
        int q = scanner.nextInt();
        Queue<Integer> goQu = new LinkedList<>();
        Queue<Integer> allGoblins = new LinkedList<>();
        for (int i = 0; i < q; i++) {
            String goblinStatus = scanner.next();
            try {
                int goblinNum = 0;
                if (!goblinStatus.equals("-")) {
                    goblinNum = scanner.nextInt();
                }
                if (goblinStatus.equals("*")) {
                    int size = allGoblins.size();
                    int center = size / 2;
                    List<Integer> tempList = new ArrayList<>();
                    for (int j = 0; j < center; j++) {
                        if (!allGoblins.isEmpty()) {
                            tempList.add(allGoblins.poll());
                        }
                    }
                    allGoblins.add(goblinNum);
                    allGoblins.addAll(tempList);
                } else if (goblinStatus.equals("+")) {
                    allGoblins.add(goblinNum);
                } else if (goblinStatus.equals("-")) {
                    if (!allGoblins.isEmpty()) {
                        goQu.add(allGoblins.poll());
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Ожидалось целое число.");
                scanner.next();
                i--;
            }
        }

        while (!goQu.isEmpty()) {
            System.out.println(goQu.poll());
        }
    }

    public static void main(String[] args) {
        goblinQueue();
    }
}