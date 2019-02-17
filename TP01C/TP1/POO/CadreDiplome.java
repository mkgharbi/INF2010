package TP1.POO;

public class CadreDiplome extends Article {
	private String categorie;
	private String couleur; //Eclipse me demande de completer les getters et setters de l'attribut couleur.
	
	public CadreDiplome(String NumProduit, String nom, double prix, String couleur,String categorie){
		super(NumProduit,nom,prix);
		this.setCouleur(couleur); 
		this.categorie = categorie; 
	}
	
	public CadreDiplome(String NumProduit, String nom, double prix,String categorie){
		super(NumProduit,nom,prix);
		this.categorie = categorie; 
		this.setCouleur("Sans couleur");
	}
	
	@Override
	public String getArticleType() {
		return ("Cadre Diplome");
	}
	
	public String getCategorie() {
		return categorie; 
	}

	public void setCategorie(String categorie) {
        this.categorie = categorie ; 
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
}
