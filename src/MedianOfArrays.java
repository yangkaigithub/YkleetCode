import java.util.Arrays;

/**
 * Created by Administrator on 2016/11/19.
 */
public class MedianOfArrays {
    public static void main(String[] args){
        System.out.println(new MedianOfArrays().findMedianSortedArrays(new int[]{1, 2, 3, 6, 7, 9}, new int[]{4, 6, 8, 9, 10, 16, 18}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0,j = 0,k = 0, pt = 0;
        int[] nums3 = new int[(nums1.length+nums2.length)/2+1];
        while( k< nums3.length){
            if(i == nums1.length) nums3[k++] = nums2[j++];
            else if(j == nums2.length) nums3[k++] = nums1[i++];
            else if(nums1[i]>nums2[j]) nums3[k++] = nums2[j++];
            else nums3[k++] = nums1[i++];
        }

        return (nums1.length+nums2.length)/2==(nums1.length+nums2.length-1)/2?nums3[k-1]:(nums3[k-1]/2.0+nums3[k-2]/2.0);

    }
}
