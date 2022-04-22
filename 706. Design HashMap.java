class MyHashMap {
    int[] mapValues;
    public MyHashMap() {
        mapValues=new int[1000001];
        Arrays.fill(mapValues,-1);
    }
    
    public void put(int key, int value) {
        mapValues[key]=value;
    }
    
    public int get(int key) {
        return mapValues[key];
    }
    
    public void remove(int key) {
        mapValues[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
