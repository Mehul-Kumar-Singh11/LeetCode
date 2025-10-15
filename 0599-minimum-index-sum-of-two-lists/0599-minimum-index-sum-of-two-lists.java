class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> minval = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int min = 10000;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j]) && (min >= i + j)) {

                    min = i + j;
                    map.put(list1[i], min);
                    break;
                }
            }

        }
        for (String str : map.keySet()) {
            if (map.get(str) == min)
                minval.add(str);
        }
        String[] res = new String[minval.size()];
        int ind = 0;
        for (String s : minval) {
            res[ind] = s;
            ind++;
        }
        return res;
    }
}