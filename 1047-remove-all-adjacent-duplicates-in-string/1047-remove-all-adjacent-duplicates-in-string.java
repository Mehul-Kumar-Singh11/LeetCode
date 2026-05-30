class Solution {
    public String removeDuplicates(String s) {
        String newStr = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!st.empty() && s.charAt(i) == st.peek()) {
                st.pop();
                continue;
            } else {
                st.push(s.charAt(i));
            }
        }

        //  now the stack stores the final result
        while (!st.empty()) {
            char ch = st.peek();
            newStr = ch + newStr;
            st.pop();
        }
        return newStr;
    }
}