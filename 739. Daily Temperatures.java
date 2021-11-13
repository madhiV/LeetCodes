import java.util.*;
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer=new int[temperatures.length];
        Stack<int[]> st=new Stack<>();
        int[] p;
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && st.peek()[0]<temperatures[i]){
                p=st.pop();
                answer[p[1]]=i-p[1];
            }
            st.push(new int[]{temperatures[i],i});
        }
        return answer;
    }
}
