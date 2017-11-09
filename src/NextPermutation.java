import java.util.Arrays;
import java.util.Stack;

public class NextPermutation {

    private int k;

    public void nextPermutation(int[] nums) {
        int index1 = -1;
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]>=nums[i+1]){
                continue;
            }else{
                index1 = i;
                break;
            }
        }
        Stack<Integer> stack = new Stack<>();
        if(index1 == -1){
            for (int i = index1+1; i < nums.length; i++) {
                stack.push(nums[i]);
            }
            for (int i = index1+1; i < nums.length; i++) {
                nums[i] = stack.pop();
            }
            return;
        }
        int index2 = index1+1;
        int dif = nums[index2] - nums[index1];
        for (int i = index1+1; i < nums.length; i++) {
            if(nums[i]-nums[index1]>0&&nums[i]-nums[index1]<=dif){
                index2 = i;
                dif = nums[i]-nums[index1];
            }
        }
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;

        for (int i = index1+1; i < nums.length; i++) {
            stack.push(nums[i]);
        }
        for (int i = index1+1; i < nums.length; i++) {
            nums[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        String s =null;
        System.out.println(s);

    }
}
