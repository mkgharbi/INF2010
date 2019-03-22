import java.util.List;

public class BinaryNode<T extends Comparable<? super T> > {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
    	//initialisation des variables a null
    	this.left=null;
    	this.right=null;
    	this.data=data;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return this.data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
    	if(data.compareTo(item)>0)
    	{
    		if (right== null)
    			right = new BinaryNode<T>(item);
    		else 
    			right.insert(item);
    	}
    	else 
    	{
    		if (left==null)
   			{
   				left=new BinaryNode<T>(item); 
   			}
   			else 
   			{
    			left.insert(item);
    		}
   		}
   	}

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        
       if (item.equals(data))
    	   return true;
       //verification de la branche droite
       else if (data.compareTo(item)<0 && right !=null)
    	   return right.contains(item);
       //verification de la branche gauche
       else if (data.compareTo(item)>0 && left != null)
        //retour du resultat en boolean
    	   return right.contains(item);
       return false;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        //initialisation des variables de recherches gauche et droite;
    	int leftSide = -1 ; 
    	int rightSide = -1 ;
    	
    	if (right != null)
    		rightSide = right.getHeight();
    	
    	if (left != null)
    		leftSide = left.getHeight();
    	
    	return Math.max(rightSide + 1 , leftSide +1 );
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
    	//verification de la liste 
    	if(data == null)
    		return;
    	else {
    	if (left != null)
    		//remplissage de la liste
    		left.fillListInOrder(result);
    		
    	result.add(this);
    		
    	//verification de la liste
    	if(right != null)
    	    //remplissage de la liste
    		right.fillListInOrder(result);	
    	result.add(this);
        }
    }
}
