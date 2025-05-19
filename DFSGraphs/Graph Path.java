import java.util.*;

public class ShortestPath {

    int[][] adjMatrix;
    int startNode;
    int endNode;
    int size;

    public void readData() {
        Scanner scan = new Scanner(System.in);
        size = scan.nextInt();
        scan.nextLine(); 

        adjMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String row = scan.nextLine();
            String[] cells = row.split(" ");
            for (int j = 0; j < size; j++) {
                adjMatrix[i][j] = Integer.parseInt(cells[j]);
            }
        }

        startNode = scan.nextInt() - 1; 
        endNode = scan.nextInt() - 1; 
        scan.close();  
    }

    public void solve() {
        int[] dist = new int[size];
        int[] prev = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        Queue<Integer> queue = new LinkedList<>();
        dist[startNode] = 0;
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < size; v++) {
                if (adjMatrix[u][v] == 1 && dist[v] == Integer.MAX_VALUE) {
                    dist[v] = dist[u] + 1;
                    prev[v] = u;
                    queue.offer(v);
                }
            }
        }

        if (dist[endNode] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dist[endNode]);

            if (dist[endNode] > 0) {
                List<Integer> path = new ArrayList<>();
                int current = endNode;
                while (current != -1) {
                    path.add(current + 1);
                    current = prev[current];
                }

                for (int i = path.size() - 1; i >= 0; i--) {
                    System.out.print(path.get(i) + (i == 0 ? "" : " "));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ShortestPath sp = new ShortestPath();
        sp.readData();
        sp.solve();
    }
}