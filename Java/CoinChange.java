import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {

		var dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1); // invalid big value

		dp[0] = 0;

		for (int i = 1; i < dp.length; i++) {

			// try all coins and if taking jth coin is possible,
			// then ways = 1 (take jth coin) + ways to take remaining amount (amount-jth
			// coin value)
			// take min because we want to find minimum number of coins
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}
			}
		}

		return dp[amount] == amount + 1 ? -1 : dp[amount];

	}
}
