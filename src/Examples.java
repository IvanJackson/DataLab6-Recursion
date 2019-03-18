
public class Examples {

	int sum(int[] arr, int n) { 
	     if (n<=0) return 0; 
	     else return sum(arr, n-1) + arr[n-1]; 
	} 
	
	//The below function is broken from the document
//	int sum(int[] arr, int low, int sup) { 
//	    if (low > sup) return 0; 
//	    return sum(arr[low], (low+sup)/2) + sum(arr[(low+sup)/2] + 1, sup); 
//	}
	
	long fib(int n) { 
	   if (n == 1 || n == 0) return 1; 
	   else return fib(n-1) + fib(n-2); 
	} 
	
//	Pair fib(int n) {
//	   if (n==0 || n==1) return (1, 1); 
//	   Pair<Integer> p = fib(n-1); 
//	   return (p.first() + p.second(), p.first());
//	}



}
