
public interface Queue<E> {
	
	public int size();
	
	public boolean isEmpty();
	
	public E front();
	
	public void enqueue(E e);
	
	public E dequeue ();
	
	public void makeEmpty();

}
