import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int[] result = new int[2];
        searchRange(result,nums,0,nums.length-1,target);
        return result;
    }

    public void searchRange(int[] result, int[] nums, int l, int r, int target) {
        int mid = (l+r)/2;
        if(nums[mid] == target){
            result[0] = mid;
            result[1] = mid;
            determineRange(result,nums,0,nums.length-1,target);
            return;
        }
        if(l==r){
            result[0] = -1;
            result[1] = -1;
            return;
        }
        if(nums[mid]>target){
            r = mid;
        }else{
            l = mid + 1;
        }
        searchRange(result,nums,l,r,target);
    }


    public void determineRange(int[] result, int[] nums, int l, int r, int target){
        if(l==result[0]&&r==result[1])
            return;
        int mid1 = (l+result[0])/2;
        int mid2 = (r+result[1])/2==nums.length-1?nums.length-1:(r+result[1])/2+1;
        if(nums[mid1] == target){
            result[0] = mid1;

        }else{
            l = mid1 + 1;
        }

        if(nums[mid2] == target){
            result[1] = mid2;
        }else{
            r = mid2 - 1;
        }
        determineRange(result,nums,l,r,target);

    }


    public static void main(String[] args) {
        new SearchforaRange().searchRange(new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},5);
    }
}
