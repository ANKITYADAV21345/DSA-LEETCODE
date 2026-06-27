// ANURAG CODES (Car Fleet)

class Car {
    int position;
    double timeToTarget;

    Car(int position, double timeToTarget) {
        this.position = position;
        this.timeToTarget = timeToTarget;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = speed.length;

        //eadge case agar empty mill gaya speed and position array
        if(n==0){
            return 0;
        }

        // Step 1: Har car ke liye position aur target tak pahunchne ka time store karo
        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (target - position[i]) * 1.0 / speed[i]);
        }

        // Step 2: Cars ko position ke according sort karo (left -> right)
        Arrays.sort(cars, new Comparator<Car>() {
            public int compare(Car a, Car b) {
                return a.position - b.position;
            }
        });

        int ans = 0;

        // Step 3: Rightmost car se traversal start karo
        // Kyuki target ke sabse paas wali car kisi aur ko join nahi karegi
        for (int i = n - 1; i >= 1; i--) {

            // Agar current car ko target pahunchne me jyada time lag raha hai,
            // to piche wali car ise catch kar legi.
            // Dono ek fleet ban jayengi.
            if (cars[i].timeToTarget >= cars[i - 1].timeToTarget) {
                cars[i - 1] = cars[i];
            }

            // Warna piche wali car current fleet ko catch nahi kar payegi.
            // Current car ek alag fleet hai.
            else {
                ans++;
            }
        }

        // Step 4: Last fleet ko count karne ke liye +1
        return ans + 1;
    }
}