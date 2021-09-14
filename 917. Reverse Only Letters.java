import java.util.*;
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr=s.toCharArray();
        char c;
        ArrayList<Integer> al=new ArrayList<>();
        int l,r;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if((c>=65 && c<=90) || (c<=122 && c>=97)){
                al.add(i);
            }
        }
        l=0;
        r=al.size()-1;
        while(l<r){
            c=arr[al.get(l)];
            arr[al.get(l)]=arr[al.get(r)];
            arr[al.get(r)]=c;
            l++;
            r--;
        }
        return String.valueOf(arr);
    }
}
