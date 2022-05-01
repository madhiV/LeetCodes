class Solution {
    public boolean backspaceCompare(String s, String t) {
        int index1=s.length()-1;
        int index2=t.length()-1;
        int count1=0;
        int count2=0;
        
        while(index1>=0 && index2>=0){
            //String 1...
            do{
                if(s.charAt(index1)=='#'){
                    count1++;
                }
                else{
                    if(count1==0){
                        break;
                    }
                    count1--;
                }
                index1--;
            }while(index1>=0);
            
            //String 2...
            do{
                if(t.charAt(index2)=='#'){
                    count2++;
                }
                else{
                    if(count2==0){
                        break;
                    }
                    count2--;
                }
                index2--;
            }while(index2>=0);
            
            if(index1==-1 || index2==-1){
                break;
            }
            
            if(s.charAt(index1)!=t.charAt(index2)){
                return false;
            }
            index1--;
            index2--;
        }
        
        while(index1!=-1){
            if(s.charAt(index1)=='#'){
                count1++;
            }
            else{
                if(count1==0){
                    return false;
                }
                count1--;
            }
            index1--;
        }
        
        while(index2!=-1){
            if(t.charAt(index2)=='#'){
                count2++;
            }
            else{
                if(count2==0){
                    return false;
                }
                count2--;
            }
            index2--;
        }
        
        return index1==index2;
    }
}
