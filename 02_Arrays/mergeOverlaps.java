/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        @Override
        public int compareTo(Interval interval)
        {
            if(start == interval.start)
                return 0;
            else if(start > interval.start)
                return 1;
            else
                return -1;
        
        }
}
public class Solution {
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if(intervals != null){
            Collections.sort(intervals);
            boolean check = false;
            int e = Integer.MIN_VALUE;
            int s = Integer.MIN_VALUE;
            //Go through param collection
            for(int i = 0; i < intervals.size() - 1; i++){
                if(!check){
                    if(intervals.get(i + 1).start <= intervals.get(i).end){
                        //Insert new interval in result
                        e = intervals.get(i + 1).end > intervals.get(i).end ? intervals.get(i + 1).end : intervals.get(i).end;
                        s = intervals.get(i).start < intervals.get(i + 1).start ? intervals.get(i).start : intervals.get(i + 1).start;
                        result.add(new Interval(s , e));
                        check = true;
                    }
                    else{
                        //Insert current interval
                        result.add(intervals.get(i));
                    }
                }
                else{
                    if(intervals.get(i + 1).start <= result.get(result.size() - 1).end){
                        //Change Last in result to new end
                        e = intervals.get(i + 1).end > result.get(result.size() - 1).end ? intervals.get(i + 1).end : result.get(result.size() - 1).end; 
                        s = result.get(result.size() - 1).start < intervals.get(i + 1).start ? result.get(result.size() - 1).start : intervals.get(i + 1).start;
                        result.get(result.size() - 1).end = e;
                        result.get(result.size() - 1).start = s;
                    }
                    else{
                        check = false;
                    }
                }
            }   
            //Last interval not inserted
            if(!check)
                result.add(intervals.get(intervals.size() - 1));
        }
        return result;
    }
}