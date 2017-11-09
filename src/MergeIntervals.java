import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {



    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start>o2.start){
                    return 1;
                }else if(o1.start<o2.start) {
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        List<Interval> intervalsresult = new ArrayList<>();
        for (int i = 0; i < intervals.size()-1; i++) {
            if(intervals.get(i).end>intervals.get(i+1).start){
                Interval interval = new Interval(intervals.get(i).start,intervals.get(i).end>intervals.get(i+1).end?intervals.get(i).end:intervals.get(i+1).end);
                intervals.set(i+1,interval);
            }else{
                intervalsresult.add(intervals.get(i));

            }
            if(i == intervals.size()-2){
                intervalsresult.add(intervals.get(i+1));
            }
        }
        return intervalsresult;

    }

    public static void main(String[] args) {
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(new Interval(1,4));
        intervalList.add(new Interval(1,4));
//        intervalList.add(new Interval(7,8));
        new MergeIntervals().merge(intervalList);

    }
}
