package Solutions;

import java.util.PriorityQueue;

class Interval {
    int start = 0;
    int end = 0;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * 寻找下一个最小区间
 */
class NextInterval {


    public static int[] findNextInterval(Interval[] intervals) {
        int n = intervals.length;
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1,i2)-> intervals[i2].start - intervals[i1].start);
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
        int[] result = new int[intervals.length];
        for (int i=0;i < intervals.length;i++){
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }
        for (int i =0 ;i<intervals.length;i++){
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1;
            if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                int topStart = maxStartHeap.poll();
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end){
                     topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }
}
