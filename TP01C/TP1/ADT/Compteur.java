package TP1.ADT;

import java.util.Random;

public class Compteur implements Comparable<Compteur> {

    private final String nom;        // nom du compteur
    private int compteur = 0;        // initialisation la valeur courant est 0

    
    public Compteur(String id) {
         nom = id;
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
		return random.nextInt(n);
	}
	

   
    public static void main(String[] args) { 
        int n = 6;
        int essais = 60000;

        
        // Creation n compteurs
        Compteur compteur1 = new Compteur("Cyrille") ;
        Compteur compteur2 = new Compteur("Diana") ;
        Compteur compteur3 = new Compteur("Aicha") ;
        Compteur compteur4 = new Compteur("Mohamed") ;
        Compteur compteur5 = new Compteur("Khairallah") ;
        Compteur compteur6 = new Compteur("Tarek") ;

        Compteur personnesCompteurs [] = { compteur1 , compteur2 , compteur3 ,
        									compteur4 , compteur5, compteur6 } ; 
        // incrémente les compteurs d'essais au hasard
        for (int i = 0 ; i < essais ; i++) {
        	int index = uniform(n); 
        	personnesCompteurs[index].increment();        	
        }
        // Affichage des resultat
        for (int i=0 ; i < n ; i++) { 
        	System.out.println(personnesCompteurs[i].toString());
        }
     
    }
}  
