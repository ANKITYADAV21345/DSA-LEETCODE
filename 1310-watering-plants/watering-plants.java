class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps=0;
        int cap=capacity;

        for(int i=0;i<plants.length;i++){
            if(plants[i]<=cap){
                //walking a step to water the plant
                steps++;
                //reducing jar capacity after watering the plant
                cap=cap-plants[i];

            }
            else{
                //walking to river to re-fill the jar and coming back to the plant
                //this takes (2*i)+1 steps
                cap= capacity;

                //reducing jar capacity after watering the plant 
                cap=cap-plants[i];
                steps=steps+(2*i)+1;
            }
        }
        return steps;
    }
}