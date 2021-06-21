class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int round=0;
        //Extract hours and minutes
        int h1,h2,m1,m2;
        h1=Integer.parseInt(startTime.substring(0,2));
        m1=Integer.parseInt(startTime.substring(3,5));
        h2=Integer.parseInt(finishTime.substring(0,2));
        m2=Integer.parseInt(finishTime.substring(3,5));
        if(h1==0){
            h1=24;
        }
        if(h2==0){
            h2=24;
        }
        //start hour < end hour
        if(h1<h2){
            //calculating for startTime
            round+=(h2-h1)*4;
            if(m1>0){
                round--;
            }
            if(m1>15){
                round--;
            }
            if(m1>30){
                round--;
            }
            if(m1>45){
                round--;
            }
            if(m2>=45){
                round+=3;
            }
            else if(m2>=30){
                round+=2;
            }
            else if(m2>=15){
                round++;
            }
            return round;
        }
        //start hour > end hour
        if(h1>h2){
            //calculating for endTime
            round+=((24-h1)+h2)*4;
            if(m1!=0){
                round--;
            }
            if(m1>15){
                round--;
            }
            if(m1>30){
                round--;
            }
            if(m1>45){
                round--;
            }
            //calculating for startTime
            if(m2>=15){
                round++;
            }
            if(m2>=30){
                round++;
            }
            if(m2>=45){
                round++;
            }
            return round;
        }
        //Other cases where start hour == end hour
        if(m1<m2){
            if(m1==0 && m2>=15){
                round++;
            }
            if(m1<=15 && m2>=30){
                round++;
            }
            if(m1<=30 && m2>=45){
                round++;
            }
        }
        else{
            round+=23*4;
            if(m1<=15){
                round+=3;
            }
            else if(m1<=30){
                round+=2;
            }
            else if(m1<=45){
                round++;
            }
            if(m2>=15){
                round++;
            }
            if(m2>=30){
               round++;
            }
            if(m2>=45){
                round++;
             }
        }
        return round;
    }
}
