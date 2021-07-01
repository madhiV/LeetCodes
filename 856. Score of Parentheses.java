import java.util.*;
class Solution {
    public int scoreOfParentheses(String s) {
        return eval(s,0,s.length()-1);
    }
    public int eval(String s,int start,int end){
        if(start>end){
            return 0;
        }
        if(s.charAt(start+1)==41){
            return 1+eval(s,start+2,end);
        }
        else{
            if(canSplit(s,start,end)){
                int ans=0;
                Map<Integer,Integer> dic=splitUp(s,start,end);
                Set<Map.Entry<Integer,Integer>> entry=dic.entrySet();
                for(Map.Entry<Integer,Integer> k:entry){
                    ans+=eval(s,k.getKey(),k.getValue());
                }
                return ans;
            }
            return 2*eval(s,start+1,end-1);
        }
    }
    public boolean canSplit(String s,int start,int end){
        int stack=0,ans=0;
        for(int i=start;i<=end;i++){
            if(s.charAt(i)==40){
                stack++;
            }
            else if(s.charAt(i)==41){
                stack--;
                if(stack==0){
                    ans++;
                }
            }
        }
        if(ans>1){
            return true;
        }
        return false;
    }
    public Map<Integer,Integer> splitUp(String s,int st,int en){
        Map<Integer,Integer> dic=new HashMap<>();
        int stack=0,start=st,end=0,ans=0;
        for(int i=st;i<=en;i++){
            if(s.charAt(i)==40){
                stack++;
            }
            else if(s.charAt(i)==41){
                stack--;
                if(stack==0){
                    dic.put(start,i);
                    start=i+1;
                }
            }
        }
        return dic;
    }
}
