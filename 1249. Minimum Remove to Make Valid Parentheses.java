import java.util.*;
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack=new Stack<>();
        Set<Integer> set=new HashSet<>();
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==40){
                stack.push(i);
            }
            else if(s.charAt(i)==41){
                if(stack.isEmpty()){
                    set.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        for(int i=0;i<s.length();i++){
            if(!set.contains(i)){
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
