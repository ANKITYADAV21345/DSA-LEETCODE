// nums1={1,2,3,0,0,0}
// m=3
// i=m-1
// i ko 3 se start karege  at index 2
// k ko 0 se start karege at index 5
// k=total length (m+n)-1
// nums2={2,5,6}
// j ko 6 se start karege at index 2
// n=3
// j=n-1
// nums1={1,2,2,3,5,6}->sorted
// 3>6->{1,2,3,0,0,6}
// 3>5->{1,2,3,0,5,6}
// 3>2->{1,2,3,3,5,6}
// 2>2->{1,2,2,3,5,6}
// break the loop


// logic in code form
// if(nums1[i]>nums2[j]){
//     nums1[k]=nums1[i]
//     k--;
//     i--;
// }
// else{
//     nums1[k]=nums2[i]
//     k--;
//     j--
// }



import java.util.*;
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //take 3 pinters
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        //cheaking condition
        while (j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }
            else{
                nums1[k]=nums2[j];
                k--;
                j--;
            }
        }
        
    }


  public static void main(String[] args){
    Solution solution = new Solution();
    int nums1[]={1,2,3,0,0,0};
    int nums2[]={2,3,5};
    int m=3;
    int n=3;
    solution.merge(nums1,m,nums2,n);
    for(int i=0;i<m+n;i++){
        System.out.println(nums1[i]+" ");
    }
  }  
}