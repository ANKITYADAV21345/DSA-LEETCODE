//code shash

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drank=numBottles;

        //log(numBottle) to the base of numExchanged
        while(numBottles>=numExchange){
            int exchanged=numBottles/numExchange;
            int extraEmpty=numBottles%numExchange;
            drank=drank+exchanged;
            numBottles=exchanged+extraEmpty;
        }
        return drank;
    }
}