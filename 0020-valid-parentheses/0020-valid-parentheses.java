class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            // we are only inserting open brackets category in stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                // if stack is empty, return false immediately
                if (st.empty()) {
                    return false;
                } else {
                    if (ch == ')' && st.peek() == '('
                            || ch == '}' && st.peek() == '{'
                            || ch == ']' && st.peek() == '[') {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return st.empty();
    }
}