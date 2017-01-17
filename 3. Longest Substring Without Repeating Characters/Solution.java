package longestSubstringWithoutRepeatingCharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last=new int[128]; //测试用例的字符从空格到大写字母Z，所以128足够了
        Arrays.fill(last,-1);//last数组用于保存新出现的字符的下标，一开始全部初始化为-1
        int len=0;
        int start=0;
        
        for(int j=0;j<s.length();j++){
            if(last[s.charAt(j)-' ']<start){  //注意是用start来判断，当start之后不含此char时
                last[s.charAt(j)-' ']=j;
            }else{        //start之后含着个char时
                len=Math.max(j-start,len);
                start=last[s.charAt(j)-' ']+1;
                last[s.charAt(j)-' ']=j;
            }
        }
        
        return Math.max(s.length()-start,len);//针对最后一次len更新后还出现更长的，或者针对len从未更新过的情况
    }
}