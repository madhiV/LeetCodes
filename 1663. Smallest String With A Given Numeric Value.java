class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr=new char[n];
        int i=n-1;
        //Filling up z's...
        while(i>=0 && k>=26 && k-26>=i){
            arr[i]='z';
            i--;
            k-=26;
        }
        //Filling the arr[i]!='z'
        while(i!=-1){
            arr[i]=(char)(96+k-i);
            k=i;
            i--;
        }
        return String.valueOf(arr);
    }
}
