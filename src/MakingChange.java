/**
 * The class Making Change solves a classic problem:
 * given a set of coins, how many ways can you make change for a target amount?
 *
 * @author Zach Blick
 * @author Sabrina Vohra
 */

public class MakingChange {
    // Created variables for entire class
    public static int[] coin;
    public static long[][] numWays;

    public static long countWays(int target, int[] coins) {
        // Initializes variables
        coin = coins;
        numWays = new long[target + 1][coins.length];
        // Calls two methods for either memoization or tabulation approach

        // Comment in the line below for memoization approach
        return memoWays(target, coins.length - 1);
        // Comment in the line below for tabulation approach
        //return tabWays(target);
    }

    // Completes solution using memoization
    public static long memoWays(int target, int i) {
        // Base cases to not go out of bounds or repeat same recursive calls multiple times
        if (target == 0) {
            return 1;
        }
        else if ((target < 0) || i < 0) {
            return 0;
        }
        else if (numWays[target][i] > 0) {
            return numWays[target][i];
        }
        // Recursively calls to use memoization for using one less coin value in target and one less coin in coins and
        // updates in table
        numWays[target][i] = memoWays(target-coin[i], i) + memoWays(target, i - 1);
        return numWays[target][i];
    }

    // Method solves using tabulation
    public static long tabWays(int target) {
        // Sets all spots with 0 as a value and any coins as equal to 1
        for(int k = 0; k < coin.length; k++) {
            numWays[0][k] = 1;
        }
        // Goes through all spots in table and updates each one
        for(int m = 1; m <= target; m++) {
            for(int n = 0; n < coin.length; n++) {
                // Finds lesser value if target is large enough to subtract a coin
                if ((m - coin[n]) >= 0) {
                    numWays[m][n] += numWays[m - coin[n]][n];
                }
                // Finds lesser value if there is another coin of lesser value
                if ((n - 1) >= 0) {
                    numWays[m][n] += numWays[m][n - 1];
                }
            }
        }
        // Returns last spot in table
        return numWays[target][coin.length - 1];
    }
}
