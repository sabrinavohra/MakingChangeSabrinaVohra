import java.util.ArrayList;

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
    public static int[][] memo;
    public static long countWays(int target, int[] coins) {
        coin = coins;
        memo = new int[target][coins.length];
        return ways(target, 0);
    }

    public static int ways(int target, int i) {

        if (target == 0) {
            return 1;
        }
        if ((target < 0) || i >= coin.length) {
            return 0;
        }
        if(memo[target][i] != 0) {
            return  memo[target][i];
        }

        memo[target][i] = ways(target-coin[i], i) + ways(target, i + 1);
        return memo[target][i];
    }
}
