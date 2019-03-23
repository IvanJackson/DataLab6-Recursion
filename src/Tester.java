import java.util.ArrayList;

public class Tester {

	/**
	 * @param args
	 */
	public static <T> void main(String[] args) {	
//		listTester("Testing the singly linked list (SLList): ",
//				new SLLSimpleList<Integer>());	
//		listTester2(new SLLSimpleList<Integer>());
		ArrayQueue<Integer> queue = (ArrayQueue<Integer>) fillQueue(new ArrayQueue<Integer>());
		ArrayQueue<Integer> queue2 = (ArrayQueue<Integer>) fillQueue(new ArrayQueue<Integer>());
		queue = (ArrayQueue<Integer>) fillQueue2(queue);
		queue2 = (ArrayQueue<Integer>) fillQueue2(queue2);
		showQueue(queue);
		sort(queue2);
		showQueue(queue2);
//		long start1 = System.nanoTime();
//		System.out.println(Examples.fibI(30));
//		long end1 = System.nanoTime();
//		long duration1=end1-start1;
//		System.out.println("The iterative Fibonacci sequence took: "+(duration1/1000000000)+" seconds. ");
//		long start2 = System.nanoTime();
//		Pair<Integer> pair = Examples.fibR(30);
//		long end2 = System.nanoTime();
//		System.out.println("("+pair.first()+","+pair.second()+")");
//		long duration2=end2-start2;
//		System.out.println("The iterative Fibonacci sequence took: "+(duration2/1000000000)+" seconds. ");
	}
	

	private static void showQueue(ArrayQueue<Integer> queue) {
		System.out.println("\n*** The "+ queue.size()+ " elements in the list are: "); 
		int lpindex = queue.size(); 
		for (int i=0; i< lpindex; i++)
		    showQueueElement(queue); 
	}
		
	private static void showQueueElement(ArrayQueue<Integer> queue) {
		System.out.println((queue.dequeue()));
		
	}


	private static Queue<Integer> fillQueue(Queue<Integer> queue) {
		for(int i=0;i<5;i++) queue.enqueue(i);
		return queue;
	}
	private static Queue<Integer> fillQueue2(Queue<Integer> queue) {
		for(int i=5;i>0;i--) queue.enqueue(i);
		return queue;
	}
	
	

	private static void sort(Queue<Integer> q) {    // sorts the elements in q in non-decreasing order
		   if (q.size() > 1) {     // if size is <= 1, then nothing needs to be done
		      Queue<Integer> q1, q2; 
		      // Initialize q1 and q2 to empty instances of  ArrayQueue as implemented in previous lab.
		      q1 = new ArrayQueue<Integer>(); 
		      q2 = new ArrayQueue<Integer>(); 

		      // split the elements of q in two halves (or close to), first half into q1 and second half into q2
		      int n = q.size(); 
		      for (int i=0; i<n/2; i++) 
		          q1.enqueue(q.dequeue());
		      while (!q.isEmpty())
		          q2.enqueue(q.dequeue()); 

		      sort(q1);    // recursively sort q1
		      sort(q2);    // recursively sort q2

		      // What is left to do now is the merging operation. Given that q1 and q2 are each sorted, 
		      // efficiently combine is elements back into q so that they are placed in order from first to last. 
		      // This process efficiently exploits the property that both, q1 and q2, are sorted.
		      while (!q1.isEmpty() && !q2.isEmpty())
		          if (((Comparable<Integer>) q1.front()).compareTo(q2.front()) <= 0)
		             q.enqueue(q1.dequeue()); 
		          else 
		             q.enqueue(q2.dequeue()); 
		      // At this moment, one of the two queues, either q1 or q2, is empty.
		      Queue<Integer> r = (!q1.isEmpty() ? q1 : q2);  // find which, q1 or q2, is not empty yet
		      while (!r.isEmpty())
		          q.enqueue(r.dequeue()); 
		     } 
		}

	
	private static <T> void listTester(String msg, SLLSimpleList<Integer>  list) { 
		System.out.println(msg);

		try { 
			list.addFirst(400); 
		} 
		catch (Exception e) { 
			System.out.println(e); 
		}
		showListAfterAdding(list, 435); 
		showListAfterAdding(list, 200); 
		list.addFirst(435); 
	    list.addFirst(200); 
		
		for (int i=20, j=1; i< 50; i+=5, j++) { 
			list.addFirst(i); 
		}
		
		showList(list); 
		list.reverse();
		showList(list);
		
		System.out.println(list.lessThan(500));
	}
	
	private static <T> void listTester2(SLLSimpleList<Integer> list) {
		for (int i=0; i< 5; i++) { 
			list.addFirst(i); 
		}
		showList(list);
		System.out.println(list.lessThan(2));
		System.out.println(list.consecutiveIncreasingPairs());
		
		for (int i=5; i> 0; i--) { 
			list.addFirst(i); 
		}
		showList(list);
		ArrayList<Pair<Integer>> arr =list.consecutiveIncreasingPairs();
		for(int i =0;i<arr.size();i++) {
			System.out.println("("+arr.get(i).first()+","+arr.get(i).second()+")");
		}
	}
	
//	private static <T> void listTester3()
		
	private static void showElement(SLLSimpleList<Integer> list, int position) { 
		try { 
			System.out.println(" --Element in position " 
					+ position + " is: "+ list.findNode(position).getElement()); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	private static void showSize(SLLSimpleList<Integer> list) { 
		System.out.println("\nSize of the list is: "+list.size()); 		
	}
	
	private static void showList(SLLSimpleList<Integer> list) { 
		System.out.println("\n*** The "+ list.size()+ " elements in the list are: "); 
		int lpindex = list.size(); 
		for (int i=0; i< lpindex; i++)
		    showElement(list,i); 
	}
	
	private static void showListAfterDeleting(SLLSimpleList<Integer> list) { 
		System.out.println("\n -- deleting first element"); 
		try { 
			Integer etr = list.removeFirst(); 
			System.out.println(" -- value of deleted element was "+ etr);
			showList(list); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	
	
	private static void showListAfterAdding(SLLSimpleList<Integer> list, Integer element) { 
		System.out.println("\n -- adding value " + element); 
		try { 
			list.addFirst(element);  
			showList(list); 
		}
		catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
//	private static void showListAfterReplacing(SLLSimpleList<Integer> list, int pos, Integer element) { 
//		System.out.println("\n -- replacing value at position "+pos+" by "+element); 
//		try { 
//			Integer etr = list.se(pos, element);  
//			System.out.println(" -- value of replaced element was "+ etr);
//			showList(list); 
//		}
//		catch (Exception e) { 
//			System.out.println(e); 
//		}
//	}
	
}
