import java.util.*;
class Solution {
    public String deCode(String s,int index){
        if(index==s.length()){
            return "";
        }
        int temp,num;
        String tempS;
        StringBuilder sb=new StringBuilder("");
        while(index<s.length() && Character.isLetter(s.charAt(index))){
            sb.append(s.charAt(index));
            index++;
        }
        if(index!=s.length()){
            temp=index;
            while(Character.isDigit(s.charAt(index))){
                index++;
            }
            num=Integer.parseInt(s.substring(temp,index));
            temp=findEnd(s,index);
            tempS=deCode(s.substring(index+1,temp),0);
            while(num-->0){
                sb.append(tempS);
            }
            sb.append(deCode(s,temp+1));
        }
        return sb.toString();
    }
    public int findEnd(String s,int index){
        int st=1;
        index++;
        while(st!=0){
            if(s.charAt(index)=='['){
                st++;
            }
            else if(s.charAt(index)==']'){
                st--;
            }
            index++;
        }
        index--;
        return index;        
    }
    public String decodeString(String s) {
        return deCode(s,0);
    }
}
