class StockSpanner {

        // Stack will store two things- price and span value
        private Stack<int[]> st;
    
    public StockSpanner() {
        st = new Stack();
    }
    
    public int next(int price) {
        int span = 1;

        while(!st.isEmpty() && st.peek()[0] <= price) {
            // merge span with smaller or equal prices
            span = span + st.peek()[1];
            st.pop();
        }

        // Push the current price and its total span
        st.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */