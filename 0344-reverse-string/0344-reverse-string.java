class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length;i++) {
            st.push(s[i]);
        }
        int j = 0;
        while(!st.isEmpty()) {
            char element = st.peek();
            st.pop();
            s[j] = element;
            j++;
        }
    }
}