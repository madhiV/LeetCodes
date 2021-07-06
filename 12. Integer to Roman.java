import java.util.*;
class Solution {
    Map<Integer,Character> dic;
    public String intToRoman(int num) {
        String ans="";
        int count=1,temp;
        dic=new HashMap<>();
        dic.put(1,'I');
        dic.put(5,'V');
        dic.put(10,'X');
        dic.put(50,'L');
        dic.put(100,'C');
        dic.put(500,'D');
        dic.put(1000,'M');
        while(num!=0){
            temp=num%10;
            num/=10;
            ans=findRoman(temp,count)+ans;
            count++;
        }
        return ans;
    }
    String findRoman(int n,int digits){
        int temp=n;
        StringBuilder res=new StringBuilder("");
        if(n==9){
            if(digits==1){
                res.append(dic.get(1));
                res.append(dic.get(10));
            }
            else if(digits==2){
                res.append(dic.get(10));
                res.append(dic.get(100));
            }
            else{
                res.append(dic.get(100));
                res.append(dic.get(1000));
            }
        }
        else if(n==4){
            if(digits==1){
                res.append(dic.get(1));
                res.append(dic.get(5));
            }
            else if(digits==2){
                res.append(dic.get(10));
                res.append(dic.get(50));
            }
            else{
                res.append(dic.get(100));
                res.append(dic.get(500));
            }
        }
        else{
            if(n>=5){
                res.append(dic.get(5*(int)Math.pow(10,digits-1)));
                n-=5;
            }
            while(n>0){
                res.append(dic.get((int)Math.pow(10,digits-1)));
                n--;
            }
        }
        return res.toString();
    }
}
