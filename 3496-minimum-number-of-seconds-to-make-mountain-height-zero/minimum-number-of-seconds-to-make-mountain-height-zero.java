//algodaily
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
        //now cheak
        for(int i=0;i<worker.length;i++){
            long j=1L;
            long curr=0;

            while(height>0 && curr +j*worker[i]<=time){
                curr=curr+j*worker[i];
                j++;
                height--;
            }
            //early cheak
            if(height==0){
                return true;
            }
        }
        return false;
    }
}