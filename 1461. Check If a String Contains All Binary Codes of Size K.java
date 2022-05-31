import java.util.*;
class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> binCodeSet=new HashSet<>();
        for(int index=0;index<s.length()-k+1;index++){
            int value=binToDecimal(s,index,k);
            binCodeSet.add(value);
        }
        return binCodeSet.size()==Math.pow(2,k);
    }
    private int binToDecimal(String s,int start,int k){
        int sum=0;
        int index=start;
        while(index<start+k){
            sum=sum*2+s.charAt(index)-48;
            index++;
        }
        return sum;
    }
}
