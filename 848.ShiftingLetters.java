import java.util.*;
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb=new StringBuilder("");
        sb.append(shift(s.charAt(s.length()-1),shifts[shifts.length-1]));
        while(shifts[shifts.length-1]>25){
                shifts[shifts.length-1]%=26;
            }
        for(int i=shifts.length-2;i>=0;i--){
            shifts[i]+=shifts[i+1];
            sb.insert(0,shift(s.charAt(i),shifts[i]));
            while(shifts[i]>25){
                shifts[i]%=26;
            }
        }
        return sb.toString();
    }
    public char shift(char c,int shift){
        shift+=c-97;
        while(shift>25){
            shift%=26;
        }
        return (char)(shift+97);
    }
}
