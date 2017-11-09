public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int tmp1=0;
        int tmp2=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
                tmp1 = nums[i];
                tmp2 = nums[nums[i]-1];
                nums[nums[i]-1] = tmp1;
                nums[i] = tmp2;


            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(i+1!=nums[i]){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{2,1}));

    }
}
