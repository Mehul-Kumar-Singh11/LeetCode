class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries)
            res.add(matches(q, pattern));
        return res;
    }

    private boolean matches(String query, String pattern) {
        int j = 0;
        for (int i = 0; i < query.length(); i++) {
            char qc = query.charAt(i);
            if (j < pattern.length() && qc == pattern.charAt(j)) {
                j++;
            } else if (Character.isUpperCase(qc)) {
                return false;
            }
        }
        return j == pattern.length();
    }
}