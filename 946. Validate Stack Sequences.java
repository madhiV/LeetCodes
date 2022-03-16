import java.util.*;
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int curr=0;
        for(int i=0;i<pushed.length;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek()==popped[curr]){
                st.pop();
                curr++;
            }
        }
        while(!st.isEmpty() && st.peek()==popped[curr]){
            st.pop();
            curr++;
        }
        return st.isEmpty();
    }
}
