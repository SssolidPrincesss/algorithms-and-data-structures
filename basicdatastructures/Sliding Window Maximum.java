public class Window{
        private Queue<Integer> window;
        private LinkedList<Integer> maxs;
        private int size;

        public Window(int size) {
            window = new LinkedList<>();
            maxs = new LinkedList<>();
            this.size = size;
        }

        public void add(int x){
            addInWindow(x);
            addInMaxs(x);
        }

        private void addInWindow(int x)
        {
            window.add(x);
            if(window.size() > size)
            {
                if(window.peek().equals(maxs.getFirst()))
                {
                    maxs.removeFirst();
                }
                window.remove();
            }
        }      
        
        private void addInMaxs(int x){
            while(!maxs.isEmpty() && maxs.getLast() < x)
            {
                maxs.removeLast();
            }
            maxs.addLast(x);
        }

        public int getMax() { 
            return maxs.getFirst();
        }
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        var result = new ArrayList<Integer>();
        var window = new Window(k);
        
        for (int i = 0; i < k; i++) {
            window.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            result.add(window.getMax());
            window.add(nums[i]);
        }

        result.add(window.getMax());

        return result.stream().mapToInt(x -> x).toArray();
    }
}