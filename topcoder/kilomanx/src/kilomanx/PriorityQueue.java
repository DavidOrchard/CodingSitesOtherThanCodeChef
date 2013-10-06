package kilomanx;
/*
 * Implemented on LinkedList
 */
public class PriorityQueue {
	
	public class PriorityItem implements Comparable<PriorityItem>{
		int priority;
		Object o;
		
		public PriorityItem(int priority, Object o) {
			this.priority = priority;
			this.o = o;
		}

		@Override
		public int compareTo(PriorityItem item) {
			if(this.priority != item.priority) { 
				return this.priority - item.priority;
			}
			if( o instanceof Number) {
				return(((Number)this.o).intValue() - ((Number)item.o).intValue());
			}
			return 0;
		}
		
		
	}
	private LinkedList l = new LinkedList();
	public PriorityQueue() {
		
	}
	
	public void push(PriorityItem o) {
		LinkedList.Node p = (LinkedList.Node)l.getFirstNode();
		if(p == null) {
			l.add(o);
			return;
		}
		while(p.next != null && ((PriorityItem)p.next.value).compareTo(o) < 0 ) {
			p = p.next;
		}
		l.addAfter(o,  p);
	}
	
	// remove from front of linked list
	public PriorityItem pop() {
		
		PriorityItem o = (PriorityItem)l.getFirst();
		l.remove(0);
		return o;
	}
	
	public boolean empty() {
		return l.getFirst() == null;
	}

}
