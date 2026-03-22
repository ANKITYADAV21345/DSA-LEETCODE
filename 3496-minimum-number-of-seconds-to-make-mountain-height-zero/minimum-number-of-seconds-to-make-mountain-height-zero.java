//algodaily   optimised through formula 
//13-03-2026
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long min=1L;
        long max=0;
        long dummy=1L;

        //find max
        for(int element:workerTimes){
            dummy=Math.max(element,dummy);
        }

        //find range
        for(int i=1;i<=mountainHeight;i++){
            max=max+dummy*i;
        }

        //apply binary search 
        while(min<max){

            //find mid
            long mid=(min+max)/2;
            if(isPossible(mid,mountainHeight,workerTimes)){
                max=mid;
            }else{
                min=mid+1;
            }
        }
        return min;
    }

    public boolean isPossible(long time,int height,int [] worker){
        long totalHeight=0;

        for(int element:worker){
            long k=(long)((Math.sqrt(1+(8.0*time)/element)-1)/2);

            totalHeight=totalHeight+k;

            //cheak
            if(totalHeight>=height){
                return true;
            }
        }
        return false;
    }
}