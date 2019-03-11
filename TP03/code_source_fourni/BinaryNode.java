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
    	this.data=null;

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
    		 {
    			right = new BinaryNode<T>(item);
    			
    		 }
    		else 
    		 {
    			right.insert(item);
    		 }
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
        
       boolean found = false;// initialisation de la variable  a false
       if (item.equals(data))
       
    	   return true;
    	  
       //verification de la branche droite
       else if (data.compareTo(item)<0 && right !=null)
    	   found = right.contains(item);
       //verification de la branche gauche
       else if (data.compareTo(item)>0 && left != null)
    	   found = left.contains(item);
        //retour du resultat en boolean
       return found;
       
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        //initialisation des variables de recherches gauche et droite;
    	int rightSide = right.getHeight() +1 ;
    	int leftSide = left.getHeight() +1 ;
    	/*int B=0;
    	if(A != null && B != null)
    	{
    		A++;
    		A=left.getHeight()+A;
    		B++;
    		B=right.getHeight()+B;
 
    	}
    	*/
    	return Math.max(rightSide, leftSide);
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
    	//verification de la liste 
    	if (left != null)
    		{
    		//remplissage de la liste
    		left.fillListInOrder(result);
    		
    		result.add(this);
    		}
    	//ajouter le centre : 
    	
    	//verification de la liste
    	if(right != null)
    		{
    		//remplissage de la liste
    		right.fillListInOrder(result);
    		result.add(this);
    		}
    	return;

    }
}
