package candy;

public class Solution {
    //reference http://blog.csdn.net/lanxu_yy/article/details/17752273 思路二
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)  return 0;
            
        int candies[] = new int[ratings.length];
        
        for(int i=0;i<candies.length;i++){
            candies[i]=1;
        }
        
        for(int i=1;i<candies.length;i++){
            if(ratings[i-1]<ratings[i]){
                candies[i]=candies[i-1]+1;
            }
        }
        
        for(int i=candies.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        
        int sum=0;
        for(int i=0;i<candies.length;i++){
            sum+=candies[i];
        }
        
        return sum;
    }
}
