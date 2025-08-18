//apna college
class Solution {
    public int trap(int[] height) {
        //calculate left max boundary in the form of arrey(auxaliary arrey/helper arreys)
        //calculate right max boundary in the form of arrey(auxalary arreys/helper areys)
        //fir loop run karna hai jiko use karke water level nikalna hai 
        //waterlevel=min(left max boundary,right max boundary);
        //trapped water=water level-height[i]

        //calculate left max boundary in the form of arrey(auxaliary arrey/helper arreys)
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        //calculate right max boundary in the form of arrey(auxalary arreys/helper areys)
        int rightmax[] = new int[height.length];
        rightmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(height[i], rightmax[i + 1]);
        }

        //fir loop run karna hai jiko use karke water level nikalna hai
        int trappedwater = 0;
        for (int i = 0; i < height.length; i++) {
            //waterlevel=min(left max boundary,right max boundary)
            int waterlevel = Math.min(rightmax[i], leftmax[i]);
            //trapped water=water level-height[i]
            trappedwater = trappedwater + waterlevel - height[i];
        }

        return trappedwater;
    }

    
}