class Solution {
    public String removeDuplicates(String s) {
        String newStr = "";
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!st.empty() && ch == st.peek()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        //  now the stack stores the final result
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
}