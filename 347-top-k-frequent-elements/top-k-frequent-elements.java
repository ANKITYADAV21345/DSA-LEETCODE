//codestorywithmik
//Approach-1 (Using min-heap) - TC : O(nlog(n-k))
class Solution {

    static class Pair {
        int freq;
        int num;

        Pair(int f, int n) {
            freq = f;
            num = n;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        // min-heap (based on frequency)
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq
        );

        // count frequency of each element
        // Worst Case - n distinct elements are stored, so, space O(n)
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i : nums) {
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }

        // Push in min-heap and maintain size k
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            pq.add(new Pair(it.getValue(), it.getKey()));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Pick all top K elements
        int[] result = new int[k];
        int idx = 0;

        while (!pq.isEmpty()) {
            result[idx++] = pq.poll().num;
        }

        return result;
    }
}



