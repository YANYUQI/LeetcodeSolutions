package increasingTripletSubsequence;

public class Solution {
    //关键是维护一个数，来保存到目前为止从左到右第二大的数是多少，只要有一个数大于这个数就可以了。
    public boolean increasingTriplet(int[] nums) {
        int x1 = Integer.MAX_VALUE;
        //x1用来存到目前为止最小的那个数，这个值遇到小的可以实时更新，对结果没关系，因为重点在于对比第二大的数和新循环到的那个数字。
        int x2 = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x <= x1) x1 = x;
            else if (x <= x2) x2 = x;
            else return true;
        }
        return false;
    }
}