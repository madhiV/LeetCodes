import java.util.*;
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> l=new LinkedList<>();
        int temp,a,curr,dig=1;
        curr=12;
        while(curr<=high){
            temp=curr;
            while(temp<=high){
                if(temp>=low){
                    l.add(temp);
                }
                temp=temp%(mul10(dig));
                a=temp%10;
                if(a==9){
                    break;
                }
                temp=temp*10+(a+1);
            }
            dig++;
            a=curr%10;
            if(a==9){
                break;
            }
            curr=curr*10+a+1;
        }
        return l;
    }
    public int mul10(int dig){
        int ans=1;
        for(int i=0;i<dig;i++){
            ans*=10;
        }
        return ans;
    }
}
