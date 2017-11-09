import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> resultList = new ArrayList<>();
        if(candidates.length==0){
            return resultList;
        }
        Arrays.sort(candidates);
        combinationSum(0,resultSet,candidates,new LinkedList<Integer>(),target);
        resultList.addAll(resultSet);
        return resultList;
    }
    public void combinationSum(int index,Set<List<Integer>> resultSet,int[] candidates,List<Integer> integerList,int target){
        if(target == 0){
            resultSet.add(new LinkedList<Integer>(integerList));
            return;
        }
        if(index == candidates.length){
            return;
        }
        if(target<candidates[index]){
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            integerList.add(candidates[i]);
            combinationSum(i+1,resultSet,candidates,integerList,target - candidates[i]);
            integerList.remove(integerList.size()-1);
        }

        return;
    }


    public static void main(String[] args) {
        new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }

}
