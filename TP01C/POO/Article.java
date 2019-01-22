package POO;

public class Article {	
	
	private final String NumProduit; 
	private String nom;
	private double Prix_net;
	

    public Article(String NumProduit, String nom){
    	this.NumProduit = NumProduit; 
    	this.nom = nom; 
	}
	
	public Article(String np, String nom, double prix){		
		this.NumProduit = np;
		this.nom = nom; 
		this.Prix_net = prix; 
	}

	public String getNumProduit() {
		return NumProduit; 
	}
	
	public String getNom() {
		return nom; 
	}
	
	public void setNom(String nom) {
		this.nom = nom; 
	}
	
	public double getPrixNet() {
		return Prix_net; 
	}
		
	public void setPrixNet(double prix_net) {
		this.Prix_net = prix_net; 
	}
	
	public double getVAT() {
		// VAT = 15% prix_net
		return (Prix_net/100)*15 ; 
	}
	
	public double getPrix(int count) { /// What is "count" ? 
		return (getPrixNet() + getVAT() );	
	}
	
	public String getArticleType() {
		return ("Article") ; 
	}
	
	@Override
	public String toString() {
		return "Article [NumProduit=" + NumProduit + ", nom=" + nom + ", Prix_net=" + Prix_net + "]";
	}
}
