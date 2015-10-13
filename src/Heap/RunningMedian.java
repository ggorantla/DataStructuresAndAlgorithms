package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by ggorantla on 10/12/2015.
 *      First Half   ---  Median  ---  Second Half
 *
 *
 *      Priority Queue has a default Comparator which gives out least valued element ( in our case , its good enough for second half
 * 		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20);
        pq.add(4);pq.add(8); pq.add(12);
        System.out.println(pq.peek());
 *
 *
 */
public class RunningMedian {

    PriorityQueue<Integer> lowerQueue ;
    PriorityQueue<Integer> upperQueue;


    public RunningMedian(){
        lowerQueue = new PriorityQueue<Integer>(
                20, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        upperQueue = new PriorityQueue<>();
        upperQueue.add(Integer.MAX_VALUE);
        lowerQueue.add(Integer.MIN_VALUE);
        System.out.println(lowerQueue.peek()); System.out.println(upperQueue.peek());
    }


    public double getMedian(int num){
        //Adding element

        if(num >= upperQueue.peek()) {
            System.out.print(num);
            System.out.print("  :Upper: ");
            System.out.println( upperQueue.peek());
            upperQueue.add(num);

        }else {
            lowerQueue.add(num);
            System.out.print(num);
            System.out.print("  :Lower: ");
            System.out.println( upperQueue.peek());
        }
        // Banlanceing act
        if (upperQueue.size()-lowerQueue.size() ==2)
            lowerQueue.add(upperQueue.poll());
        else if (lowerQueue.size() - upperQueue.size() ==2)
            upperQueue.add(lowerQueue.poll());

        // Median finding
        if (upperQueue.size() == lowerQueue.size())
            return (upperQueue.peek() + lowerQueue.peek())/2.0;
        else if (upperQueue.size() > lowerQueue.size())
            return upperQueue.peek();
        else
            return lowerQueue.peek();
    }


    public static void main(String args[]){
        Random rand = new Random();
        RunningMedian runningMedianObj = new RunningMedian();
        for (int i =0; i < 50; i++){
            int num = rand.nextInt(100);
            //System.out.print(num);
            //System.out.print("\t");
            //System.out.println(runningMedianObj.getMedian(num));
            runningMedianObj.getMedian(num);
        }
    }
}
