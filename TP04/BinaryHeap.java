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
	
	// invoquez buildMinHeap() ou buildMaxHeap() en fonction du parametre min; Il faut construire le tableau dans les 2 cas
	currentSize = items.length;
	array = (AnyType[]) new Comparable[currentSize + 1 ]; //le premier index est à 1.
	int index = 1 ; 
	
	for ( AnyType it : items)
		array[index++] = it ;
	
	if (min) { //Cas minimal 
		buildMinHeap(); 
	}		
	else { //Cas Maximal
		buildMaxHeap();
	}
    }
    
    public boolean offer( AnyType x )
    {
	if (x == null)
	    throw new NullPointerException("Cannot insert null in a BinaryHeap");
	
	if( currentSize + 1 == array.length )
	    doubleArray();
	
	//Percolation vers le haut: 2 cas possibles : minimal ou maximal.
	int hole = ++currentSize;	
	
	//Cas minimal : 
	if (min) {
		for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2)
			array[ hole ] = array[ hole / 2 ];
		array[ hole ] = x;
	}
	//Cas maximal : 
	else {
		for( ; hole > 1 && x.compareTo( array[ hole / 2 ] ) > 0; hole /= 2)
			array[ hole ] = array[ hole / 2 ];
		array[ hole ] = x;
	}
	
	//Incrementer modifications:
	modifications++;
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
		
		AnyType minItem = array[1]; //sauver la valeur de la racine ( qui est la minimale)
	   	array[ 1 ] = array[ currentSize-- ]; // mettre l'avant dernier element a la racine. 
	   	
	   	//Cas minimal : 
	   	if (min) {
	   		percolateDownMinHeap(1,currentSize);
	   		
	   	}
	   	//Cas maximal
	   	else {
	   		percolateDownMaxHeap(1,currentSize);
	   	}

	   	modifications++;
	   	return minItem;
    }
    
    public Iterator<AnyType> iterator()
    {
	return new HeapIterator();
    }
    
    private void buildMinHeap()
    {
    	for(int i=currentSize/2;i >0; i--) 
    		percolateDownMinHeap(i, array.length);     //Construction basee sur percolateDownMinHeap
    }
    
    private void buildMaxHeap()
    {
    	for(int i=currentSize/2;i >0; i--) 
    		percolateDownMaxHeap(i, array.length);    //Construction basee sur percolateDownMaxHeap
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
				    void swapReferences( AnyType[] array, int index1, int index2 )
    {
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
    	if (heapIndexing) {
    		
	    	int child;
	    	AnyType tmp = array[ hole ];
	    	for( ; hole * 2 <= size; hole = child )
	    	{
		    	child = hole * 2; //Considérer fils de gauche
		    	if (child + 1 < size) {
		    		if( child != size && array[ child + 1 ].compareTo( array[ child ] ) < 0 ) // il y a deux fils et fils droit<fils gauche
		    			child++; //Considérer fils droit
		    		if( array[ child ].compareTo( tmp ) < 0 )//fils considéré< élément à percoler
		    			array[ hole ] = array[ child ];//Remonter le fils courrent de un niveau
		    	}
		    	else
		    		break; //L’élément à percoler sera inséré à position hole
		    }
	    	array[ hole ] = tmp;
    	}
    }
    
    /**
     * @param hole    Position a percoler
     * @param size    Indice max du tableau
     */
    private void percolateDownMaxHeap( int hole, int size )
    {
	percolateDownMaxHeap(array, hole, size, true);
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
		if (heapIndexing) {	
			int child;
	    	AnyType tmp = array[ hole ];
	    	for( ; hole * 2 <= size; hole = child )	{
	    		child = hole * 2;
	    		if (child + 1 < size) {
	    			if( child != size - 1 && array[ child + 1 ].compareTo( array[ child ] ) > 0 ) 
	    				child++;
	    		
	    			if( array[ child ].compareTo( tmp ) > 0 )
	    				array[ hole ] = array[ child ];
	    		}
		    	else
		    		break;
			    }
	    	array[ hole ] = tmp;
		} 
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSort( AnyType[] a )
    {
    	for( int i = a.length / 2; i >= 0; i-- ) /* construire le monceau max*/
    		percolateDownMaxHeap( a, i, a.length,true);
    	
    	for( int i = a.length - 1; i > 0; i-- )
    	{
    		swapReferences( a, 0, i ); /* permuter le maximum avec le dernier élément du monceau */
    		percolateDownMaxHeap(a,0,i,true); 
    	} 
    }
    
    public static <AnyType extends Comparable<? super AnyType>>
				   void heapSortReverse( AnyType[] a )
    {
    	for( int i = a.length / 2; i >= 0; i-- ) /* construire le monceau min */
    		percolateDownMinHeap( a, i, a.length,true);
    	
    	for( int i = a.length - 1; i > 0; i-- ) {
    		swapReferences( a, 0, i ); /* permuter le minimum avec le dernier élément du monceau */
    		percolateDownMinHeap(a,0,i,true); 
    	}     
    }
    
    public String nonRecursivePrintFancyTree()
    {
    	int root = 1 ;
    	//Cas de base : 
    	if (array[root] == null)
    		return ("Tableau vide");
    	
    	String outputString = "";
    	
    	Stack<Integer> indexStack = new Stack<Integer>(); 
    	indexStack.push(root);
    	
    	Stack<String> spacing = new Stack<String>() ; 
    	spacing.push(outputString);
    	
    	boolean feuilleANoeud = false; 
    	
    	while (indexStack.isEmpty() != true) {
    		String espace = spacing.peek();
    		root = indexStack.peek(); 
    		
    		//les index sont donc 2*i +1 pour le fils gauche et 2*i+2 pour le fils droit
    		int leftChildIndex = leftChild(root,true); 
    		int rightChildIndex = leftChildIndex + 1 ; 
    		
    		if (feuilleANoeud) {
    			feuilleANoeud = false;
    			spacing.pop();
    		}
    		
    		outputString = outputString + espace + "|__" ; 
    		
    		if (root <= currentSize) {
    			boolean estFeuille = root > (currentSize/2) ;
    			
    			outputString = outputString + array[root] + "\n" ; 
    			
    			indexStack.pop();
    			
    			if ( root % 2 == 0 ) {
    				espace = espace + "| "; 
    				spacing.push(espace);
    			}
    			else {
    				espace = espace + " " ; //laisser l 'espace 
    				spacing.push(espace);
    			}
    			if (estFeuille == false) {
    				indexStack.push(rightChildIndex);
    				indexStack.push(leftChildIndex);
    			}
    			else {
    				spacing.pop();
    				feuilleANoeud = true; 
    			}
    			
    		}
    		else {
    			outputString = outputString + "null \n"; //Vide
    			indexStack.pop();
    		}
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
    	private int expectedCount = modifications;
    	private int iteratorCurrentPosition = 1;
	
	public boolean hasNext() {
	    return iteratorCurrentPosition >= currentSize ? false : true ;
	}

	public Object next() throws NoSuchElementException, 
								ConcurrentModificationException, 
								UnsupportedOperationException {
		if (expectedCount != modifications)
			throw new ConcurrentModificationException("Le manceau est modifie durant l'iteration");
		if(!hasNext())
			throw new NoSuchElementException("Il n'y a plus d'element.");
		else 
			return array[iteratorCurrentPosition++];
	}
	
	public void remove() {
	    throw new UnsupportedOperationException();
	}
    }
}
