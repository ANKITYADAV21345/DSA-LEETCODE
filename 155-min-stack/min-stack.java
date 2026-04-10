//apna college
class MinStack {

    //pair replacement
    static class Pair{
        int val;
        int minVal;
        
        Pair(int v,int m){
            val=v;
            minVal=m;
        }
    }

    Stack<Pair> stack=new Stack<>();


    public MinStack() {
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }
        else{
            int minVal=Math.min(val,stack.peek().minVal);
            stack.push(new Pair(val,minVal));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */