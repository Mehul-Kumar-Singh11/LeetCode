class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0;
        int high = 0;
        int maxFruit = 0;
        int max_type_fruit = 2;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        while (high < n) {
            hmap.put(fruits[high], hmap.getOrDefault(fruits[high], 0) + 1);
            while (hmap.size() > max_type_fruit) {
                hmap.put(fruits[low], hmap.get(fruits[low]) - 1);
                if (hmap.get(fruits[low]) == 0) {
                    hmap.remove(fruits[low]);
                }
                low++;
            }
            maxFruit = Math.max(maxFruit, high - low + 1);
            high++;
        }
        return maxFruit;
    }
}