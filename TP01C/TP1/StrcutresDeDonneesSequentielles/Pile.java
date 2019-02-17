package TP1.StrcutresDeDonneesSequentielles;


public class Pile<AnyType> {
	
	@SuppressWarnings("hiding")
	private class Node<AnyType> {
		private AnyType item_ ; 
		private Node<AnyType> next_; 
		private Node<AnyType> previous_; 
		
		public Node() {
		} 
		public Node(AnyType item) {
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
	//Attributs : 
	private int taille_; 
	private Node<AnyType> first_;
	private Node<AnyType> last_; 
	
	
	//Methodes : 
	//Constructeur : 
	public Pile() {
		taille_ = 0 ;
		last_ = new Node<AnyType>() ; 
		first_ =  new Node<AnyType>() ; 
		first_.setNext(last_);
		last_.setPrevious(first_);
	}
	
	//Getters : 
	public Node <AnyType> getFirst() {
		return first_; 
	}
	public Node <AnyType> getLast () {
		return last_;
	}
	// Methode verifier si la Pile est vide ou non :  vrai c-a-d elle vide et faux sinon. 
	public boolean isEmpty() {
		return (taille_ == 0 )	;
	}
	
	//Empiler : 
	public void push(AnyType item) {
		Node<AnyType> nouveauNode = new Node<AnyType>(item); 
        nouveauNode.setNext(getLast());
        nouveauNode.setPrevious(getLast().getPrevious());
        getLast().getPrevious().setNext(nouveauNode);
        getLast().setPrevious(nouveauNode);
		
		taille_++; 
	}
	
	//Depiler 
	public AnyType pop() {
		AnyType item = getLast().getPrevious().getItem();
	    getLast().setPrevious(getLast().getPrevious().getPrevious());
	    getLast().getPrevious().setNext(getLast());
	    taille_--; 
	    return item;
	}
	
	//Retourner l'item au head : 
	public AnyType peek () {
		if (first_ != null ) 
			return first_.item_ ;
		return null ; 
	}
	
    public Boolean isHere(AnyType item){
        Node<AnyType> iterator = getFirst();
        while(iterator.getNext() != null && iterator.getNext() != getLast()){
            iterator = iterator.getNext();
            if (iterator.getItem() == item){
                return true;
            }
        }
        return false;
    }
	
}