// Time Complexity :O(n * k) -> n for max amount loop, k for no of coins
// Space Complexity : O(n) -> DP array for max amount
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We can solve this problem using recursion but we have to
// solve repetative sub problems and greedy choices do not work
// hence we choose to go with DP
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        //1D DP array
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            // Loop for each coin
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
