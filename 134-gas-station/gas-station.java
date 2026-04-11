//apna college
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;

        for(int i=0;i<gas.length;i++){
            totalGas=totalGas+gas[i];
        }

        for(int i=0;i<cost.length;i++){
            totalCost=totalCost+cost[i];
        }

        if(totalGas<totalCost){
            return -1;
        }

        //unique solution always exist
        int start=0;
        int curGas=0;

        for(int i=0;i<gas.length;i++){
            curGas=curGas+(gas[i]-cost[i]);
            if(curGas<0){
                start=i+1;
                curGas=0;
            }
        }

        return start;


    }
}