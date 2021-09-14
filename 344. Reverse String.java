class Solution {
    public void reverseString(char[] s) {
        char temp;
        int l,r;
        l=0;
        r=s.length-1;
        while(l<r){
            temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }
}
