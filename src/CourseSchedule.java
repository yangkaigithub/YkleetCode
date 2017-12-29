import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] ads = new Set[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ads[i] = new HashSet<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            ads[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        boolean[] flags = new boolean[numCourses];
        Set<Integer> courseSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            for(Integer n:ads[i]){
                courseSet.add(i);
                if(!help(courseSet,n,ads,numCourses,flags)){
                    return false;
                }
                courseSet.remove(i);

            }
        }
        return true;
    }
    public boolean help(Set<Integer> courseSet,int courseNo,Set<Integer>[] ads,int numCourses,boolean[] flags){
        if(flags[courseNo] == true){
                return true;
            }
        for(Integer n:courseSet){
            if(ads[courseNo].contains(n)){
                return false;
            }
        }
        boolean flag = true;
        for(Integer n:ads[courseNo]) {
            courseSet.add(n);
            flag &= help(courseSet, n, ads, numCourses,flags);
            courseSet.remove(n);
            flags[n] = flag;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] p = new int[2][];
        p[0] = new int[]{1,0};
        p[1] = new int[]{2,1};

        System.out.println(new CourseSchedule().canFinish(3,p));
    }
}
