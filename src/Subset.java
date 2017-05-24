import java.util.ArrayList;
import java.util.List;

/**
 * Created by yk on 2017/5/24.
 */
public class Subset {
    private List<List<Integer>> lists;


    void getSubset(int[] nums){
        lists = getSubset(new ArrayList<List<Integer>>(),nums,nums.length);
    }
    List<List<Integer>> getSubset(List<List<Integer>>lists, int[] nums,int pos){
        if(pos == 0){
            List<Integer> integers = new ArrayList<>();
            lists.add(integers);
            return lists;
        }
        lists = getSubset(lists, nums, pos-1);

        int num = nums[pos-1];
        int listssize = lists.size();
        for(int i=0;i<listssize;i++){
            List<Integer> integers = new ArrayList<Integer>();
            for(int j=0;j<lists.get(i).size();j++){
                integers.add(lists.get(i).get(j));
            }
            integers.add(num);
            lists.add(integers);
        }
        return lists;
    }

    public static void main(String[] args){
        Subset sb = new Subset();
        sb.getSubset(new int[] {1,2,3,4,5});

        try {
            sb.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
