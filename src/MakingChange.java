/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Sabrina Vohra
 */

public class MakingChange {
    /**
     * TODO: Complete this function, countWays(), to return the number of ways to make change
     *  for any given total with any given set of coins.
     */

    public static int[] coin;
    public static long[][] numWays;
    public static int total;
    public static long countWays(int target, int[] coins) {
        total = target;
        coin = coins;
        numWays = new long[target + 1][coins.length];
        //return memoWays(target, coins.length - 1);
        return tabWays(target, 0);
    }

    public static long memoWays(int target, int i) {
        if (target == 0) {
            return 1;
        }
        else if ((target < 0) || i >= coin.length || i < 0) {
            return 0;
        }
        else if (numWays[target][i] > 0) {
            return numWays[target][i];
        }
        numWays[target][i] = memoWays(target-coin[i], i) + memoWays(target, i - 1);
        return numWays[target][i];
    }

    public static long tabWays(int target, int index) {
        if(index >= coin.length || target < 0 || index < 0) {
            return 0;
        }
        for(int k = 0; k < coin.length; k++) {
            numWays[0][k] = 1;
        }
        for(int m = 1; m <= target; m++) {
            for(int n = 0; n < coin.length; n++) {
                if ((m - coin[n]) >= 0) {
                    numWays[m][n] += numWays[m - coin[n]][n];
                }
                if ((n - 1) >= 0) {
                    numWays[m][n] += numWays[m][n - 1];
                }
            }
        }
        return numWays[target][coin.length - 1];
    }
}
