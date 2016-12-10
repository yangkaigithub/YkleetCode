import java.util.*;

/**
 * Created by Administrator on 2016/11/19.
 */
public class TwoSum {
    public static void main(String[] args){
        int []a = {-1,-2,-3,-4,-5};
        int []b = new TwoSum().twosum(a,-8);
        System.out.println(Arrays.toString(b));
    }
    public int[] twosum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]))
                if(map.get(target-nums[i])!=i)
                     return new int[] {i,map.get(target-nums[i])};

        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
