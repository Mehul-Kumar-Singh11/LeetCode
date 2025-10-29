class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String bin = Integer.toBinaryString(i);
            if (!s.contains(bin)) {
                return false;
            }
        }
        return true;
    }
    // public boolean isSubs(String temp,String s){
    //     //boolean res = true;
    //     if(temp.length()>s.length()) return false;
    //     int i = 0;
    //     int j = temp.length();
    //     while(j<s.length()){
    //         if(!temp.equals(s.substring(i,j))){
    //             return false;
    //         }
    //         i++;
    //         j++;
    //     }
    //     return true;

    // }
}