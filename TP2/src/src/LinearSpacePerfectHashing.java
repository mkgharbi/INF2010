

import java.util.Random;
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
   { // deficition de la position selon la formule donn�e
	   int position = (((a*(int)x) + b) % p) % n;
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
	   if (n==0) return false;
	   else
	   {
		   return(data[position].contains(x));
	   }
      
   }
      
   private void allocateMemory(ArrayList<AnyType> array)
   {
      clear();
      
      if(array == null || array.size() == 0) return;

      n    = array.size();

      if(n == 1)
      {
         // definition de la taille de la memoire
    	  memorySize = 2;
          data[0].items[0] = array.get(0);
          return;
      }
      
      // A completer
      //initialisation de la taille de la memoire 
      memorySize = 0;
      QuadraticSpacePerfectHashing<AnyType>[] dataTemp = new QuadraticSpacePerfectHashing<AnyType>[n];

      for(int k = 0; k<n; k++){
         AnyType type;
         type = array.get(k);
         if (type != null) {
        	 int position = findPos(type);
        	 dataTemp[k].items[position] = type;        	 
         }
      }

      for(int j = 0; j<n; j++){
    	  //instantiation du tableau
         data[j] = dataTemp[j];
         //calcul de la taille de la memoire allou�e
         memorySize += data[j].memorySize();
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
          sb.append(j + " -> " + data[j].toString() + "\n");
       }
      return sb.toString();
   }
}
