class MinStack {

    Stack<Integer> in;
    Stack<Integer> min;
    
    public MinStack() {
        in = new Stack<Integer>();
        min = new Stack<Integer>();   
    }

    public void push(int x) {
        in.push(x);

        if(min.empty() || min.peek() >= x){
            min.push(x);
        }
    }
    
    public void pop() {

        if(in.peek().equals(min.peek())){
            min.pop();
        }
        in.pop();
    }
    
    public int top() {
        return in.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

