package cn.yk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yk on 2017/5/4.
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();

        try{
            if(matrix==null||matrix[0]==null){
                return list;
            }
            int j=0;
            int k=0;

            for(int i=0;i<matrix[0].length/2;i++){
                for(j=i;j<matrix.length-i-1;j++){
                    list.add(matrix[i][j]);
                }
                for(k=i;k<matrix[0].length-i-1;k++){
                    list.add(matrix[k][j]);
                }
                while(j>i){
                    list.add(matrix[k][j]);
                    j--;
                }
                for(j=i;k>i;k--) {
                    list.add(matrix[k][j]);
                }
            }
            if(matrix[0].length%2 == 1||matrix.length%2==1){
                if(matrix[0].length>=matrix.length)
                    for(int i=matrix.length/2;i<matrix[0].length-matrix.length+matrix.length/2+1;i++)
                        list.add(matrix[matrix.length/2][i]);
                else
                    for(int i=matrix[0].length/2;i<matrix.length-matrix[0].length+matrix[0].length/2+1;i++)
                        list.add(matrix[i][matrix.length/2]);

                list.add(matrix[matrix[0].length/2][matrix[0].length/2]);
            }
            return list;

        }catch(ArrayIndexOutOfBoundsException aioe){
            return list;
        }
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        String str1 = "aabbcc";
        String str2 = "aabbcc";
        String str4 = new String("aabbcc");
        String str3 = "cc";
        System.out.println(str1==str2);
        System.out.println(str1==str4);
        SpiralOrder so = new SpiralOrder();
        List<Integer> list = so.spiralOrder(matrix);
        List l2 = list;
    }
}
