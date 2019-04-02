import java.util.*; 

/*Remarque:
 * En mettant tous les elements dans le main deja ecrits, 
 * on ne pouvait pas afficher le resultats des tests alors qu'ils sont implementes. 
*/
public class Main 
{
   /**
     * Fonction principale
     */
   public static void main(String[] args) 
   {
      // creer un monceau avec 22 elements et un tableau equivalent
      int numItems = 22;
      BinaryHeap<Integer> heap = new BinaryHeap<Integer>(true);
      
      Integer [ ] items = new Integer[ numItems ];

      int i;
      int j;

      // en inserant les elements un a un
      for( i = 11, j = 0; j != numItems; i = ( i + 37 ), j++ )
      {
	  heap.offer( i );
	  items[ j ] = i;

	  i %=  numItems; 
      }

      // en construisant le monceau depuis le depart
      System.out.println("Monceau min construit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(false);
      // en inserant les elements un a un
      for( Integer item : items)
	  heap.offer( item );

      // en construisant le monceau depuis le depart
      System.out.println("Monceau max construit element par element:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,false);
      System.out.println("Monceau max construit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      heap = new BinaryHeap<Integer>(items,true);
      System.out.println("Monceau min construit a partir d'un tableau:");
      System.out.println( heap.printFancyTree() );

      System.out.println();
      System.out.println("Affichage recursif:");
      System.out.println( heap.printFancyTree() );

      System.out.println("Affichage non recursif:");
      System.out.println( heap.nonRecursivePrintFancyTree() );

      System.out.println();
      System.out.println("Tableau d'origine:");
      System.out.println( printArray( items ) );
      
      //A corriger tri 
      BinaryHeap.heapSort( items );
      System.out.println("Tableau ordonne:");
      System.out.println( printArray( items ) );

      BinaryHeap.heapSortReverse( items );
      System.out.println("Tableau inversement ordonne:");
      System.out.println( printArray( items ) );

      

      /*
       * Ajouter appels pour repondre a la question
       **/
      
      //L'implementation des tests est au dessous du main: 
      
      
      System.out.println("\nTests des Heaps min et max:");
      System.out.print("---------------------------------\n");
      	
      testMinHeapPoll(items);
      testMaxHeapPoll(items);
      testMinHeapOffer(items);
      testMaxHeapOffer(items);
		
      // Tests des Exceptions: 
     
      try {testPollWhileIteration(items);}
      catch(Exception e) {System.out.print("Test: poll reussi \n");}
		
      try {testOutOfBondIterator(items);}
      catch(Exception e) {System.out.print("Test: outOfBounds reussi \n");}
		
      try {testIteratorRemove(items);}
      catch(Exception e) {System.out.print("Test Iterator Remove reussi\n");}
		
      try {testOfferWhileIteration(items);}
      catch(Exception e) {System.out.print("Test: iteration reussie \n");}
		
      //Test Sort:
      //Sort normal : 
      testSortArray();
      //Inverse Sort : 
      testReverseSortArray();
      //Fancy Tree : 
      testPrintFancyTree();
   }

   private static <AnyType> 
   String printArray(AnyType[] a)
   {
      String outputString = "";

      for(AnyType item : a)
      {
         outputString += item;
         outputString += ", ";
      }

      return outputString.substring(0,outputString.length()-2);
   }

// Tests 
   
   //Tests Poll : 
   private static void testMinHeapPoll(Integer[] items) {
	   System.out.print("Test: fonction poll() avec minHeap =  ");
	   int valeurMinimale = items[0];
	   
	   for (int i : items) {
		   if (i < valeurMinimale)
			   valeurMinimale = i ; 
	   }
	   BinaryHeap<Integer> resultatTestMinHeap = new BinaryHeap<Integer> (items, true); 
	   
	   int itemMinimale= resultatTestMinHeap.poll(); 
	   
	   if (  itemMinimale == valeurMinimale ) 
		   System.out.print("Test Reussi \n" );
	   else { 
		   System.out.print("Echec : \n\t " + " ValeurMinimale: " + valeurMinimale + " et la valeur trouvee avec poll est  " + itemMinimale + "\n");
	   }   
   }
   
   private static void testMaxHeapPoll(Integer[] items) {
	   System.out.print("Test: fonction poll() avec MaxHeap =  ");
	   int valeurMaximale = -1;
	   for (int i : items) {
		   if (i > valeurMaximale)
			   valeurMaximale  = i ; 
	   }
	   BinaryHeap<Integer> resultatTestHeap = new BinaryHeap<Integer> (items, false); 
	   
	   int itemMaximal= resultatTestHeap.poll(); 
	   
	   if (  itemMaximal == valeurMaximale ) 
		   System.out.print("Test Reussi \n" );
	   else 
		   System.out.print("Echec : \n\t " + " ValeurMaximale: " + valeurMaximale + " et la valeur trouvee avec poll est  " + itemMaximal + "\n");
   }

   	// Tests Offer : 
   
   private static void testMinHeapOffer (Integer[] items) { 
	   System.out.print("Test: fonction offer() avec minHeap \n");
	   int valeurTest  = -1  ; 
	   BinaryHeap<Integer> resultatHeap = new BinaryHeap<Integer>(items,true);
	   resultatHeap.offer(valeurTest);
	   int root = resultatHeap.poll(); // root est la valeur minimale 
	   if (root == valeurTest)
		   System.out.print("Test Reussi \n " );
	   else 
		   System.out.print("Echec : \n\t " + " ValeurMinimale: " + valeurTest + " et la valeur trouvee avec poll est  " + root + "\n");
   }
	

   private static void testMaxHeapOffer (Integer[] items) { 
	   System.out.print("Test: fonction offer() avec maxHeap \n");
	   int valeurTest  = 100  ; 
	   BinaryHeap<Integer> resultatHeap = new BinaryHeap<Integer>(items,false);
	   resultatHeap.offer(valeurTest);
	   int root = resultatHeap.poll();// root est la valeur maximale 
	   if (root == valeurTest)
		   System.out.print("Test Reussi \n" );
	   else 
		   System.out.print("Echec : \n\t " + " Valeuraximale :  " + valeurTest + " et la valeur trouvee avec poll est  " + root + "\n");
   }
   
   //testOutOfBondIterator : 
	private static void testOutOfBondIterator(Integer[] items) {
		System.out.print("Test : fonction  next() avec out of bound iterator = ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true); //Cas minimale 
		
		Iterator<Integer> iterator = testHeap.iterator();
		
		for(int i = 0 ; i <= items.length; i++ )
			iterator.next();
		
		System.out.print("Echec\n");
	}
   //testIteratorRemove : 
   private static void testIteratorRemove(Integer[] items) {
	   System.out.print("Test : fonction remove() avec iterator = ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true); //cas minimale 
		
		Iterator<Integer> iterator = testHeap.iterator();
		iterator.remove();
   }
   
   //testPollWhileIteration : 
   private static void testPollWhileIteration(Integer[] items) {
		System.out.print("Test: fonction  next() et poll() modifications  while iteration = ");
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(items, true); //Cas minimale 
		testHeap.poll();

		Iterator<Integer> iteratorTest = testHeap.iterator();
		iteratorTest.next();
		
		if (iteratorTest.next() == null)
			System.out.print("Echec\n");
		else 
			System.out.print("Reussi \n");
	}
   
   //testOfferWhileIteration : 
   private static void testOfferWhileIteration (Integer[] items) {
	   System.out.print("Test :fonction next() avec offer() modifications while iteration = ");
		BinaryHeap<Integer> heapTest = new BinaryHeap<Integer>(items, true);
		heapTest.offer(1);

		Iterator<Integer> iterator = heapTest.iterator();
		iterator.next();
		if (iterator.next() == null)
			System.out.print("Echec\n");
		else 
			System.out.print("Reussi \n");
   }
   
   
   //testSortedArray : 
   private static void testSortArray() {
		System.out.print("Test :fonction  heapSort() = ");
		// Comparaison entre reponse et itemAttendu element par element .
		Integer [] reponse = new Integer[] {11, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 56, 57, 58}; //Tableau trié
		
		Integer[] itemAttendu = new Integer[] {11, 48, 41, 56, 49, 42, 57, 50, 43, 58, 51, 44, 37, 52, 45, 38, 53, 46, 39, 54, 47, 40};; 
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(itemAttendu, true);
		
		BinaryHeap.heapSort(itemAttendu);
		
		for(int index = 0; index < reponse.length; index++) {
			if(itemAttendu[index] != reponse[index]) { //Condition difference 
				System.out.println("Echec");
				System.out.println("\t" + "erreur dans l'element a l index  : " + index);
				System.out.println("\t" + "Valeur Attendue : " + reponse[index] + " mais la valeur trouvée est  : " + itemAttendu[index]);
				return; //Sortir de la boucle 
			}
		}
		System.out.println("Reussi");
	}
   
   
   //testReverseSortedArray : 
   private static void testReverseSortArray() {
		System.out.print("Test : fonction heapSortReverse() = ");
		// Comparaison entre reponse et itemAttendu element par element .
		Integer [] reponse = new Integer[] {58, 57, 56, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 11}; //Tableau trié à l'inverse
		
		Integer[] itemAttendu = new Integer[] {11, 48, 41, 56, 49, 42, 57, 50, 43, 58, 51, 44, 37, 52, 45, 38, 53, 46, 39, 54, 47, 40};; 
		BinaryHeap<Integer> testHeap = new BinaryHeap<Integer>(itemAttendu, true);
		testHeap.heapSortReverse(itemAttendu);
		
		for(int index = 0; index < reponse.length; index++) {
			if(itemAttendu[index] != reponse[index]) { //Condition difference 
				System.out.println("Echec");
				System.out.println("\t" + "erreur dans l'element a l index  : " + index);
				System.out.println("\t" + "Valeur Attendue : " + reponse[index] + " mais la valeur trouvée est : " + itemAttendu[index]);
				return; //Sortir de la boucle 
			}
		}
		System.out.println("Reussi");
	}
   
   //testPrintFancyTree : 
	private static void testPrintFancyTree() {
		System.out.print("Test : printFancyTree() de minHeap avec element par element  = ");
		BinaryHeap<Integer> heapTest = new BinaryHeap<Integer>(true);
		int numItems = 22; 
		Integer[] items = new Integer[numItems];

		int i;
		int j;

		for (i = 11, j = 0; j != numItems; i = (i + 37), j++) {
			heapTest.offer(i);
			items[j] = i;

			i %= numItems;
		}
		String[] reponse  = new String[] { //Element par element minheap
				"|__11\n" + 
				"   |__38\n" + 
				"   |  |__39\n" + 
				"   |  |  |__48\n" + 
				"   |  |  |  |__56\n" + 
				"   |  |  |  |__53\n" + 
				"   |  |  |__43\n" + 
				"   |  |     |__50\n" + 
				"   |  |     |__46\n" + 
				"   |  |__40\n" + 
				"   |     |__49\n" + 
				"   |     |  |__58\n" + 
				"   |     |  |__54\n" + 
				"   |     |__47\n" + 
				"   |        |__51\n" + 
				"   |        |__null\n" + 
				"   |__37\n" + 
				"      |__41\n" + 
				"      |  |__44\n" + 
				"      |  |__42\n" + 
				"      |__45\n" + 
				"         |__57\n" + 
				"         |__52\n"};
		
		String [] outputString = new String[] {heapTest.printFancyTree()};
		boolean succes = true;
		
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(reponse[0]) != 0) {
				succes = false;
				break;
			}
		}
		
		System.out.println((succes)? "Reussi" : "Echec");
		succes = true;
		System.out.print("Test : printFancyTree() de maxHeap par element par elemenet  = ");
		heapTest = new BinaryHeap<Integer>(false);
		for (Integer item : items)
			heapTest.offer(item);
		reponse = new String[] { 
				"|__58\n" + 
				"   |__57\n" + 
				"   |  |__53\n" + 
				"   |  |  |__49\n" + 
				"   |  |  |  |__11\n" + 
				"   |  |  |  |__38\n" + 
				"   |  |  |__46\n" + 
				"   |  |     |__43\n" + 
				"   |  |     |__39\n" + 
				"   |  |__54\n" + 
				"   |     |__51\n" + 
				"   |     |  |__48\n" + 
				"   |     |  |__47\n" + 
				"   |     |__50\n" + 
				"   |        |__40\n" + 
				"   |        |__null\n" + 
				"   |__56\n" + 
				"      |__44\n" + 
				"      |  |__41\n" + 
				"      |  |__37\n" + 
				"      |__52\n" + 
				"         |__42\n" + 
				"         |__45\n"};
		outputString = new String[] {heapTest.printFancyTree()};
		
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(reponse[0]) != 0) {
				succes = false;
				break;
			}
		}
		System.out.println((succes)? "Reussi" : "Echec");succes =true;
		
		System.out.print("Test : printFancyTree() de maxheap de array  = ");
		heapTest = new BinaryHeap<Integer>(items, false);
		reponse = new String []{
				"|__58\n" + 
				"   |__56\n" + 
				"   |  |__53\n" + 
				"   |  |  |__50\n" + 
				"   |  |  |  |__38\n" + 
				"   |  |  |  |__11\n" + 
				"   |  |  |__46\n" + 
				"   |  |     |__43\n" + 
				"   |  |     |__39\n" + 
				"   |  |__54\n" + 
				"   |     |__49\n" + 
				"   |     |  |__48\n" + 
				"   |     |  |__47\n" + 
				"   |     |__51\n" + 
				"   |        |__40\n" + 
				"   |        |__null\n" + 
				"   |__57\n" + 
				"      |__44\n" + 
				"      |  |__42\n" + 
				"      |  |__37\n" + 
				"      |__52\n" + 
				"         |__41\n" + 
				"         |__45\n" };
		
		System.out.println((succes)? "Reussi" : "Echec");succes =true;
		outputString = new String[] {heapTest.printFancyTree()};
		
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(reponse[0]) != 0) {
				succes = false;
				break;
			}
		}
		
		System.out.print("Test : printFancyTree() de minHeap de array  = ");
		
		heapTest = new BinaryHeap<Integer>(items, true);
		reponse = new String[] {
		"|__11\n" + 
		"   |__38\n" + 
		"   |  |__39\n" + 
		"   |  |  |__50\n" + 
		"   |  |  |  |__56\n" + 
		"   |  |  |  |__53\n" + 
		"   |  |  |__43\n" + 
		"   |  |     |__46\n" + 
		"   |  |     |__48\n" + 
		"   |  |__40\n" + 
		"   |     |__47\n" + 
		"   |     |  |__54\n" + 
		"   |     |  |__58\n" + 
		"   |     |__49\n" + 
		"   |        |__51\n" + 
		"   |        |__null\n" + 
		"   |__37\n" + 
		"      |__41\n" + 
		"      |  |__44\n" + 
		"      |  |__42\n" + 
		"      |__45\n" + 
		"         |__52\n" + 
		"         |__57\n"};
		outputString = new String[] {heapTest.printFancyTree()};
		
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(reponse[0]) != 0) {
				succes = false;
				break;
			}
		}
		
		System.out.println((succes)? "Reussi" : "Echec");succes = true;
		
		System.out.print("Test : nonRecursivePrintFancyTree() de minHeap de array  => ");
		
		outputString = new String[] {heapTest.nonRecursivePrintFancyTree()};
		for(i = 0; i < outputString.length;i++) {
			if(outputString[0].compareTo(reponse[0]) != 0) {
				succes = false;
				break;
			}
		}
		System.out.println((succes)? "Reussi" : "Echec");succes =true;
	}

}
