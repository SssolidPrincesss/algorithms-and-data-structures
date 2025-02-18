import java.lang.*;

class Solution {
    public int[] plusOne(int[] digits) {
        
        int val = 0;
        int mn = 1;
        for (int i = digits.length - 1; i >= 0; i--){
            val += digits[i] * mn;
            mn *= 10;
        }
        val++;
        
        int counter = 0;
        int tVal = val;
       
        if(tVal == 0){
            counter = 1;
        }
        else{
            while(tVal != 0){
                counter++;
                tVal /= 10;
            }
        }

        int x = (int) Math.pow(10, counter-1);
        int[] tMass = new int[counter];
        

        for (int j = 0; j < counter; j++){
            tMass[j] = val / x;
            val %= x;
            x/=10;
        }

        return tMass;
    }
}