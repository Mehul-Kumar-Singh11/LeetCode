class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_profit = 0;
        int min_buy_price = prices[0];
        for(int i=1;i<n;i++) {
            if(min_buy_price > prices[i]) {
                min_buy_price = prices[i];
            }
            else {
                int curr_profit = prices[i] - min_buy_price;
                max_profit = Math.max(max_profit, curr_profit);
            }
        }
        return max_profit;
    }
}