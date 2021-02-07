package DataStructure;


import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;

    public MedianFinder() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        lo = new PriorityQueue<>(32, (n1,n2)->n2-n1);
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if (lo.size() < hi.size()) {
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        if (lo.isEmpty()){
            return Double.MIN_VALUE;
        }
        return (lo.size()+hi.size())%2 == 1 ? (double)lo.peek() : (double)(lo.peek()+hi.peek())/2;
    }
}
