/**
 * Created by tpusers on 2017/3/14.
 */
public class MaxGap {
    public int maxgap(int[] nums){
        if(nums.length ==0||nums.length ==1)
            return 0;
        double[] maxaronums = new double[nums.length];
        double[] minaronums = new double[nums.length];
        int max = nums[0];
        int min = nums[0];
        int maxgap = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>max)
                max = nums[i];
            if(nums[i]<min)
                min = nums[i];
        }
        double gaplength = (max-min+0.0)/(nums.length-1);
        for(int i = 0;i<nums.length;i++){
            maxaronums[i] = min + i*gaplength;
            minaronums[i] = min + (i+1)*gaplength;
        }

        for(int i=0;i<nums.length;i++){
            maxaronums[(int)((nums[i]-min)/gaplength)] = nums[i]>maxaronums[(int)((nums[i]-min)/gaplength)] ? nums[i]:maxaronums[(int)((nums[i]-min)/gaplength)];
            minaronums[(int)((nums[i]-min)/gaplength)] = nums[i]<minaronums[(int)((nums[i]-min)/gaplength)] ? nums[i]:minaronums[(int)((nums[i]-min)/gaplength)];
        }
        for(int i=1;i<nums.length;i++) {
            if (maxaronums[i] - gaplength*i-min<0.5)
                maxaronums[i] = maxaronums[i-1];
        }
         for(int i=0;i<nums.length-1;i++){
            maxgap = (minaronums[i+1] - maxaronums[i])>maxgap? (int)((minaronums[i+1] - maxaronums[i])):maxgap;
        }
        return maxgap;
    }
    public static void main(String[] args){
        int[] nums ={1,100};
        System.out.println(new MaxGap().maxgap(nums));

    }
}
