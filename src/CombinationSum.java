import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> resultList = new ArrayList<>();
        if(candidates.length==0){
            return resultList;
        }
        Arrays.sort(candidates);
        combinationSum(0,resultList,candidates,new LinkedList<Integer>(),target);
        return resultList;
    }
    public void combinationSum(int index,List<List<Integer>> resultList,int[] candidates,List<Integer> integerList,int target){
        if(target == 0){
            resultList.add(new LinkedList<Integer>(integerList));

            index++;
            return;
        }
        if(target<candidates[index]){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            integerList.add(candidates[i]);
            combinationSum(i,resultList,candidates,integerList,target - candidates[i]);
            integerList.remove(integerList.size()-1);
        }

        return;
    }


    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2,3,4,7},7);
    }

}
