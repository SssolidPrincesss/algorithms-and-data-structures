import java.util.*;

public class Main {
  public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        while (scan.hasNextInt()) {
            numbers.add(scan.nextInt());
        }

        int count = numbers.size();
        if (count < 3) {
            System.out.println("Массив должен содержать хотя бы три числа."); 
            return; 
        }

        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = numbers.get(i);
        }

        int[] result = maximumProductNumbers(nums);
        Arrays.sort(result);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
  }

    public static int[] maximumProductNumbers(int[] nums) {
        Arrays.sort(nums); 

        long product1 = (long) nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        long product2 = (long) nums[0] * nums[1] * nums[nums.length - 1];

        if (product1 >= product2) {
            return new int[] {nums[nums.length - 3], nums[nums.length - 2], nums[nums.length - 1]};
        } else {
            return new int[] {nums[0], nums[1], nums[nums.length - 1]};
        }
    }
}
