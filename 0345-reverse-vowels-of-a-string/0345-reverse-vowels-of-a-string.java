class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = str.length - 1;
        
        while (left < right) {
            
            // Move left pointer until a vowel is found
            while (left < right && !isVowel(str[left])) {
                left++;
            }

            // Move right pointer until a vowel is found
            while (left < right && !isVowel(str[right])) {
                right--;
            }

            // Swap the vowels
            if (left < right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(str);
    }

    // Func. to check if a character is a vowel
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' 
               || c == 'o' || c == 'u' || 
               c == 'A' || c == 'E' || c == 'I' 
               || c == 'O' || c == 'U';
    }
}