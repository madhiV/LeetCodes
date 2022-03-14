import java.util.*;
class Solution {
    public String simplifyPath(String path) {
        int start=0;
        String s;
        StringBuilder sb=new StringBuilder("");
        Stack<String> st=new Stack<>();
        for(int i=0;i<=path.length();i++){
            if(i==path.length() || path.charAt(i)=='/'){
                s=path.substring(start,i);
                if(s.length()==0){
                    start=i+1;
                    continue;
                }
                if(s.equals("..")){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                }
                else if(!s.equals(".")){
                    st.push(s);
                }
                start=i+1;
            }
        }
        
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
            if(!st.isEmpty()){
                sb.insert(0,"/");
            }
        }
        sb.insert(0,"/");
        return sb.toString();
    }
}
