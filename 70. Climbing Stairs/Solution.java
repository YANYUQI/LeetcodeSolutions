package climbingStairs;

public class Solution {
    //reference https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/climbing-stairs.html
    // ·½·¨Èý£º
    public int climbStairs(int n) {
        final double s = Math.sqrt(5);
        return (int)Math.floor((Math.pow((1+s)/2, n+1) + 
            Math.pow((1-s)/2, n+1))/s + 0.5);
    }
}
