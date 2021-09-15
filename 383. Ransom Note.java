class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        int count=0,temp;
        for(int i=0;i<ransomNote.length();i++){
            temp=ransomNote.charAt(i)-97;
            arr[temp]++;
            if(arr[temp]==1){
                count++;
            }
        }
        for(int i=0;i<magazine.length();i++){
            temp=magazine.charAt(i)-97;
            if(arr[temp]>0){
                arr[temp]--;
                if(arr[temp]==0){
                    count--;
                }
            }
        }
        return count==0;
    }
}
