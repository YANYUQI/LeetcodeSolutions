package containsDuplicateIII;

public class Solution {
    //treeset：http://www.cnblogs.com/chenssy/p/3772661.html
    //在HashSet中不能有重复记录,但是TreeSet可以
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            Integer floor = set.floor(x);//floor：返回此 set 中小于等于给定元素的最大元素；如果不存在这样的元素，则返回 null。
            Integer ceiling = set.ceiling(x);//ceiling：返回此 set 中大于等于给定元素的最小元素；如果不存在这样的元素，则返回 null。
            if ((floor != null && x <= floor + t) || (ceiling != null && x >= ceiling -t)){
                //floor和ceiling用Integer定义，是为了可以用于判断是否为null。定义为int则不行。只有对象可以为null
                return true;
            }
            set.add(x);
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}