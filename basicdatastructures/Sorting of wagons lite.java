import java.lang.*;
import java.util.*;

public class Main {

	public static int[] readData(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        var tr = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            tr.add(scanner.nextInt()); 
        }
		return tr.stream().mapToInt(x -> x).toArray();
	}

    public static void main(String[] args) {
        int[] trains = readData();

        if(railwaySort(trains)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO"); 
        }
		
    }

    public static boolean railwaySort(int[]trains){
        var tunel = new Stack<Integer>();
        int trInd = 0; 
        int numOfTrain = 1;

        while(trInd < trains.length || !tunel.isEmpty()){
            if(!tunel.isEmpty() && tunel.peek() == numOfTrain){
                tunel.pop();
                numOfTrain++;
            }
            else if(trInd < trains.length){
                if(numOfTrain == trains[trInd]){
                    numOfTrain++;
                    trInd++;
                }

                else if (!tunel.isEmpty() && trains[trInd] > tunel.peek()) {
                    return false; 
                }
                else {
                    tunel.push(trains[trInd]);
                    trInd++;
                }
            }
            else {return false;}
        }
        return true;
    }


}