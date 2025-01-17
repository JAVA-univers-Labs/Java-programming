public class LinkedList
{
	LinkedListNode first = null ;
	LinkedListNode last = null ;
	int nNode = 0 ;
	Object ref = null ;

	public LinkedList()
	{
		first = null ;
		last = null ;
		nNode = 0 ;
	}

	public LinkedList(Object ref) 
	{
		this.ref = ref ; 
	}

	public int length()
	{
		return nNode ;
	}

	public boolean add(Object data)
	{
		if (ref != null) {
			if (data.getClass() != ref.getClass())
				return false ;
		}
		
		if (last == null) {
			first = new LinkedListNode(data) ;
			last = first ;
		}
		else {
			last = last.addNext(data) ;
		}
		nNode += 1 ;

		return true ;
	}

	public Object removeFirst()
	{
		if (first == null)
			return null ;
		return removeFirst(first.getData()) ;
	}

	public Object removeFirst(Object data)
	{
		LinkedListNode prev = null ;
		for (LinkedListNode i = first ; i != null ; i = i.next) {
			if (data.equals(i.getData())) {
				if (i == first) 
					first = i.next ;
				if (i == last) {
					last = prev ;
					i.next = null ;
				}
				if (prev != null) 
					prev.next = i.next ;
				nNode -= 1 ;	
				return i.getData() ;
			}
			prev = i ;
		}
		return null ;
	}

	public void clear()
	{
		first = null ;
		last = null ;
		nNode = 0 ;
	}


	public LinkedListIterator iterator() 
	{
		return new LinkedListIterator(first) ;
	}

	public String toString() 
	{
		String r = "<" ;
		LinkedListIterator i ;
		for (i = iterator() ; i.hasNext() ; ) {
			Object data = i.next() ;
			r = r + data.toString() + (i.hasNext() ? "," : ">") ;
		}
		return r ;
	}
}
