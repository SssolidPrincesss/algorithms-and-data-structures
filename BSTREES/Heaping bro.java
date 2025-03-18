import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class HeapImplementation {
	private static ArrayList<Integer> heap = new ArrayList<>();

	public static void insert(int k) {
        heap.add(k);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i) > heap.get((i - 1) / 2)) {
            int temp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }

    public static int extractMax() {

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }

        return max;
    }


    private static void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            int temp = heap.get(i);
            heap.set(i, heap.get(largest));
            heap.set(largest, temp);
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("0")) {
                int k = Integer.parseInt(parts[1]);
                insert(k);
            } else if (parts[0].equals("1")) {
                System.out.println(extractMax());
            }
        }

        scanner.close();
    }
}
