package StrcutresDeDonneesSequentielles;

import java.util.Iterator;


public class MyLinkedList<AnyType> implements Iterable<AnyType>
{
	private int theSize;
	private int modCount = 0; // compteur de modifications
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	private static class Node<AnyType>
	{
		public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) { 
			data = d; prev = p; next = n; }
		}
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
	}
	
	public MyLinkedList( ) {
		clear( );
	}
	public int size( ) {
		return theSize;
	}
	public boolean isEmpty( ) {	
		return size() == 0; 
	}
	public boolean add( AnyType x ) {
		add( size(), x ); return true;
	}
	public void add(int idx, AnyType x ) {
		addBefore( getNode( idx ), x ); 
	}
	public AnyType get(int idx ) {
		return getNode( idx ).data;
	} 
	
	public AnyType set(int idx, AnyType newVal) {
		Node<AnyType> p = getNode( idx );
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}

	public void clear() {
		beginMarker = new Node<AnyType>(null, null, null);
		endMarker = new Node<AnyType>(null, beginMarker, null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount++;
	}
	
	private void addBefore(Node<AnyType> p, AnyType x) {
		Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	} 	
	
	private Node<AnyType> getNode(int idx) {
		Node<AnyType> p;
		if( idx < 0 || idx > size() )
			throw new IndexOutOfBoundsException();
		if( idx < size( ) / 2 ) {
			p = beginMarker.next;
			for(int i = 0; i < idx; i++ )
				p = p.next;
		}
		else {
			p = endMarker;
			for(int i = size( ); i > idx; i-- )
				p = p.prev;
		}
		return p;
	}

	private class LinkedListIterator implements java.util.Iterator<AnyType>
	{
		private Node<AnyType> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		public boolean hasNext( )
		{
		return current != endMarker;
		}
		
		public AnyType next() {
			if( modCount != expectedModCount )
				throw new java.util.ConcurrentModificationException();
			if( !hasNext() )
				throw new java.util.NoSuchElementException();
			AnyType nextItem = current.data;
			current = current.next;
			return nextItem;
		}

		}
}