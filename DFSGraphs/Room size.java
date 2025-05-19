import java.util.*;

public class Labirint {
	
	int size;
	String[][] lab;
	int x;
	int y;
	
	public void readData() {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		scan.nextLine();
		lab = new String[size][size];
		
		for (int i = 0; i < size; i++) {
            String row = scan.nextLine(); 
            String[] cells = row.split("");
			for (int j = 0; j < size; j++) {
				lab[i][j] = cells[j];
			}	
		}
		x = scan.nextInt() - 1;
		y = scan.nextInt() - 1;	
		scan.close();
	}
	
	public int roomSize(int xPos, int yPos) {
		boolean[][] isVisited = new boolean[size][size];
		return dfs(xPos, yPos, isVisited);
	}
	
	public int dfs(int row, int col, boolean[][] isVisited) {
		int counter = 1;
		
		if(row >= size || col >= size ||  isVisited[row][col] || lab[row][col].equals("*")) {
			return 0;
		}
		
		isVisited[row][col] = true;
		
		counter += dfs(row + 1, col, isVisited);
		counter += dfs(row - 1, col, isVisited);
		counter += dfs(row, col + 1, isVisited);
		counter += dfs(row, col - 1, isVisited);
	
		return counter;
	}
	
	public static void main(String[] args) {
		Labirint labirint = new Labirint();
		labirint.readData();
        
        System.out.print(labirint.roomSize(labirint.x, labirint.y));
	}

}