import java.util.ArrayList;

public class SLLSimpleList<T> {
		public static class Node<T>{
		
		private T element;
		private Node<T> next;
		
		public Node(){
			this.element = null;
			this.next = null;
		}
		
		public Node(T e, Node<T> N) {
			this.element = e;
			this.next = N;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
	
	
	private Node<T> header;
	private Node<T> current;
	private int size;
	

	public SLLSimpleList() {
		this.header = null;
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public T first() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			return this.header.getElement();
		}

	}

	public T last() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			current = header;
			while(current.getNext()!=null) {
				current = current.getNext();
			}
			return current.getElement();
		}
	}

	public void addFirst(T e) {
		if (this.isEmpty()) {
			Node<T> newNode = new Node<T>(e, null);
			this.header = newNode;
			this.size++;
		}
		else {
			Node<T> newNode = new Node<T>(e, null);
			newNode.setNext(this.header);
			this.header = newNode;
			this.size++;
		}
	}

	public Node<T> findNode(int index) throws IndexOutOfBoundsException{
		if(index<0||index>this.size()) throw new IndexOutOfBoundsException("Index is not valid");
		int counter =0;
		current = header;
		while(counter!=index) {
			current = current.getNext();
			counter++;
		}
		return current;
	}

//	public void addLast(T e) {
//		if (this.isEmpty()) {
//			Node<T> newNode = new Node<T>(e, null);
//			this.header = newNode;
//			this.size++;
//		}
//		else {
//			Node<T> newNode = new Node<T>(e, null);
//			this.tail.setNext(newNode);
//			this.tail = newNode;
//			this.size++;
//		}
//	}

	public T removeFirst() {
		if (this.isEmpty()) {
			return null;
		}
		else {
			T result = this.header.getElement();
			Node<T> temp = this.header;
			this.header = this.header.getNext();
			temp.setElement(null);
			temp.setNext(null);
			this.size--;
			return result;
		}
	}

//	public T removeLast() {
//		if (this.isEmpty()) {
//			return null;
//		}
//		else {
//			if (this.size() == 1) {
//				T result = this.header.getElement();
//				this.header.setElement(null);
//				this.header = this.tail = null;
//				this.size--;
//				return result;
//			}
//			else {
//				Node<T> temp = this.header;
//				while(temp.getNext() != this.tail) {
//					temp = temp.getNext();
//				}
//				Node<T> target = temp.getNext();
//				T result = target.getElement();
//				temp.setNext(null);
//				this.tail = temp;
//				target.setElement(null);
//				this.size--;
//				return result;
//			}
//		}
//	}
//	
	
	public String toString() { 
       String s = ""; 
       Node<T> current = header; 
       while (current != null) { 
          s += " " + current.getElement(); 
          current = current.getNext(); 
         }
         return s; 
	}

	
	public void reverseI() { 
	    if (size > 1) {   
	       Node<T> c = header, a = header.getNext(), b = null; 
	       while (a != null) { 
	              c.setNext(b);
	              b = c; 
	              c = a; 
	              a = a.getNext(); 
	       } 
	       c.setNext(b);
	       header = c; 
	    }
	}
	
	public void reverseR() { 
	   if (size > 1)  
	     header=recReverse(null, header); 
	}
	
	private Node<T> recReverse(Node<T> b, Node<T> c) { 
       if  (c==null) return b;
       Node<T> a=c.getNext(); 
       c.setNext(b);
       return recReverse(c, a);
	}
	
	public void reverse() { 
	   if (size > 1) header = (Node<T>) recReverse(header).first(); 
	} 
	
	private Pair<Node<T>> recReverse(Node<T> node){
		if(node.getNext()==null) return new Pair<Node<T>>(node, null);
		else {
			Pair<Node<T>> pair = new Pair<Node<T>>(recReverse(node.getNext()).first(), null);
			node.getNext().setNext(node);
			return pair = new Pair<Node<T>>(pair.first(), node);
		}
	}
	
	public ArrayList<T> lessThan(T e) { 
	   ArrayList<T> result = new ArrayList<>();     // and empty ArrayList object
	   if (size > 0) 
	      recLessThan(header, e, result);   // passing only reference to result
	   return result; 
	}


	@SuppressWarnings("unchecked")
	private void recLessThan(Node<T> header, T e, ArrayList<T> result) { 
	   if (header != null) { 
	      if (((Comparable<T>) header.getElement()).compareTo(e) < 0)
	         result.add(header.getElement()); 
	      recLessThan(header.getNext(), e, result);  // passing reference to result
	   }
	}
	
	public ArrayList<Pair<T>> consecutiveIncreasingPairs() { 
		   ArrayList<Pair<T>> result = new ArrayList<>();     // and empty ArrayList object
		   if (size > 0) 
		      recCIP(header, result); 
		   return result; 
		}

	private void recCIP(Node<T> header, ArrayList<Pair<T>> result) {
		if(header!=null && header.getNext()!=null) {
			if (((Comparable<T>) header.getElement()).compareTo(header.getNext().getElement()) < 0) {
				result.add(new Pair<T>(header.getElement(), header.getNext().getElement()));
			}
			recCIP(header.getNext(),result);
		}
		
	}



	



}
