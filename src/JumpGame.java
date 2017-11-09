public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length==0){
            return false;
        }
        if (nums.length == 1){
            return true;
        }
        int dp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(dp<i){
                return false;
            }
            if(dp>=nums.length-1){
                return true;
            }
            dp = Math.max(i+nums[i],dp);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
