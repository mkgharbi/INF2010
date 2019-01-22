package ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
         id = nom;
         increment();
    } 

   
    public void increment() {
         compteur++;
    } 

   
    public int score() {
         return compteur; 
    } 

   
    @Override
	public String toString() {
		return "Compteur [nom=" + nom + ", compteur=" + compteur + "]";
	} 

  
    public int compareTo(Compteur x) {
    	/* signum retourne :
    	 * 1.0 si this.compteur > x.score()
    	 * -1.0 si this.compteur < x.score()
    	 *  0.0 si this.compteur == x.score()   
    	*/
        return Integer.signum(compteur- x.score());  
    }
    
    private static Random random=new Random(10000);
    
    
    
    //Retourne un nombre entier aléatoire uniformément dans [0,n[
	public static int uniform(int n) {
		return (int)(Math.random() * n);
	}


   
    public static void main(String[] args) { 
        int n = 6;
        int essais = 60000;

        // Creation n compteurs
        
        
        // incrémente les compteurs d'essais au hasard
        

        // Affichage des resultat
        
        }
    } 
} 
