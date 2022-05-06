import java.util.Stack;
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> characterCountStack=new Stack<>();
        //Removing k adjacent duplicates
        for(int index=0;index<s.length();index++){
            char ch=s.charAt(index);
            if(characterCountStack.isEmpty() || characterCountStack.peek()[0]!=ch){
                characterCountStack.push(new int[]{ch,1});
            }
            else{
                int[] peekStackElement=characterCountStack.peek();
                peekStackElement[1]++;
                if(peekStackElement[1]==k){
                    characterCountStack.pop();
                }
            }
        }
        //Constructing String from remaining characters...
        StringBuilder answerSB=new StringBuilder();
        while(!characterCountStack.isEmpty()){
            int[] peekElement=characterCountStack.pop();
            int count=peekElement[1];
            char ch=(char)peekElement[0];
            while(count-->0){
                answerSB.insert(0,ch);
            }
        }
        return answerSB.toString();
    }
}
