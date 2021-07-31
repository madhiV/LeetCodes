class MapSum {
    int[] value;
    String[] keys;
    /** Initialize your data structure here. */
    public MapSum() {
        keys=new String[50];
        value=new int[50];
    }
    
    public void insert(String key, int val) {
        for(int i=0;i<50;i++){
            if(keys[i]==null){
                keys[i]=key;
                value[i]=val;
                break;
            }
            else if(keys[i].equals(key)){
                value[i]=val;
                break;
            }
        }
    }
    
    public int sum(String prefix) {
        int sum=0,j;
        for(int i=0;i<50;i++){
            if(keys[i]==null){
                break;
            }
            j=0;
            while(j<keys[i].length() &&  j<prefix.length() && keys[i].charAt(j)==prefix.charAt(j)){
                j++;
            }
            if(j==prefix.length()){
                sum+=value[i];
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
