//coding nation
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n=plants.length;
        int alicewater=capacityA;
        int bobwater=capacityB;
        int start=0;
        int end=n-1;
        int refill=0;
        
        while(start<=end){

            if(start==end){
                if(alicewater>=bobwater){
                    if(alicewater<plants[start]){
                        alicewater=capacityA;
                        refill++;
                    }
                    alicewater=alicewater-plants[start];
                }else{

                    if(bobwater<plants[end]){
                        bobwater=capacityB;
                        refill++;
                    }
                    bobwater=bobwater-plants[end];
                }
            }
            else{
                if(alicewater<plants[start]){
                        alicewater=capacityA;
                        refill++;
                    }
                alicewater=alicewater-plants[start];

                if(bobwater<plants[end]){
                        bobwater=capacityB;
                        refill++;
                    }
                bobwater=bobwater-plants[end];
            }
            start++;
            end--;
        }
        return refill;
    }
}