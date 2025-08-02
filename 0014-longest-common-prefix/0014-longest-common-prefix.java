class Solution {
    public String longestCommonPrefix(String[] strs) {

        /* Using SORTING 
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Sort lexicographically
        Arrays.sort(strs);
        
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLength = Math.min(first.length(), last.length());
        
        int i = 0;
        while (i < minLength) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            }
            i++;
        }
        return first.substring(0, i); 
        */

        // Using Horizontal Scanning and shrinking prefix
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}