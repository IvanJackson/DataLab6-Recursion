
	public class ArrayQueue<E> implements Queue<E> {
		private static final int INITCAP = 10; // initial capacity of this queue
		private E[] elements; // array to store references to elements in this queue
		private int first = 0; // elements[first] is the first element in this queue, if not empty
		private int size = 0; // size of the queue
		
		public ArrayQueue() { // creates an initially empty instance of capacity = INITCAP
			elements = (E[]) new Object[INITCAP];
		}
		
		// Number of elements in this queue
		public int size() {
			return this.size;
		}
		
		private void changeCapacity(int newCapacity) { // change capacity to newCapacity
			E[] temp = (E[]) new Object[newCapacity];
			
			for (int i=0; i<size; i++) { // copy (in order) from old array to first size slots of the new array
				int itm = (first + i) % elements.length;
				temp[i] = elements[itm];
				elements[itm] = null;
			}
			
			elements = temp; // the new array now becomes the array of this queue
			first = 0;
			// first element of the queue is now at position 0 of the array; the others follow in order of arrival
		}
			// Adds a new element to the queue (this becomes the new “last” element in it
		public void enqueue(E e) {
			if (size == elements.length) // adjust capacity if needed
			changeCapacity(2*size);
			elements[(first + size) % elements.length] = e; // place in first empty slot after last element
			size++;
		}
		
		public E first() {
			if (isEmpty()) return null;
			return elements[first];
		}
			// Removes the current oldest element in the queue and returns reference to that element.
		public E dequeue() {
			if (isEmpty()) return null;
			E etr = elements[first]; elements[first] = null;
			first = (first + 1) % elements.length;
			size--;
			// adjust capacity if too many empty slots in the array, but never to a value < INITCAP
			if (size <= elements.length/4 && elements.length > INITCAP)
			changeCapacity(elements.length/2); // adjust capacity to 1/2 of current capacity
			return etr;
		}

		@Override
		public boolean isEmpty() {
			return this.size()==0;
		}

		@Override
		public E front() {
			return this.first();
		}

		@Override
		public void makeEmpty() {
			while(!this.isEmpty())this.dequeue();
		}
	}