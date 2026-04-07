class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
       do {
            slow = calculateSquaresSum(slow);
            fast = calculateSquaresSum(calculateSquaresSum(fast));
       } while(slow != fast);

        return slow == 1;
    }
    public int calculateSquaresSum(int n)  {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            n = n  / 10;
            sum = sum + (digit * digit);
        }
        return sum;
    }
}