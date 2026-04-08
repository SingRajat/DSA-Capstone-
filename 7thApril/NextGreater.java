import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    static int[] nge(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,1,2};
        System.out.println(Arrays.toString(nge(arr)));
    }
}