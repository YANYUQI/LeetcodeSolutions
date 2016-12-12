package permutationSequence;

public class Solution {
    //全排列的编码与解码——康托展开
    //参考https://soulmachine.gitbooks.io/algorithm-essentials/content/java/linear-list/array/permutation-sequence.html
    public String getPermutation(int n, int k) {  
    int []num = new int[n];  
        int permCount = 1;  
        for(int i=0;i<n;i++){  
            num[i] = i+1;  
            permCount*=(i+1);  
        }  
        k--;  
        StringBuilder target = new StringBuilder();  
        for(int i=0;i<n;i++){  
            permCount = permCount/(n-i);  
            int choosed = k/permCount;  
            target.append(num[choosed]);  
            for(int j=choosed;j<n-i-1;j++){  
                num[j] = num[j+1];  
            }  
            k = k%permCount;  
        }  
        return target.toString();  
    } 
}