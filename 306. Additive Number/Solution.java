package additiveNumber;

public class Solution {
    //参考：https://soulmachine.gitbooks.io/algorithm-essentials/content/java/dfs/additive-number.html
    public boolean isAdditiveNumber(String num) {
        if(num.length()<3) return false;
        //选取起始的两个数字 [i, j) 和 [j, k)
        for(int i=1;i<=num.length()/2;i++){
            if (num.charAt(0) == '0' && i > 1) break;//如果位数大于1且第一位为0，就break这个循环
            for(int j=i+1;j<num.length();j++){
                if(num.charAt(i)=='0'&& j - i > 1) break;//如果位数大于1且第一位为0，就break这个循环
                if(dfs(num,0,i,j)) return true;
            }
        }
        return false;
    }
        
        // 判断从 [i, j) 和 [j, k) 出发,能否走到尽头
        private static boolean dfs(String num,int i,int j,int k){
            long num1=Long.parseLong(num.substring(i,j));
            long num2=Long.parseLong(num.substring(j,k));
            final String addition=String.valueOf(num1+num2);
            if(!num.substring(k).startsWith(addition)) return false;
            if(k+addition.length()==num.length()) return true;
            return dfs(num,j,k,k+addition.length());
        }
}