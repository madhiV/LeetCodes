class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        char c;
        int start=0,count=0;
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            c=s2.charAt(i);
            if(arr1[c-'a']==0){
                reset(arr2);
                count=0;
                start=i+1;
            }
            else if(arr2[c-'a']==arr1[c-'a']){
                while(s2.charAt(start)!=c){
                    arr2[s2.charAt(start)-'a']--;
                    start++;
                    count--;
                }
                start++;
            }
            else{
                arr2[c-'a']++;
                count++;
            }
            if(count==s1.length()){
                return true;
            }
        }
        return false;
    }
    private void reset(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=0;
        }
    }
}
