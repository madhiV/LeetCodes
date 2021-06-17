import java.util.*;
class Solution {
    public String convert(String s, int numRows) {
        int j,first,count,second,l=s.length(),maxLength=numRows*2-2;
        StringBuilder ans=new StringBuilder("");
        if(numRows==1){
            return s;
        }
        for(int i=0;i<numRows;i++){
            j=i;
            if(i==0 || i==numRows-1){
                first=second=maxLength;
            }
            else{
                first=maxLength-2*i;
                second=maxLength-first;
            }
            count=0;
            while(j<l){
                ans.append(s.charAt(j));
                if(count==0){
                    j+=first;
                    count=1;
                }
                else{
                    j+=second;
                    count=0;
                }
            }
        }
        return ans.toString();
    }
}
