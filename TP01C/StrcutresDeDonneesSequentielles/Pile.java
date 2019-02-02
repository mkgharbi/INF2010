package StrcutresDeDonneesSequentielles;


public class Pile<AnyType> {
	
	private class Node {
		AnyType item_ ; 
		Node suivant_; 
		
		public Node(AnyType item) {
			item_= item; 
		}
	}
	//Attributs : 
	private int taille_; 
	private Node head_; 
	
	
	//Methodes : 
	//Constructeur : 
	public Pile() {
		taille_ = 0 ; 
		head_ = null ; 
	}
	
	// Methode verifier si la Pile est vide ou non :  vrai c-a-d elle vide et faux sinon. 
	public boolean estVide() {
		return (taille_ == 0 )	;
	}
	
	//Empiler : 
	public void push(AnyType item) {
		Node nouveauNode = new Node(item); 
		if ( head_ == null ) { 
			head_ = nouveauNode;
		}
		else {
			nouveauNode.suivant_ = head_; 
			head_ = nouveauNode ; 
		}
		taille_++; 
	}
	
	//Depiler 
	public AnyType pop() {
		if (head_ == null) {
			return null ; 			
		}
		else {
			Node noeud = head_ ; 
			head_ = head_.suivant_; 
			taille_--;
			return noeud.item_ ; 
		}
	}
	
	public AnyType peek () {
		if (head_ != null ) 
			return head_.item_ ;
		return null ; 
	}
	
}