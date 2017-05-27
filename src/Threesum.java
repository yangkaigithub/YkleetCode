import java.util.*;

/**
 * Created by yk on 2017/5/26.
 */
public class Threesum {
    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int i=0;
        int j;
        int k;
        int sum;
        while(i<nums.length-2){
            if(nums[i]>0){
                return lists;
            }
            j = i+1;
            k = nums.length-1;
            while(j<k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if (sum <= 0) while (nums[j] == nums[++j] && j < k);
                if (sum >= 0) while (nums[k] == nums[--k] && j < k);
            }
            while(nums[++i]==nums[i]&&i<nums.length-2);

        }
        return lists;

    }

    public static void main(String[] args){
        Threesum threesum = new Threesum();
        threesum.solution(new int[] {-1,0,1,2,-1,-4});
        threesum.toString();
    }
}
