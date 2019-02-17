package TP1.POO;

public class Vetement extends Article {
	private double taille;
	
	public Vetement(String NumProduit, String nom, double taille){
		super(NumProduit,nom); 
		this.taille = taille; 
	}
	
	public Vetement(String NumProduit, String nom, double prix, double taille){
		super(NumProduit,nom,prix);
		this.taille = taille; 
	}
	
	@Override
	public String getArticleType() {
		return ("Vetement") ; 
	}

	public double getTaille() {
		return taille; 
	}

	public void setTaille(double taille) {
		this.taille = taille ; 
	}
	
}
