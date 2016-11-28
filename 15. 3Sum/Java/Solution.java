package threeSum_3Sum;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==-nums[i]){
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while((j<k)&(nums[j]==nums[j-1])){
                        j++;
                    }
                    while((j<k)&(nums[k]==nums[k+1])){
                        k--;
                    }
                }else if(nums[j]+nums[k]<-nums[i]){
                    j++;
                    while((j<k)&(nums[j]==nums[j-1])){
                        j++;
                    }
                }else{
                    k--;
                    while((j<k)&(nums[k]==nums[k+1])){
                        k--;
                    }
                }
            }
            i++;
            while((i<nums.length-2)&(nums[i]==nums[i-1])){
                 i++;
            }
        }
        return list;
    }
}
