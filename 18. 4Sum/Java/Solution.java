package fourSum_4Sum;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new  ArrayList<List<Integer>>();
        Map<Integer,List<List<Integer>>> map=new HashMap<Integer,List<List<Integer>>>();
        
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if (map.containsKey(sum)){
                    List<Integer> tmp=new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    map.get(sum).add(tmp);
                }else{
                    List<Integer> tmp=new ArrayList<Integer>();
                    tmp.add(i);
                    tmp.add(j);
                    List<List<Integer>> tmp2=new  ArrayList<List<Integer>>();
                    tmp2.add(tmp);
                    map.put(sum,tmp2);
                }
            }
        }
        
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int diff=target-nums[i]-nums[j];
                if (map.containsKey(diff)){
                    for(int k=0;k<(map.get(diff)).size();k++){
                        if(map.get(diff).get(k).get(0)>j){
                            List<Integer> tmp=new ArrayList<Integer>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[map.get(diff).get(k).get(0)]);
                            tmp.add(nums[map.get(diff).get(k).get(1)]);
                            if(!res.contains(tmp)){
                                res.add(tmp);
                            }
                        }
                    }
                }
            }
        }
        return res;  
    }
}
