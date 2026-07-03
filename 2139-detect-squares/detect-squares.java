//destination fang

class DetectSquares {

    // Map to store frequency of points
    // x-coordinate -> (y-coordinate -> frequency)
    private Map<Integer, Map<Integer, Integer>> pointsCount;

    public DetectSquares() {
        pointsCount = new HashMap<>();
    }

    // Add a new point
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y, 0) + 1);
    }

    // Count the number of axis-aligned squares
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;

        // If no point has the same x-coordinate
        if (!pointsCount.containsKey(x1)) {
            return 0;
        }

        // Iterate through all y-coordinates having x = x1
        for (Map.Entry<Integer, Integer> entry : pointsCount.get(x1).entrySet()) {

            int y2 = entry.getKey();
            int countY2 = entry.getValue();

            // Side length cannot be 0
            if (y2 == y1) {
                continue;
            }

            int sideLength = Math.abs(y2 - y1);

            // Square on the right
            totalSquares += countSquares(x1 ,y1,x1+sideLength, y1, y2, countY2);

            // Square on the left
            totalSquares += countSquares(x1 ,y1,x1 - sideLength, y1, y2, countY2);
        }

        return totalSquares;
    }

    private int countSquares(int x1,int y1,int x3,int y3,int y2,int countY2){
        if(pointsCount.containsKey(x3)){
            Map<Integer,Integer> x3Points=pointsCount.get(x3);
            return x3Points.getOrDefault(y1,0)*x3Points.getOrDefault(y2,0)*countY2;
        }
        return 0;
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */