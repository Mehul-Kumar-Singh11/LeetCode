class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int arr[] = new int[2000];
        int z = 0;
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                arr[z] = fronts[i];
                z++;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < fronts.length; i++) {
                if (arr[j] == fronts[i]) {
                    fronts[i] = 3000;
                }
                if (arr[j] == backs[i]) {
                    backs[i] = 3000;
                }
            }
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (min1 > fronts[i]) {
                min1 = fronts[i];
            }
            if (min2 > backs[i]) {
                min2 = backs[i];
            }
        }

        if (min1 == 3000 && min2 == 3000) {
            return 0;
        }

        if (min1 < min2) {
            return min1;
        } else {
            return min2;
        }

    }
}