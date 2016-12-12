package plusOne;

public class Solution {
    public int[] plusOne(int[] digits) {
        //从后往前，有一个小于9的，就可以break出来；其余的等于9的就更新为0
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                break;
            }else{
                digits[i]=0;
            }
        }
        //边界条件就是全为9时，则新建一个数组，第一位1，其余位同digits
        if(digits[0]==0){
            int[] newdigits = new int[digits.length+1];
            newdigits[0]=1;
            for(int i=1;i<newdigits.length;i++){
                newdigits[i]=digits[i-1];
            }
             return newdigits;
        }
        //否则直接return digits
        return digits;
    }
}
