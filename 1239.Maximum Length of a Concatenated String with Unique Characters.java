class Solution {
    int max;
    public int maxLength(List<String> arr) {
        max=0;
        computeMax(0,new int[26],arr,0);
        return max;
    }
    private void computeMax(int index,int[] included,List<String> arr,int count){
        if(index==arr.size()){
            max=Math.max(max,count);
            return;
        }
        //Skip
        computeMax(index+1,included,arr,count);
        
        //inlcude
        String s=arr.get(index);
        int c;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i)-97;
            if(included[c]==1){
                flag=false;
            }
            included[c]++;
        }
        count+=s.length();
        if(flag){
            computeMax(index+1,included,arr,count);
        }
        reset(included,s);
    }
    private void reset(int[] arr,String s){
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]--;
        }
    }
}
