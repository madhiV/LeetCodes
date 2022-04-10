import java.util.*;
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> recordStack=new Stack<>();
        for(String k:ops){
            switch(k){
                case "+":
                    int prevRecord1=recordStack.pop();
                    int prevRecord2=recordStack.pop();
                    int newRecord=prevRecord1+prevRecord2;
                    recordStack.push(prevRecord2);
                    recordStack.push(prevRecord1);
                    recordStack.push(newRecord);
                    break;
                case "D":
                    newRecord=recordStack.peek()*2;
                    recordStack.push(newRecord);
                    break;
                case "C":
                    recordStack.pop();
                    break;
                default:
                    newRecord=Integer.parseInt(k);
                    recordStack.push(newRecord);
            }
        }
        int score=0;
        while(!recordStack.isEmpty()){
            score+=recordStack.pop();
        }
        return score;
    }
}
