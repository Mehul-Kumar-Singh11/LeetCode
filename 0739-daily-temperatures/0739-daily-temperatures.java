class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>(); // to store index

        int n = temperatures.length;
        for(int i=n-1;i>=0;i--) {
            // pop all indexes with a lower or equal temperature until find a warmer temperature
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }

            // if stack is not empty, means found a warmer temperature
            if(!st.isEmpty()) {
                result[i] = st.peek() - i;
            }

            // insert current index in the stack
            st.push(i);
        }

        return result;
    }
}