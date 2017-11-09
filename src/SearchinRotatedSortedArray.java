public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        return search(0,nums.length-1,nums,target);
    }
    public int search(int l,int r,int[] nums, int target){
        if(l == r){
            return nums[l]==target?l:-1;
        }
        if(nums[(l+r)/2] == target){
            return (l+r)/2;
        }
        if(nums[l]>nums[(l+r)/2]){
            if(nums[r]>=target&&nums[(l+r)/2]<target){
                l = (l+r)/2 + 1;
            }else{
                r = (l+r)/2 - 1;
            }
        }else{
            if(nums[l]<=target&&nums[(l+r)/2]>target){
                r = (l+r)/2 - 1;
            }else{
                l = (l+r)/2 + 1;
            }
        }
        return search(l,r,nums,target);
    }

    public static void main(String[] args) {
        System.out.println(new SearchinRotatedSortedArray().search(new int[]{1,3,5},1));
    }
}
