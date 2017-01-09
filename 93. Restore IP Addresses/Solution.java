package restoreIPAddresses;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res=new ArrayList<String>();
        String ip="";
        if(s.length()<4||s.length()>12) return res;
        dfs(res,ip,s,0);
        return res;
    }
    
    public void dfs(ArrayList<String> res,String ip,String s,int start){
        String[] tmp=ip.split("\\.");
        if(tmp.length==3){//当层数是3的时候说明已经尝试填过3个段了，那么把剩余没填的数(如果合法的话段接到结尾即可。
            if(s.length()-start<=3 && isValid(s.substring(start))){
                res.add(ip+s.substring(start));
            }
            return;
        }
        //最多3位最少1位，所以在每一层可以循环3次
        for(int i=start+1;i<=start+3 && i<s.length();i++){
            String newip=s.substring(start,i);
            if(isValid(newip)){
                dfs(res,ip+newip+".",s,i);
            }
        }
    }
    
    public boolean isValid(String s){
        int num = Integer.parseInt(s);
        //注意如果开头是0，判断整个串是不是0，不是就是非法的。001，01都是不对的。
        if(s.charAt(0)=='0'){
            return s.equals("0");
        }
        return (num>0 && num<=255);
    }
}