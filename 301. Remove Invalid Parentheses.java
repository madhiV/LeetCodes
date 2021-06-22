import java.util.*;
class Solution {
    HashSet<String> ans;
    Solution(){
        ans=new HashSet<>();
    }
    void comb(StringBuilder t,String s,int index,int o,int c,int st){
        if(st<0){
            return;
        }
        if(index==s.length()){
            if(st==0){
                ans.add(t.toString());
            }
            return;
        }
        char ch=s.charAt(index);
        //Exclude
        if(o>0 && ch==40){
            comb(t,s,index+1,o-1,c,st);
        }
        if(c>0 && ch==41){
            comb(t,s,index+1,o,c-1,st);
        }
        //Include
        t.append(ch);
        if(ch==41){
            comb(t,s,index+1,o,c,st-1);
        }
        else if(ch==40){
            comb(t,s,index+1,o,c,st+1);
        }
        else{
            comb(t,s,index+1,o,c,st);
        }
        t.replace(t.length()-1,t.length(),"");
    }
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder t=new StringBuilder("");
        ArrayList<String> list=new ArrayList<String>();
        Solution obj=new Solution();
        HashSet<Integer> skips=new HashSet<>();
        int i=0,flag=0;
        //Skipping ) chars before ( at the start
        while(i<s.length() && s.charAt(i)!=40){
            if(s.charAt(i)==41){
                skips.add(i);
            }
            i++;
        }
        //Skipping ( chars after ) at the end
        i=s.length()-1;
        while(i>=0 && s.charAt(i)!=')'){
            if(s.charAt(i)==40){
                skips.add(i);
            }
            i--;
        }
        //Skipping those invalid parenthesis before and after the string
        for(i=0;i<s.length();i++){
            if(!skips.contains(i)){
                t.append(s.charAt(i));
            }
        }
        s=t.toString();
        int st=0,min=0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)==40){
                st++;
                flag=1;
            }
            else if(s.charAt(i)==41){
                if(st==0){
                    min++;
                    continue;
                }
                st--;
                flag=1;
            }
        }
        if(flag==0 || (st==0 && min==0)){
            list.add(s);
            return list;
        }
        t=new StringBuilder("");
        obj.comb(t,s,0,st,min,0);
        list.addAll(obj.ans);
        return list;
    }
}
