
import java.util.*;

public class Main {
	  public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);

	        int keyCount = scan.nextInt();
	        
	        int[] nums = new int[keyCount];
	        for (int i = 0; i < keyCount; i++) {
	            nums[i] = scan.nextInt();
	        }
	        
	        
	        int tapsCount = scan.nextInt();
	       
	        int[] taps = new int[tapsCount];
	        for (int i = 0; i < tapsCount; i++) {
	            taps[i] = scan.nextInt();
	        }
	        
	        
	        breakingKeys(keyCount, nums, tapsCount, taps);
	         

	        System.out.println();
	  }

    public static void breakingKeys(int kCount, int[] nums, int tCount, int[] taps) {

        boolean [] broken = new boolean[kCount];
        
        for (int tap : taps) {
        	int keyIndex = tap - 1; 
            nums[keyIndex]--; 
            
            if (nums[keyIndex] < 0) {
            	broken[keyIndex] = true; 
            }
        }
    
        
        
        for(int i = 0; i < kCount; i++) {
  
        	if(broken[i]){
        		System.out.println("YES");
        	}
        	else {
        		System.out.println("NO");
        	}
        }
    }
}