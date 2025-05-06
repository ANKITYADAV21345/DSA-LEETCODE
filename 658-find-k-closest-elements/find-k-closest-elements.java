class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - 1;
        
        // l=0, r=1, k=2
        while (l + k <= r) {
            if (Math.abs(arr[l]-x) > Math.abs(arr[r]-x)) {
                l++;
            } else {
                r--;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = l; i < l+k; i++) {
            answer.add(arr[i]);
        }
        return answer;


        // // minHeap, put k elements in first, iterate until best solution
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // for (int e : arr) {
        //     if (k > 0) {
        //         minHeap.add(e);
        //         k--;
        //     } else {
        //         if (Math.abs(minHeap.peek()-x) > Math.abs(e-x)) {
        //             minHeap.poll();
        //             minHeap.add(e);
        //         }
        //     }
        // }

        // List<Integer> answer = new ArrayList<>(k);
        // while (!minHeap.isEmpty()) {
        //     answer.add(minHeap.poll());
        // }

        // return answer;
    }
}