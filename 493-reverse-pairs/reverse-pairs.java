import java.util.*;

class Solution { 
    public int cnt;

        public void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if ((long) arr[i] > 2L * arr[j]) {
                cnt += (mid - i + 1);
                j++;
            } else {
                i++;
        }
    }

    int[] temp = new int[high - low + 1];
    int left = low, right = mid + 1, k = 0;
    
    while (left <= mid && right <= high) {
        if (arr[left] <= arr[right]) {
            temp[k++] = arr[left++];
        } else {
            temp[k++] = arr[right++];
        }
    }
    
    while (left <= mid) {
        temp[k++] = arr[left++];
    }
    
    while (right <= high) {
        temp[k++] = arr[right++];
    }
    
    System.arraycopy(temp, 0, arr, low, temp.length);
}

public void mergeSort(int[] arr, int low, int high) {
    if (low >= high) {
        return;
    }
    int mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
}

public int reversePairs(int[] A) {
    if (A.length == 0) {
        return 0;
    }
    cnt = 0;
    mergeSort(A, 0, A.length - 1);
    return cnt;
}

}