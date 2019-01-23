package ADT;

import java.util.Random;

public class Simulation {
	 private static Random random;  

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
       //completer
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
        	//completer
	    //afficher la diff�rence entre les score des compteur
	        
	    Compteur pile_c = new Compteur("pile");
		Compteur pile_c = new Compteur("face");
		        
	    //Les instructions du simulation
        	//completer
		//afficher le maximum entre les score des compteur

	}
	            
}



