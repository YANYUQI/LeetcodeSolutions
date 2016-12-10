package LongestConsecutiveSequence;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int countMax=1;
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])) continue;
            int count=1;
            int tmp=nums[i]-1;
            while(set.contains(tmp)){
                count++;
                set.remove(tmp);
                tmp--;
            }
            tmp=nums[i]+1;
            while(set.contains(tmp)){
                count++;
                set.remove(tmp);
                tmp++;
            }
            countMax=Math.max(countMax,count);
        }
        return countMax;
    }
}
