

import java.util.Random;
import java.util.ArrayList;

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
   { // deficition de la position selon la formule donn�e
	   int position = ( ( (a*(int)x) + b) % p) % n;
	 // verifiacation de l'intervalle
	      if (position <0){
	         position += n;
	      }
	      //retour de la position
	      return position;
     
   }
   
   public boolean contains(AnyType x)
   {    //on trouve la position 
	   int position = findPos(x);
	   //on verifie que le nombre d'objet n est pas null
	   if (n == 0) return false;
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
    	  data[0].setArray(array); 
      }
      else {
    	  //A refaire 
    	  for (int i = 0 ; i < data.length ; i++) { 
    		  int counter = 0 ; 
    		  for ( int j=0 ; j < data[i].memorySize() ; j++) 
       		  {
    			 /* if (contains(data[i].[j])) {
    				  memorySize++;  
    			  }*/
    		  }
    		  for (int j=0 ; j < data[i].memorySize() ; j++) { 
    			  //data[j].memoryAllocate();
    		  }
    	  }
      }
      // A completer
   }
   
   public int memorySize() 
   {
      return memorySize;
   }
   
   public String toString(){
      StringBuilder sb = new StringBuilder();
           
   	   for ( int i = 0 ; i < data.length ; i++) {
   		   sb.append(String.valueOf(i));
   		   sb.append(" -> ");
   	   
          if( data[i].memorySize() != 0 ) 
        	  data[i].toString();
   	   }
      return sb.toString();
}
}
