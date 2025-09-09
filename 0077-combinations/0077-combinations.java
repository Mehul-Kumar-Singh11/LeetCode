class Solution {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> temp = new ArrayList<>();
      backtrack(1, n, k, temp, result);  
      return result;
    }
    public void backtrack(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if(k==0) {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        // Base Case
        if(start > n) {
            return;
        }

        temp.add(start);
        backtrack(start+1, n, k-1, temp, result);
        temp.remove(temp.size()-1);
        backtrack(start+1, n, k, temp, result);
    }
}