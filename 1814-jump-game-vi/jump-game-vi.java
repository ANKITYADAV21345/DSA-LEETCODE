// coders camp(isse samajha hai ache se baki jitne bhi submited hai confusin g hai but ye sahi hai )
class Solution {
    public int maxResult(int[] nums, int k) {
        //sort on the bases of score
        Queue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);

        //store kar raha hai score aur index initially starting index
        pq.offer(new int[]{nums[0],0});

        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            //if we no longer can reach to a position then we can pop from our queue
            while(pq.peek()[1]<i-k){
                pq.poll();
            }

            //main logic
            //cur top element ko store rakhega 
            int [] cur=pq.peek();
            //calculate karege score 
            max=cur[0]+nums[i];
            //aur fir add kar dege pq
            pq.offer(new int[]{cur[0]+nums[i],i});
        }
        return max;
    }
}