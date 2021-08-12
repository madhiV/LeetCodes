class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,LinkedList<Integer>> map=new HashMap<>();//for mapping value with positions of it in arr
        Set<Integer> set=new HashSet<>();//for storing paired indices
        LinkedList<Integer> l;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            l=map.get(arr[i]);
            if(l==null){
                l=new LinkedList<>();
                l.add(i);
                map.put(arr[i],l);
            }
            else{
                l.add(i);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(!set.contains(i)){
                if(arr[i]<0){
                    if(arr[i]%2!=0){
                        return false;
                    }
                    l=map.get(arr[i]/2);
                    if(l==null){
                        return false;
                    }
                    set.add(i);
                    set.add(l.getFirst());
                    if(l.size()==1){
                        map.remove(arr[i]/2);
                    }
                    else{
                        l.removeFirst();
                    }
                }
                else{
                    l=map.get(arr[i]*2);
                    if(l==null){
                        return false;
                    }
                    set.add(i);
                    set.add(l.getFirst());
                    if(l.size()==1){
                        map.remove(arr[i]*2);
                    }
                    else{
                        l.removeFirst();
                    }
                }
            }
        }
        return true;
    }
}
