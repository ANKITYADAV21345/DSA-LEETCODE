//apna college next permutation code ko thoda tweek kiya bass
//vaha array me diya tha yaha in n diya hai 
class Solution {
    public static int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();

        // Step 1: find idx1
        int idx1 = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx1 = i;
                break;
            }
        }

        if (idx1 == -1) return -1;

        // Step 2: find idx2
        int idx2 = -1;
        for (int i = arr.length - 1; i > idx1; i--) {
            if (arr[i] > arr[idx1]) {
                idx2 = i;
                break;
            }
        }

        // Step 3: swap
        swap(arr, idx1, idx2);

        // Step 4: reverse
        reverse(arr, idx1 + 1, arr.length - 1);

        // Step 5: convert to number
        long ans = Long.parseLong(new String(arr));

        if (ans > Integer.MAX_VALUE) return -1;

        return (int) ans;
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int n = 12443322;
        System.out.println(nextGreaterElement(n));
    }
}