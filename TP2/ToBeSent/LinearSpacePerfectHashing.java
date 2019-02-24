

import java.util.Random;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LinearSpacePerfectHashing<AnyType>
{
   static int p = 46337;
   
   int a, b, n, memorySize;
   QuadraticSpacePerfectHashing<AnyType>[] data;
   Random generator;
   
   LinearSpacePerfectHashing()
   {
      clear();
   }
   
   LinearSpacePerfectHashing(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }
   
   public void setArray(ArrayList<AnyType> array)
   {
      allocateMemory(array);
   }
   
   public int size()
   {
      return n;
   }

   public void clear()
   {
      generator = new Random( System.nanoTime() );
      a = b = n = memorySize = 0; 
      data = null;
   }

   private int findPos(AnyType x)
   { 	
	   int position = ((a*x.hashCode() + b) % p) % n;
	   
	 // verifiacation de l'intervalle
	      if (position >= n ){
	         position = position % n;
	      }
	      else if (position <0) 
	    	  position *= -1 ;
	      //retour de la position
	      return position;
   }
   
   public boolean contains(AnyType x)
   {    //on trouve la position 
	   int position = findPos(x);
	   //on verifie que le nombre d'objet n est pas null
	   if (data[position]==null) return false;
	   else
	   {
		   return(data[position].contains(x));
	   }
      
   }
      
   @SuppressWarnings("unchecked")
private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();
      
      if(array == null || array.size() == 0) return;

      n    = array.size();
      data = new QuadraticSpacePerfectHashing[n];

      if(n == 1)
      {
         // definition de la taille de la memoire
    	  data[0] = new QuadraticSpacePerfectHashing<AnyType>(array);
    	  memorySize = 1;
          return;
      }

 	 //On genere aleatoirement a et b
 	   a=generator.nextInt(p-1)+1;
 	   b=generator.nextInt(p);
 	  
      java.util.Iterator<AnyType> iterator = array.iterator();
      @SuppressWarnings("unchecked")
	ArrayList<AnyType>[] arrayTempo = (ArrayList<AnyType>[]) new ArrayList[n]; 
      while(iterator.hasNext()) {
    	  AnyType type = iterator.next();
    	  int position = findPos(type);
    	  if (arrayTempo[position] == null)
    		  arrayTempo[position] = new ArrayList<AnyType>();
    	  arrayTempo[position].add(type); 
      }
      for (int i = 0; i < n; i++) {
    	  if(arrayTempo[i] != null) {
    		  int nElement = arrayTempo[i].size();
    		  memorySize += nElement * nElement;
    		  data[i] = new QuadraticSpacePerfectHashing<AnyType>(arrayTempo[i]);
    	  }
      }
   }
   public int memorySize() 
   {
      return memorySize;
   }
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
      //utilisation de l'API stringbuilder qui cr�e un generateur de chaines de caracteres
      // utilisation de la methode ''append'' qui est surcharg�e et permet d'ajouter une chaine specifique a une autre
      for(int j = 0; j<n; j++){
    	  sb.append(j + " -> ");  
		   if(data[j] != null)
	        	 sb.append(data[j].toString());
		   sb.append("\n");
	   }
       
      return sb.toString();
   }
}
