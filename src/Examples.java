
public class Examples {

//	int sum(int[] arr, int n) { 
//	     if (n<=0) return 0; 
//	     else return sum(arr, n-1) + arr[n-1]; 
//	} 
//	
//	int sum(int[] arr, int low, int sup) { 
//	    if (low > sup) return 0; 
//	    return sum(arr[low], (low+sup)/2) + sum(arr[(low+sup)/2] + 1, sup); 
//	}
	
	public static long fibI(int n) { 
	   if (n == 1 || n == 0) return 1; 
	   else return fibI(n-1) + fibI(n-2); 
	} 
	
	public static Pair<Integer> fibR(int n) {
	   if (n==0 || n==1) return new Pair<Integer>(1, 1); 
	   Pair<Integer> p = fibR(n-1); 
	   return new Pair<Integer>(p.first() + p.second(), p.first());
	}



}
