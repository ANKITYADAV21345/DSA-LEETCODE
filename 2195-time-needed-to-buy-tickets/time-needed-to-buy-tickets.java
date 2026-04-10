//mera logic hai ki queue me dal do and har bar age vale ko last me dal do jab tak k>0 hai
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> queue=new LinkedList<>();
        
        //store larege pair of tickes and index
        for(int i=0;i<tickets.length;i++){
            queue.add(new int[]{tickets[i],i});
        }

        int time=0;
        while(!queue.isEmpty()){
            int [] front=queue.poll();
            //jab ham eek ticket kharid dege 
            front[0]--;
            time++;

            //agar ye banda k hai aur tickent 0 ho gaya to matlab ans mill jayega
            if(front[1]==k && front[0]==0){
                return time;
            }

            //agar tickets abhi baki hai to last me bhejo
            if(front[0]>0){
                queue.add(front);
            }

        }
        return time;

    }
}