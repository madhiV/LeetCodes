class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr=new int[5];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<text.length();i++){
            switch(text.charAt(i)){
                case 'a':
                    arr[1]++;
                    break;
                case 'b':
                    arr[0]++;
                    break;
                case 'l':
                    arr[2]++;
                    break;
                case 'o':
                    arr[3]++;
                    break;
                case 'n':
                    arr[4]++;
                    break;
            }
        }
        arr[2]/=2;
        arr[3]/=2;
        for(int i=0;i<5;i++){
            min=Math.min(arr[i],min);
        }
        return min;
    }
}
