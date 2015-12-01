package modele;

public class Piece {
	private TypePiece type = null;
	private Couleur couleur = null;
	
	Piece(Couleur couleur, TypePiece type){
		this.type = type;
		this.couleur = couleur;
	}
	
	Piece(){
		
	}
	
	public TypePiece getType(){
		return type;
	}
	
	public void setType(TypePiece type){
		this.type = type;
	}
	
	public Couleur getCouleur(){
		return couleur;
	}
	
	public void setCouleur(Couleur couleur){
		this.couleur = couleur;
	}
	
	public boolean estValide(){
		return (couleur != null) && (type != null);
	}
	
	public String toString(){
		String str = new String();
		switch (type) {
		case Pion:
			str = "p";
			break;
		case Fou :
			str = "f";
			break;
		case Cavalier:
			str = "c";
			break;
		case Tour:
			str = "t";
			break;
		case Dame:
			str = "d";
			break;
		case Roi:
			str = "r";
			break;
		default:
			break;
		}
		if(couleur == Couleur.Blanc){
			str = str.toUpperCase();
		}
		return str;
	}
}
enum TypePiece{
	Pion,
	Cavalier,
	Fou,
	Tour,
	Dame,
	Roi;
}
enum Couleur{
	Blanc,
	Noir;
}