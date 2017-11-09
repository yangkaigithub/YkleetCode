import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        Map<String,Integer> map = new HashMap<>();
        int ans = dfs(map,0,0,m-1,n-1);
        return ans;
    }

    public int dfs(Map<String,Integer> map,int posy,int posx,int m,int n){

        if(posy == m||posx==n){
            return 1;
        }
        if(map.containsKey(posy+","+posx)){
            return map.get(posy+","+posx);
        }
        int ans = dfs(map,posy+1,posx,m,n) + dfs(map,posy,posx+1,m,n);
        map.put(posy+","+posx,ans);
        return ans;

    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(4,4);
    }
}
