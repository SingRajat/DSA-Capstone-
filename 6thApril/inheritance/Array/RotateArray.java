package inheritance.Array;
import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {2,7,8,9,12,15};
        int k = 3;
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    private static void rotate(int[] arr, int k) {
        if(k==0)return;
        int n = arr.length;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

    }

    private static void reverse(int[] arr,int i, int j) {
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}