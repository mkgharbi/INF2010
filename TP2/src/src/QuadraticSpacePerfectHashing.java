

import java.util.ArrayList;
import java.util.Random;

public class QuadraticSpacePerfectHashing<AnyType> 
{
   static int p = 46337;

   int a, b, m, n, position;
   AnyType[] items;
   Random generator;

   QuadraticSpacePerfectHashing()
   {
      clear();
   }

   QuadraticSpacePerfectHashing(ArrayList<AnyType> array)
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
      a = b = m = n = 0; 
      items = null;
   }

   private int findPos(AnyType x)
   {
      // Completer
	   //Definition de l'espace de memoire ''m''
	   m=(int) Math.pow(n, 2);
	   //on genere deux valeurs aleatoires pour les variables a et b
	   int a=generator.nextInt(100000)+1;
	   int b=generator.nextInt(100000)+1;
	   //Definition de notre fonction de Hachge
	   int HashLocation = ((a*(int)(x)+b)%p)%m;
	   //Verification que HashLocation appartien a l'intervalle definit
	   if (HashLocation>=0 && HashLocation<m)
		   return HashLocation;
	   else 
           return 0;
	  
   }

   public boolean contains(AnyType x )
   {
      if( n == 0 ) return false; 

      int index = findPos(x);

      return ( ( items[index] != null ) && ( items[index].equals(x) ) );
   }

   @SuppressWarnings("unchecked")
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();

      if(array == null || array.size() == 0) return;

      n = array.size();
      m = n*n;

      if(n == 1)
      {
         items = (AnyType[]) new Object[m];
         items[0]	= array.get(0);
         return;
      }

      while( unsuccessfulMemoryAllocation( array ) );
   }

   private boolean unsuccessfulMemoryAllocation(ArrayList<AnyType> array)
   {
      // A completer
	   //On genere aleatoirement a et b
	   a=generator.nextInt(100000)+1;
	   b=generator.nextInt(100000)+1;
	   //initialisation du tableau
	   
	   // On insere Nos elements dans notre tableau deja alloué
	   for (int k=0;k<=array.size();k++)
	   {
		   position=findPos(array.get(k));
		   if(items[position]!=null)
			   return false;
		   else if (items[position]==null)
		   {
			   items[position]=array.get(k);
			   return true;
			  
		   }
		   
	   }
      return false;
   }
   
   public int memorySize() 
   {
      return m;
   }
   
   public String toString(){
      if(n == 0) 
         return "";
      
      StringBuilder sb = new StringBuilder();
      
      for(AnyType item : items) 
         if( item != null ) 
            sb.append(item + ", ");
      
      return sb.toString();
   }
}
