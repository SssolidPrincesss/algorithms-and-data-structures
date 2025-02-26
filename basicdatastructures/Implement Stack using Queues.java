class MyStack {
    Queue<Integer> in;
    Queue<Integer> out;

    public MyStack() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        in.add(x);
          while(!out.isEmpty()){
            in.add(out.poll());
        }
        out = in;
        in = new LinkedList<Integer>();
    }
    
    public int pop() {
        return out.poll();
    }
    
    public int top() {
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

