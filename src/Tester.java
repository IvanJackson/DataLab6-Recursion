
public class Tester {

	/**
	 * @param args
	 */
	public static <T> void main(String[] args) {	
		listTester("Testing the singly linked list (SLList): ",
				new SLLSimpleList<Integer>());	
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


	}
		
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
