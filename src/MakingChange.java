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
    private static int[] possiblities;
    public static long countWays(int target, int[] coins) {
        possiblities = new int[target];
        for(int i = 0; i < target; i++) {
            ways(target, coins, 0);
        }



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
        // Possible base cases? Possible ways to save number of paths to certain target value / certain number of coins?
        if (target <= 0 || coins.length <= 1) {
            return currentWays + 1;
        }
        if (possiblities[target] != 0) {
            return possiblities[target];
        }
        // How to find combinations that work?
        currentWays++;
        possiblities[target] = currentWays;
        int[] newCoins = new int[coins.length - 1];
        for(int i = 0; i < newCoins.length; i++) {
            newCoins[i] = coins[i];
        }
        ways(target - 1, coins, currentWays);
        ways(target, newCoins, currentWays);
        return currentWays;
    }
}
