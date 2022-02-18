import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        int n;
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<num.length();i++){
            n=num.charAt(i)-48;
            if(k!=0){
                while(!st.isEmpty() && st.peek()>n && k!=0){
                    st.pop();
                    k--;
                }
            }
            st.push(n);
        }
        while(k!=0){
            st.pop();
            k--;
        }
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        k=0;
        while(k<sb.length() && sb.charAt(k)==48){
            k++;
        }
        if(k==sb.length()){
            return "0";
        }
        return sb.substring(k);
    }
}
