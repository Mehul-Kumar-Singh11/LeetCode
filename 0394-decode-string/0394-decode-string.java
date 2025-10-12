class Solution {
    int i = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (c == '[') {
                String tem = decodeString(s);
                while (count != 0) {
                    sb.append(tem);
                    count--;
                }
            } else if (c == ']') {
                break;
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}