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
    public static long countWays(int target, int[] coins) {
        // Take stock of the coins in list

        //Ideas:
        // Create recursive algorithm:
        // Start by taking the largest coin and dividing the target by it the appropriate amount of times
        // Then, split into smaller values and do the appropriate number of each to reach target
        // Find which coins fit into the other coins to create their values
        // How to perform the two solutions recursively / efficiently?
        // Bottom up solution:
        // Start with the smallest coins and then start adding larger coins to the solution
        // Top down solution:
        // Start with the largest coins and then start replacing them with smaller coins

        // Find way to join together the two ways of solving smaller problems
        // 1. Lessening the number of the target value
        // 2. Removing certain coins to solve the problem with less coins

        return ways(target, coins, 0);

        //return (long) target % coins.length * (2L * target);
    }

    public static int ways(int target, int[] coins, int currentWays) {
        if (target <= 0 || coins.length <= 1) {
            return currentWays;
        }
        currentWays++;
        return ways(target - 1, coins ,currentWays);
    }
}
