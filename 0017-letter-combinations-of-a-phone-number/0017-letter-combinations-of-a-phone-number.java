class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<>(); // return empty list
        }

        String[] mapping = {
                "", // 0
                "", // 1
                "abc", // 2
                "def", // 3
                "ghi", // 4
                "jkl", // 5
                "mno", // 6
                "pqrs", // 7
                "tuv", // 8
                "wxyz" // 9
        };

        List<String> result = new ArrayList<>();
        backtrack(digits, 0, new StringBuilder(), result, mapping);
        return result;
    }

    public void backtrack(String digits, int idx, StringBuilder temp, List<String> result, String[] mapping) {
        if (idx == digits.length()) {
            result.add(temp.toString()); // convert StringBuidler to String
            return;
        }

        // convert digit char to int index
        String letters = mapping[digits.charAt(idx) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            temp.append(letters.charAt(i));
            backtrack(digits, idx + 1, temp, result, mapping);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}