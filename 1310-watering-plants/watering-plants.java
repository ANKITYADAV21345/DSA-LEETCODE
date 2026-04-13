//algorithmic iq
//watering plant 2 se logiical variable alice jo pani bhar raha hai vaha se liya hai
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
         int steps=0;
         int alicewater=capacity;

         for(int i=0;i<plants.length;i++){
            if(plants[i]<=alicewater){
                steps++;
                alicewater=alicewater-plants[i];
            }
            else{
                alicewater=capacity;
                alicewater=alicewater-plants[i];
                steps=steps+(2*i)+1;
            }
         }
         return steps;
    }
}