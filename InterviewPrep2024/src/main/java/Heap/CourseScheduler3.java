package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduler3 {
	
	/*
	 * There are n different online courses numbered from 1 to n. 
	 * You are given an array courses where courses[i] = [durationi, lastDayi] 
	 * indicate that the ith course should be taken continuously for durationi days and must be finished
	 *  before or on lastDayi.

You will start on the 1st day and you cannot take two or more courses simultaneously.
Return the maximum number of courses that you can take.
	 */

	public static int scheduleCourse(int[][] courses) {
		var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		//Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        Arrays.sort(courses, (a,b) -> a[1] - b[1]);


		for (int i = 0, total = 0; i < courses.length; i++) {
			maxHeap.add(courses[i][0]);
			if ((total += courses[i][0]) > courses[i][1])
				total -= maxHeap.poll();
		}
		return maxHeap.size();
	}
	
	 public int scheduleCourse2(int[][] C) {
	        Arrays.sort(C, (a,b) -> a[1] - b[1]);
	        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
	        int total = 0;
	        for (int[] course : C) {
	            int dur = course[0], end = course[1];
	            if (dur + total <= end) {
	                total += dur;
	                pq.add(dur);
	            } else if (pq.size() > 0 && pq.peek() > dur) {
	                total += dur - pq.poll();
	                pq.add(dur);
	            }
	        }
	        return pq.size();
	    }
	 
	public static void main(String args[]) {
	
	int arr[][]= {{100,200},{200,1300},{1000,1250},{2000,3200}};
	
	System.out.println(scheduleCourse(arr));
	}
}
