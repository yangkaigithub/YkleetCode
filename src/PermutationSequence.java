import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        int[] ans= new int[n];
        List<Integer> integers = new LinkedList<>();
        String str = "";
        for (int i = 0; i < n; i++) {
            integers.add(i,i+1);
        }
        int a = 1;
        int b=0;
        int c=0;
        for (int i = 2; i < n; i++) {
            a *= i;
        }
        k = k-1;
        for (int i = 0; i < n-1; i++) {
            b = k/a;
            c = k%a;
            str += integers.remove(b);
            k = c;
            a = a/(n-i-1);

        }
        str += integers.remove(0);

        return str;


    }

    public static void main(String[] args) {
        new PermutationSequence().getPermutation(3,2);
    }

}
