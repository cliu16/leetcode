/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        Collections.sort(intervals, new Comparator<Interval>(){
                public int compare(Interval a, Interval b){
                    if(a.start == b.start){
                        return a.end - b.end;
                    }

                    return a.start - b.start;
                }
            });

        for(int i = 0; i < intervals.size() - 1; i++){
            Interval cur = intervals.get(i);
            Interval next = intervals.get(i + 1);

            if(cur.end >= next.start){
                cur.end = Math.max(cur.end, next.end);
                intervals.remove(i + 1);
                i--;
            }
        }

        return intervals;
    }
}
