package kilomanx;
/* 
 * Implementation of LinkedList
 * Operations at the beginning and end of the list are constant time
 */


public class LinkedList {
	public class Node {
		Object value;
		Node next;
		
		public Node(Object o, Node next) {
			this.value = o;
			this.next = next;
		}
		
		public Object getNext() {
			return this.next;
		}

	}
	
	private Node first = null;
	private Node last = null;
	private int size = 0;
	
	public LinkedList() {
	}
		
	//Add at end
	public void add(Object o) {
		Node n = new Node( o, null);
		
		if(last != null) {
			last.next = n;
		} else if(first == null) {
			first = n;
		}
		last = n;
		size++;		
	}
	
	// Add after node
	public void addAfter(Object o, Node n) {
		Node newNode = new Node( o, n.next);
		n.next = newNode;
		if(newNode.next == null) {
			last = newNode;
		}
		size++;
	}
	// public for unit testing
	public Node getNode(int index) {
		Node n = first;
		for(int i = 0; i < index ; i++){
			n = n.next;
		}
		return n;

	}

	public Object get(int index) {
		if( first == null ) {
			return null;
		}
		return getNode(index).value;
	}
	
	
	// first == last, change first, last to -1, remove the node
	// first - change first pointer to next (will be -1 if first == last), remove the node (decrement size)
	// nth - change n-1th pointer to value of nth pointer, remove the node
	// last - change last pointer to n-1th node, change n-1th pointer to -1, remove the node
	public void remove(int index) {
		if(first == null || last == null ) {
			return;
		}
		if( first == last) {
			if(index != 0) {
				return; // actually an error
			} else {
				first = null;
				last = null;
			}
		} else if( index == 0) {
			first = first.next;
		} else {
			Node n = getNode(index - 1);
			Node nextNode = n.next;
			n.next = nextNode.next;
			if( last == nextNode) {
				last = n;
			}
		}
		size--;
	}
	
	public void removeLast() {
		remove(size - 1 );
	}
	
	// unit test routines.
	public Node getLastNode() {
		return last;
	}
	
	public Node getFirstNode() {
		return first;
	}
	public Object getFirst() {
		return first == null ? null : first.value;
	}
	
	public Object getLast() {
		return last == null ? null : last.value;
	}
	
	public int getSize() {
		return size;
	}
}
