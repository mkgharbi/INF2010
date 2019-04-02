import java.util.*; 

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> extends AbstractQueue<AnyType>
{
    private static final int DEFAULT_CAPACITY = 100;
    private int currentSize;      // Nombre d'elements
    private AnyType [ ] array;    // Tableau contenant les donnees (premier element a l'indice 1)
    private boolean min;
    private int modifications;    // Nombre de modifications apportees a ce monceau
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( boolean min )
    {
		this.min = min;
		currentSize = 0;
		array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    @SuppressWarnings("unchecked")
    public BinaryHeap( AnyType[] items, boolean min )
    {
		this.min = min;
		// invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min;
		// Allocation : 
		array = (AnyType[]) new Comparable[items.length + 1];
		//on assigne les elements, a partir de lindex 1
		for (int i = 0; i < items.length; i++) {
			array[i+1] = items[i];
			currentSize++;
		}
		//Si minHeap:
		if (min)
			buildMinHeap();
		//Si MaxHeap: 
		else
			buildMaxHeap();
    }
    
    public boolean offer( AnyType x )
    {
		if (x == null)
		    throw new NullPointerException("Cannot insert null in a BinaryHeap");
		
		if( currentSize + 1 == array.length )
		    doubleArray();		
		//le trou disponible ce trouve a la fin du tableau (pre-incr. car lindex commence a 1)
		int hole = ++currentSize;
		//percolation vers le haut : 
		if (min) {	
			//lelement < parent
			for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2)
				array[hole] = array[hole / 2];	
		}
		else {
			//element > son parent 
			for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) > 0; hole /= 2)
				array[ hole ] = array[ hole / 2 ];
		}
		modifications++; //incrementer modifications. 
		array[hole] = x;
		return true;
    }
    
    public AnyType peek()
    {
    	if(!isEmpty())
    		return array[1];
	
		return null;
    }
    
    public AnyType poll()
    {
    	if (currentSize == 0) 
    		return null;
    	    	
    	AnyType root = array[1];
    	
    	//on remplace la tete par le dernier element
    	array[1] = array[currentSize];
    	currentSize--; //on diminue la taille du tableau
    	
    	//si minHeap
		if (min)
			percolateDownMinHeap(1, currentSize);
		else
		//si maxHeap
			percolateDownMaxHeap(1, currentSize);
		modifications++;
    	return root;
    }
    
    public Iterator<AnyType> iterator()
    {
    	return new HeapIterator();
    }
    
    private void buildMinHeap()
    {
    	for( int i = currentSize / 2; i > 0; i--)
    		percolateDownMinHeap(i, currentSize);	
    }
    
    private void buildMaxHeap()
    {
    	for( int i = currentSize / 2; i > 0; i--)
    		percolateDownMaxHeap(i, currentSize);
    }
    
    public boolean isEmpty()
    {
    	return currentSize == 0;
    }
    
    public int size()
    {
    	return currentSize;
    }
    
    public void clear()
    {
		currentSize = 0;
		modifications = 0;
		array = (AnyType[]) new Comparable[ DEFAULT_CAPACITY + 1];
    }
    
    private static int leftChild( int i, boolean heapIndexing )
    {
    	return ( heapIndexing ? 2*i : 2*i+1 );
    }
    
    private void swapReferences( int index1, int index2 )
    {
    	swapReferences(array, index1, index2);
    }
    
    private static <AnyType extends Comparable<? super AnyType>>
				    void swapReferences( AnyType[] array, int index1, int index2 ) {
		AnyType tmp = array[ index1 ];
		array[ index1 ] = array[ index2 ];
		array[ index2 ] = tmp;
    }
    
    @SuppressWarnings("unchecked")
	private void doubleArray()
    {
		AnyType [ ] newArray;
		
		newArray = (AnyType []) new Comparable[ array.length * 2 ];
		for( int i = 0; i < array.length; i++ )
		    newArray[ i ] = array[ i ];
		array = newArray;
    }
    
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMinHeap( int hole, int size )
    {
    	percolateDownMinHeap(array, hole, size, true);
		modifications++;
    }
    
    /**
     * @param array   Tableau d'element
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>>
				    void percolateDownMinHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
    	
    	int enfant = leftChild(hole, heapIndexing);
    	AnyType valeur = array[hole];
    	
    	for(; leftChild(hole, heapIndexing) <= size ; hole = enfant) {
    		enfant = leftChild(hole, heapIndexing);    		
    		if (enfant != size && array[enfant+1].compareTo(array[enfant]) < 0) 
    			enfant++;
			
    		if (array[enfant].compareTo(valeur) < 0) 
    			array[hole] = array[enfant]; //on remonte le fils 
    		else {
    			break; //sortir 
    		}
    	}
		array[hole] = valeur;  
}

    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size )
    {
	percolateDownMaxHeap(array, hole, size, true);
	modifications++;
    }
    
    /**
     * @param array         Tableau d'element
     * @param hole          Position a percoler
     * @param size          Indice max du tableau
     * @param heapIndexing  True si les elements commencent a l'index 1, false sinon
     */
    private static <AnyType extends Comparable<? super AnyType>> 
				    void percolateDownMaxHeap( AnyType[] array, int hole, int size, boolean heapIndexing )
    {
	//COMPLETEZ
    	int enfant = leftChild(hole, heapIndexing); //index fils de gauche
    	AnyType valeur = array[hole];
    	
    	for(; leftChild(hole, heapIndexing) <= size ; hole = enfant) {
    		enfant = leftChild(hole, heapIndexing);
    		
    		//sil y a 2 fils on choisi celui qui a la plus grande valeure pour percoler (compare avec fils de droite)
    		if (enfant != size && array[enfant+1].compareTo(array[enfant]) > 0) {
    			enfant++;
			}
    		//Comparaison entre l enfant et le parent : 
    		if (array[enfant].compareTo(valeur) > 0) 
    			array[hole] = array[enfant]; 
    		else {
    			break; //rien faire 
    		}
    
    	}
		array[hole] = valeur;  
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
    	int taille = a.length - 1; // a partir de 0
    	int element = 0;	
    	//pour tout les elements dans a :
    	while (element < a.length) {
    		
    		//on construit une max heap
	    	for( int i = taille / 2; i >= 0; i--) 
	    		percolateDownMaxHeap(a, i, taille, false);
	    
	    	swapReferences(a, 0, taille--);
	    	element++;
    	} 		
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
    	int taille = a.length - 1; //a partir de 0 
    	int element = 0;
    	
    	//pour tout les elements dans a : 
    	while (element < a.length) {
    		
    		//on construit une min heap : 
	    	for( int i = taille / 2; i >= 0; i--) 
	    		percolateDownMinHeap(a, i, taille, false);
	    	
	    	swapReferences(a, 0, taille--);
	    	element++;
    	}
    }
    
    public String nonRecursivePrintFancyTree()
    {
    	String outputString = "|";
	
		//COMPLETEZ
		//pour chaque noeud, on affiche le fils de droite 
		int root = 0;
		int index = 1;
		for (; index <= size();  index = leftChild(index,true)) {
			for (int l = 0; l < root; l++)
				outputString += "  |";
			
			outputString +=  "__" + array[index] + "\n";
			root++;
		}
		
		//pour chaque noeud : 
		index /= 2;
		root--;
		for (; index > 1;  index = index/2) {
			for (int l = root; l > 0; l--)
				outputString += "  |";
			
			outputString +=  "__" + array[index+1] + "\n";
			
			//si index+1 a des fils : 
			if ((index+1)*2 < size()) {
				for (int l2 = root + 1; l2 > 0; l2--)
					outputString += "  |";
			
			//on affiche le fils de droite :
				outputString +=  "__" + array[index+1] + "\n";
			
			//on affiche le fils de gauche
				for (int l2 = root + 1; l2 > 0; l2--)
					outputString += "  |";
			
				outputString += "__" + array[index+1] + "\n";
			}
			
			root--;
		}
    
		return outputString;
    }
    
    public String printFancyTree()
    {
    	return printFancyTree(1, "");
    }
    
    private String printFancyTree( int index, String prefix)
    {
		String outputString = "";
		
		outputString = prefix + "|__";
		
		if( index <= currentSize )
		    {
			boolean isLeaf = index > currentSize/2;
			
			outputString += array[ index ] + "\n";
			
			String _prefix = prefix;
			
			if( index%2 == 0 )
			    _prefix += "|  "; // un | et trois espace
			else
			    _prefix += "   " ; // quatre espaces
			
			if( !isLeaf ) {
			    outputString += printFancyTree( 2*index, _prefix);
			    outputString += printFancyTree( 2*index + 1, _prefix);
			}
		    }
		else
		    outputString += "null\n";
		return outputString;
    }
    private class HeapIterator implements Iterator {
    	int oldModifications = modifications;
    	int position = 0;
    	public boolean hasNext() {
	    //Retourner le resultat de la comparaison : position + 1 < currentSize
    		return (position + 1 < currentSize);	
    	}

    	public Object next() throws NoSuchElementException, 
				    ConcurrentModificationException, 
				    UnsupportedOperationException {
    		if (position >= currentSize)
    			throw new NoSuchElementException();
    		if (oldModifications != modifications)
    			throw new ConcurrentModificationException();
    		return array[++position];
    	}	
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }

}
