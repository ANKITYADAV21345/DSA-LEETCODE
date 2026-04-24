//apna college article 
//bruteforce
class Solution {
  public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
          return intervals;
      }




      List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
      boolean mergedSomething = true; // Flag to check if merging happened




      while (mergedSomething) {
          mergedSomething = false;
          List<int[]> tempList = new ArrayList<>();
        
          while (!intervalList.isEmpty()) {
              int[] current = intervalList.remove(0);
              boolean isMerged = false;




              for (int i = 0; i < intervalList.size(); i++) {
                  int[] other = intervalList.get(i);




                  // Check if intervals overlap
                  if (Math.max(current[0], other[0]) <= Math.min(current[1], other[1])) {
                      // Merge the intervals
                      current = new int[]{Math.min(current[0], other[0]), Math.max(current[1], other[1])};
                      intervalList.remove(i); // Remove the merged interval
                      isMerged = true;
                      mergedSomething = true;
                      break; // Restart merging process
                  }
              }
              tempList.add(current);
          }
          intervalList = tempList; // Update list with merged intervals
      }




      return intervalList.toArray(new int[intervalList.size()][]);
  }
}