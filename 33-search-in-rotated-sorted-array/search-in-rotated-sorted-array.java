
    //O(log n)  matlab hame binary search use karna hai (optimised aproach)
    //ham sabse pehle dekhege kis element ke bad hamara array rotate hua hai(pivot index element)
    //[4,5,6,7,0,1,2] binary search ko use karke ham2 ya 0 nikalege 
    //start(index)=0  ->   end(index)=6      mid=(start+end)/2
    //start=0    ->     end=6         mid=3
    //pivot pont se pehle vaha element hi usse bada hai in arangement
    //while(start<end){
    //condition 1->      arr([mid]<arr[mid-1]){               hamara pivor point mid pe hi mill gaya 
    //                       return mid;
    //                   }
    //condition 2 ->     if(arr[start]<arr[mid] && arr[mid]<arr[end]){   ham pivot ke left me hai
    //                        start=mid+1;
    //                        }
    //condition3->      else{                                     ham pivot ke right me hai
    //                          end=mid-1;
    //                      } 
    //}

    //agar hamari target value start of 0 se badi hai to left me exist karegi 
    //avar vo start value se shoti hai to pivoit to end index  ke bich me mill jayega target

public class Solution {

    // Function to perform binary search on rotated sorted array
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid; // Element found
            }

            if (nums[start] <= nums[mid]) {
                // Left half is sorted
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1; // Search in the left half
                } else {
                    start = mid + 1; // Search in the right half
                }
            } else {
                // Right half is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1; // Search in the right half
                } else {
                    end = mid - 1; // Search in the left half
                }
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target)); // Output: 4
    }
}


   