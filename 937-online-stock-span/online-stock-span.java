// apna college
import java.util.*;

class StockSpanner {

    Stack<Integer> stack;   // store indices
    ArrayList<Integer> prices; // store all prices

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
    }
    
    public int next(int price) {
        // current index
        int i = prices.size();
        prices.add(price);

        // pop jab tak chhote ya equal elements milte hain
        while (!stack.isEmpty() && prices.get(stack.peek()) <= price) {
            stack.pop();
        }

        int span;

        // agar stack empty → sab chhote the
        if (stack.isEmpty()) {
            span = i + 1;
        } else {
            // nearest greater element ka index
            span = i - stack.peek();
        }

        // current index push karo
        stack.push(i);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */