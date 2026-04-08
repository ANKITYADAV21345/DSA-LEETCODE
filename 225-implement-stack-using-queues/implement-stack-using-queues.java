//apna college
class MyStack {

    Queue<Integer> queue1=new LinkedList<>();
    Queue<Integer> queue2=new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {  //o(n)
        //move all elements from queue1 to queue2
        while(!queue1.isEmpty()){
            queue2.add(queue1.peek());
            queue1.remove();
        }

        //push new element into queue1
        queue1.add(x);

        //move everything back to queue1
        while(!queue2.isEmpty()){
            queue1.add(queue2.peek());
            queue2.remove();
        }

    }
    
    public int pop() {  //o(1)
        int ans=queue1.peek();
        queue1.remove();
        return ans;
    }
    
    public int top() {  //o(1)
        return queue1.peek();
    }
    
    public boolean empty() {  //o(1)
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */