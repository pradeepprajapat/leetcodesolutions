package medium;

import java.util.Arrays;

/*
* You are given an integer array coins representing coins of different denominations
* and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount.
* If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
* */
public class CoinChange {
    public static void main(String[] args) {
        int a[] = {1, 2, 5};
        assert new CoinChange().coinChange(a, 11) == 3;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }

}
