package fourSumII_4SumII;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        int l=A.length;
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(map.containsKey(A[i]+B[j])){
                    map.put(A[i]+B[j],map.get(A[i]+B[j])+1);
                }else{
                    map.put(A[i]+B[j],1);
                }
            }
        }
        
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                if(map.containsKey(-C[i]-D[j])){
                    count+=map.get(-C[i]-D[j]);
                }
            }
        }
        return count;
    }
}