class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // backtrackApproach1(1, n, k, temp, result);
        backtrackApproach2(1, n, k, temp, result);
        return result;
    }

    // public void backtrackApproach1(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
    //     if (k == 0) {
    //         result.add(new ArrayList<Integer>(temp));
    //         return;
    //     }
    //     // Base Case
    //     if (start > n) {
    //         return;
    //     }
    //     // take or skip approach
    //     temp.add(start);
    //     backtrackApproach1(start + 1, n, k - 1, temp, result);
    //     temp.remove(temp.size() - 1);
    //     backtrackApproach1(start + 1, n, k, temp, result);
    // }

    // using for loop
    public void backtrackApproach2(int start, int n, int k, List<Integer> temp, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrackApproach2(i + 1, n, k - 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}