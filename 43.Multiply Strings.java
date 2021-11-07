import java.util.*;
class Solution {
    public String multiply(String num1, String num2) {
        int sum,carry=0,shift=0,pos,size,temp;
        ArrayList<Integer> al=new ArrayList<>();
        StringBuilder sb=new StringBuilder("");
        for(int i=num2.length()-1;i>=0;i--){
            size=al.size();
            temp=shift;
            for(int j=num1.length()-1;j>=0;j--){
                sum=(num1.charAt(j)-48)*(num2.charAt(i)-48);
                sum+=carry;
                if(size>temp){
                    pos=size-temp-1;
                    sum+=al.get(pos);
                    al.set(pos,sum%10);
                }
                else{
                    al.add(0,sum%10);
                }
                carry=sum/10;
                temp++;
            }
            if(carry!=0){
                al.add(0,carry);
                carry=0;
            }
            shift++;
        }
        temp=0;
        while(temp<al.size()){
            if(al.get(temp)==0){
                temp++;
            }
            else{
                break;
            }
        }
        if(temp==al.size()){
            return "0";
        }
        while(temp<al.size()){
            sb.append(al.get(temp));
            temp++;
        }
        return sb.toString();
    }
}
