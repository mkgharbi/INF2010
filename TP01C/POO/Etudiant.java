package POO;

import java.util.Arrays;
import java.util.Comparator;

public class Etudiant {
	final int N = 10;
	private String Matr;
	private String nom;
	private String prenom;	
	private String email; 
	private int section; 
	
    private int n_des_notes;
	private NoteCours [] notes;
	
	
	public Etudiant(String Matr,String nom, int section) {
            this.Matr = Matr; 
            this.nom = nom; 
            this.section = section; 
	    }
	
	public void AjouterNote(String sigle, String titre, int note){ 
			
		if( notes.length == n_des_notes ) {
			NoteCours [ ] old = notes;
			notes = new NoteCours[ n_des_notes * 2 + 1 ];
			for(int i = 0; i < n_des_notes ; i++ )
				notes[ i ] = old[ i ];
		}
		//Ajout de l'element a la position n_des_notes  du tableau et l'incrementer :  
		notes[n_des_notes].sigle = sigle;
		notes[n_des_notes].titre = titre;
		notes[n_des_notes].note = note;

		//Icrementer le nombre de notes : 
		n_des_notes++ ;
		
	}
	
	public double NoteMoyenne(){
		double moyenne = 0 ;
		for (int i =0 ; i < notes.length ; i++ ) {
			moyenne += notes[i].note;  	// Ajouter l'element note de chaque case du tableau notes. 
		}
		moyenne = moyenne / (notes.length);
		return moyenne;

	}

	public String getMatr() {
		return this.Matr; 
	}

	public void setMatr(String matr) {
		this.Matr = matr; 
	}

    public String getEmail() {
    	return this.email; 
	}

	public void setEmail(String email) {
        this.email = email; 
	}

	public String getNom() {
		return this.nom; 
	}
    
	
	public void setNom(String nom) {
		this.nom = nom; 
	}

	public String getPrenom() {
		return this.prenom; 
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;	}
	
	public int getSection() {
		return section  ;
	}
	
    @Override
	public String toString() {
		return "Etudiant [N=" + N + ", Matr=" + Matr +
				", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", section=" + section + ", n_des_notes=" + n_des_notes +
				", notes=" + Arrays.toString(notes) + "]";
	}
    
    public boolean equals(Object etudiant_x) { 
    	// On suppose qu'il existe un unique immatricule
    	//pour chaque etudiant. La comparaison peut se faire 
    	//seulement en comparant les chaines de Matr 
    	//de l'etudiant_x et de l'etudiant(this)
    	return (((Etudiant) etudiant_x).getMatr() == this.Matr) ? true : false; //Operateur Terner
    }

}