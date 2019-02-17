package StrcutresDeDonneesSequentielles;

import java.util.Iterator;


public class Sac<AnyType extends Comparable <AnyType>>
{
	private int size_;
	private Node<AnyType> first_;
	private Node<AnyType> last_;
	
	
    private static class Node<AnyType>{
        private Node<AnyType> next_ = null;
        private Node<AnyType> previous_ = null;
        private AnyType item_;
        
        public Node(){}
        public Node(AnyType item){
        	setItem(item);
        }
        
        //Getters :
        public Node<AnyType> getPrevious(){
        	return previous_;
        }
        
        public Node<AnyType> getNext(){
        	return next_;
        }
        public AnyType getItem(){
        	return item_;
        }
        //Setters : 
        public void setPrevious(Node<AnyType> previous){
        	previous_ = previous;
        }
        public void setNext(Node<AnyType> next){
        	next_ = next;
        }
        public void setItem(AnyType item){
        	item_ = item;
        }
    }
	
	//constructor : 
	public Sac( ) {
		first_ = new Node<AnyType>();
		last_ = new Node<AnyType>() ; 
		first_.setNext(last_);
		last_.setPrevious(first_);
		size_ = 0 ; 
	}

	//getters : 
	public int size( ) {
		return size_;
	}
	public Node<AnyType> getFirst() {
		return first_ ; 
	}
	public Node<AnyType> getLast() {
		return last_ ; 
	}
	
	//Insertion 
    public void push_back(AnyType item){
        Node<AnyType> node = new Node<AnyType>(item);
        size_++;
        node.setNext(getLast());
        node.setPrevious(getLast().getPrevious());
        getLast().getPrevious().setNext(node);
        getLast().setPrevious(node);
    }

    public void push_front(AnyType item){
        Node<AnyType> node = new Node<AnyType>(item);
        size_++;
        if(isEmpty()){
            first_.setNext(node);
            last_.setPrevious(node);
        }
        else {
            node.setPrevious(getFirst());
            node.setNext(getFirst().getNext());
            getFirst().getNext().setPrevious(node);
            getFirst().setNext(node);
        }
    }

    public void insertElementByIndex(int idx, AnyType item){
    	if( idx < 0 || idx > size() )
			throw new IndexOutOfBoundsException();
        size_++;
        Node<AnyType> iterator = getFirst();
        for(int i = 0; i<idx; i++){
            if(iterator.getNext() != null && iterator.getNext() != getLast()){
                iterator = iterator.getNext();
            }
        }
        Node<AnyType> node = new Node<AnyType>(item);
        node.setPrevious(iterator);
        node.setNext(iterator.getNext());
        iterator.setNext(node);
        node.getNext().setPrevious(node);
    }

    //Supprimer : 

    public void removeElementByIndex(int position){
    	if( idx < 0 || idx > size() )
			throw new IndexOutOfBoundsException();
        Node<AnyType> iterator = getFirst().getNext();
        boolean removed = true;
        for(int i = 0; i<position; i++){
            if(iterator.getNext() != null && iterator.getNext() != getLast()){
                iterator = iterator.getNext();
            }
            else {
               removed = false; 
            }
        }
        if(removed){
            iterator.getPrevious().setNext(iterator.getNext());
            iterator.getNext().setPrevious(iterator.getPrevious());
        }
    }

    //Test : 
	public boolean isEmpty( ) {	
		return size() == 0; 
	}
	
	public boolean isHere(AnyType item) {
		Node<AnyType> iterator = getFirst() ; 
		while (iterator.getNext() != null  && iterator.getNext() != getLast() ) {
			iterator = iterator.getNext() ; 
			if (iterator.getItem() == item)
				return true; 
		}
		return false; 
	}

    public AnyType getElementByIndex(int position){
    	if( position < 0 || position > size() )
			throw new IndexOutOfBoundsException();
        Node<AnyType> iterator = getFirst().getNext();
        for(int i = 0; i<position; i++){
            if(iterator.getNext() != null && iterator.getNext() != getLast())
                iterator = iterator.getNext();
        }
        return iterator.getItem();
    }
}


