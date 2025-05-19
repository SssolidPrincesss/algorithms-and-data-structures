import java.util.*;

public class CycleDetection {

    int size;
    int[][] adjMatrix;
    int[] parent;
    boolean[] visited;
    List<Integer> cycle;


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

        scan.close();
    }


    public boolean findCycle() {
        visited = new boolean[size];
        parent = new int[size];
        cycle = new ArrayList<>();
        Arrays.fill(parent, -1);


        for (int i = 0; i < size; i++) {

            if (!visited[i]) {
                if (dfs(i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int u, int par) {
        visited[u] = true;
        parent[u] = par;

        for (int v = 0; v < size; v++) {
            if (adjMatrix[u][v] == 1) {
                if (!visited[v]) {
                    if (dfs(v, u)) {
                        return true;
                    }
                } else if (v != par) {
                    int current = u;
                    while (current != v) {
                        cycle.add(current + 1);
                        current = parent[current];
                    }
                    cycle.add(v + 1);
                    Collections.reverse(cycle);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.readData();

        if (cycleDetection.size == 0) {
          System.out.println("NO");
        } else {

        if (cycleDetection.findCycle()) {
            System.out.println("YES");
            System.out.println(cycleDetection.cycle.size());
            for (int i = 0; i < cycleDetection.cycle.size(); i++) {
                System.out.print(cycleDetection.cycle.get(i) + (i == cycleDetection.cycle.size() - 1 ? "" : " "));
            }
            System.out.println();
        } else {
            System.out.println("NO");
        }
     }
       
   
    }
}