public class Pair<T>{
		private T first, second;
		
		public Pair() {
			this.first=null;
			this.second=null;
		}
		
		public Pair(T first) {
			this.first=first;
			this.second=null;
		}
		
		public Pair(T first, T second) {
			this.first=first;
			this.second=second;
		}
		
		public void setFirst(T first) {
			this.first=first;
		}
		
		public void setSecond(T second) {
			this.second=second;
		}
		
		public T first() {
			return this.first;
		}
		
		public T second() {
			return this.second;
		}
		
	}
	