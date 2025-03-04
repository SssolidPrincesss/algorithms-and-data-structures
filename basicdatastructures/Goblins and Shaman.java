import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        Queue<Integer> goQu = new LinkedList<>();
        Deque<Integer> front = new LinkedList<>();
        Deque<Integer> back = new LinkedList<>();

        for (int i = 0; i < q; i++) {
            String[] line = br.readLine().split(" ");
            String goblinStatus = line[0];

            if (goblinStatus.equals("*")) {
                int goblinNum = Integer.parseInt(line[1]);
                front.addLast(goblinNum);
                balance(front, back);
            } else if (goblinStatus.equals("+")) {
                int goblinNum = Integer.parseInt(line[1]);
                back.addLast(goblinNum);
                balance(front, back);
            } else {
                if (!front.isEmpty()) {
                    goQu.add(front.removeFirst());
                    balance(front, back);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (!goQu.isEmpty()) {
            bw.write(goQu.remove() + "\n");
        }
        bw.flush();
    }

    static void balance(Deque<Integer> front, Deque<Integer> back) {
        while (front.size() > back.size() + 1) {
            back.addFirst(front.removeLast());
        }
        while (back.size() > front.size()) {
            front.addLast(back.removeFirst());
        }
    }
}
