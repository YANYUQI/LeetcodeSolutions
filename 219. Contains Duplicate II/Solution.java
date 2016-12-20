package containsDuplicateII;

public class Solution {
    /*维护一个HashMap, key为值，value为下标，
    碰到重复时，计算二者的下标距离，如果距离小于或等于k，则返回true,
    将数组中的元素不断添加进这个HashMap,
    否则循环结束返回false。*/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if ((i-map.get(nums[i]))<=k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}