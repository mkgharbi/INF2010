package StrcutresDeDonneesSequentielles;


public class File<AnyType> {
	
	//Attributs : 
	private int size_;
	private Node <AnyType> head_;
	private Node<AnyType> first_;
	private Node<AnyType> last_;
	
	//Classe privee Node : 
	@SuppressWarnings("hiding")
	private class Node <AnyType> {
		
		//Attributs  : 
		private AnyType item_;
		private Node<AnyType> next_ ; 
		private Node<AnyType> previous_ ;

		//Constructeurs : 
		public Node() {} 
		
		public Node (AnyType item) {
			item_ = item;
		}
		//Getters : 
		public Node<AnyType> getPrevious(){
			return previous_;
		}
		public Node<AnyType> getNext(){
			return next_;
		}
		public AnyType getItem() {
			return item_;
		}
		
		//Setters : 
		public void setPrevious(Node<AnyType> previous){
			previous_ = previous;
		}
        public void setNext(Node<AnyType> next){
        	next_ = next;
        }
	}
	//Methodes : 
	//Constructeur :
    public File(){
    	
        size_ = 0;
        first_ = new Node <AnyType>(); 
        head_ = new Node<AnyType>() ; 
        last_ = new Node<AnyType>();
        first_.next_ = last_;
        last_.setPrevious(first_);
    }
    
    //Verifier si la File est vide : 
    public boolean isEmpty() {
    	return (size_ == 0);
    }
    
    //Getters : 
    //retourner le debut de la file :  (begin)
    public Node<AnyType> getHead() {
    	return head_;
    }
    //retourner le derniere element de la file : (end) 
    public Node<AnyType> getLast(){
    	return last_;
    }
	public Node<AnyType> getFirst() {
		return first_;
	}
	public void setFirst(Node<AnyType> first) {
		first_ = first;
	}
	
	//push , pop , isHere : 
	//Empiler : 
	public void push(AnyType item){
		Node<AnyType> node = new Node<AnyType>(item);
		node.setNext(getLast());
		node.setPrevious(getLast().getPrevious());
		getLast().getPrevious().setNext(node);
		getLast().setPrevious(node);
		size_++; 
	}

	public AnyType pop(){
		AnyType item = getFirst().getNext().getItem();
	    getFirst().setNext(getFirst().getNext().getNext());
	    size_--; 
	    return item;
	    }
	public AnyType peek() {
		return first_.next_.item_; 
	}

	public Boolean isHere(AnyType item){
		Node<AnyType> iterator = getFirst(); //iterator 
	        while(iterator.getNext() != null && iterator.getNext() != getLast()){
	            iterator = iterator.getNext();
	            if (iterator.getItem() == item){
	                return true;
	            }
	        }
	        return false;
	    }
    
	
}