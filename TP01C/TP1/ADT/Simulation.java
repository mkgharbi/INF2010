package  TP1.ADT;

import java.lang.IllegalArgumentException ; 
import java.util.Random;

public class Simulation {
	 private static Random random = new Random();  

	 //Retourne un nombre r�el al�atoire uniform�ment dans [0,1[
	    public static double uniform() {
	    	return random.nextDouble();
	    }

	 //Retourne un nombre entier al�atoire uniform�ment dans [0,n[
	    public static int uniform(int n) {
			return (random.nextInt(n));
	    }

	//Retourne un entier long al�atoire uniform�ment dans [0, n[.
    // Vous pouviez trouver le code https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#longs-long-long-long-
    public static long uniform(long n) {
        if (n <= 0L) throw new IllegalArgumentException("Argument doit etre positive: " + n);


        long r = random.nextLong();
        long m = n - 1;

        
        if ((n & m) == 0L) {
            return r & m;
        }

      
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }
    
    //Retourne avec succ�s un bool�en true si p suit d'une distribution de Bernoulli
    public static boolean bernoulli(double p) {
       if ( p >= 1.0 || p <= 0.0)
    	   throw new  IllegalArgumentException("Argument donne hors de l'intervalle ]0.0,1.0[")   ; 
       
       double uniform = uniform(); 
       if (p < uniform)
    	   return true; 
       else return false; 
    }
    
    public static Compteur max(Compteur x, Compteur y) {
    	double comparaison = x.compareTo(y);
    	if (comparaison == 1.0 ) { 
    		return x; 
    	}
    	else if (comparaison == -1.0) {
    		return y;    		
    	}
    	else return x; //En cas d'egalite retourner l'un ou l'autre (x est choisi arbitrairement)
    }
	
	public static void main(String[] args) {
		int n = 10;
	    Compteur pile = new Compteur("pile");
	    Compteur face = new Compteur("face");
	       
        //Les instructions du simulation
	    	for (int i = 0 ; i < n ; i++) {
	    		if (bernoulli(0.5)) 
	    			pile.increment() ;  
	    		else  face.increment();
	    	}
	    //afficher la diff�rence entre les score des compteur
	    System.out.println(" La difference entre les deux compteurs est egale a " + Math.abs(pile.score() - face.score()));
	    	
	    Compteur pile_c = new Compteur("pile");
		Compteur face_c = new Compteur("face");
		        
	    //Les instructions du simulation
		for (int i = 0 ; i < n ; i++) {
    		if (bernoulli(0.5)) 
    			pile_c.increment() ;  
    		else  face_c.increment();
    	}
		//afficher le maximum entre les score des compteur
		System.out.println("Le compteur maximum entre les 2 compteurs est egale a " + max(pile_c,face_c).score()) ;
	}
	            
}



