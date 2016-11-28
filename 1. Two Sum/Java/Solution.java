package TwoSum;

//the second scheme
public class Solution {
  public int[] twoSum(int[] nums, int target) {
      int[] result=new int[2];
      Map<Integer,Integer> map=new HashMap<Integer,Integer>();
      for(int i=0;i<nums.length;i++){
          int x=nums[i];
          if(map.containsKey(target-x)){
              result[0]=map.get(target-x);
              result[1]=i;
              return result;
          }else{
              map.put(x,i);
          }
      }
      return result;
  }
}