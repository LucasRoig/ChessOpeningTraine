package modele;

public class Bitboard {
	
	//Chaque long contient la position de chaque piece, le bit de poid faible représente la case a1 puis b1, c1...
	private long pion;
	private long cavalier;
	private long fou;
	private long tour;
	private long dame;
	private long roi;
	
	//Chaque long contient la position de chaque pièce d'une couleur.
	private long blanc;
	private long noir;
	
	
	//Couleur campAuTrait;
	
	//Une Case si la prise en passant est possible sur cette case, null sinon
	//Case ep;
	
	//Les Cases sur lesquelles se trouvent les Rois
	//Case caseRoiBlanc;
	//Case caseRoiNoir;
	
	//DroitRoque droitRoque;
	
	public Bitboard(){
		positionInitiale();
	}
	
	public void positionInitiale(){
		pion = Long.parseUnsignedLong("71776119061282560"); //seule méthode pour écrire des unsigned en java
		cavalier = Long.parseUnsignedLong("4755801206503243842");
		fou = Long.parseUnsignedLong("2594073385365405732");
		tour = Long.parseUnsignedLong("9295429630892703873");
		dame = Long.parseUnsignedLong("576460752303423496");
		roi = Long.parseUnsignedLong("1152921504606846992");
		blanc = Long.parseUnsignedLong("65535");
		noir = Long.parseUnsignedLong("18446462598732840960");
	}
	
	public void positionVide(){
		pion = Long.parseUnsignedLong("0"); //seule méthode pour écrire des unsigned en java
		cavalier = Long.parseUnsignedLong("0");
		fou = Long.parseUnsignedLong("0");
		tour = Long.parseUnsignedLong("0");
		dame = Long.parseUnsignedLong("0");
		roi = Long.parseUnsignedLong("0");
		blanc = Long.parseUnsignedLong("0");
		noir = Long.parseUnsignedLong("0");
	}
	
	//Insère la pièce à la position donnée
	public void insererPiece(Case c, Piece piece){
		if (c != null && piece.estValide()){
			long pow = Puissance.puissance(c.ordinal());
			
			pion ^= pow;
			cavalier ^= pow;
			fou ^= pow;
			tour ^= pow;
			dame ^= pow;
			roi ^= pow;
			noir ^= pow;
			blanc ^= pow;
			
			switch (piece.getType()){
			case Pion :
				pion |= pow;
				break;
			case Cavalier :
				cavalier |= pow;
				break;
			case Fou :
				fou |= pow;
				break;
			case Tour :
				tour|= pow;
				break;
			case Dame :
				dame |= pow;
				break;
			case Roi :
				roi |= pow;
			}
			switch (piece.getCouleur()){
			case Blanc:
				blanc |= pow;
				break;
			case Noir :
				noir |= pow;
				break;
			}
		}
	}
	
	//Renvoie la piece occupant la case c
	Piece caseOccupe(Case c){
		Couleur couleur = null;
		TypePiece type = null;
		long p = Puissance.puissance(c.ordinal());
		
		if ((noir&p) != 0){
			couleur = Couleur.Noir;
		}else if ((blanc&p) != 0){
			couleur = Couleur.Blanc;
		}
		if (couleur == null){
			return new Piece();
		}
		if ((pion&p) != 0){
			type = TypePiece.Pion;
			return new Piece(couleur, type);
		}
		if ((cavalier&p) != 0){
			type = TypePiece.Cavalier;
			return new Piece(couleur, type);
		}
		if ((fou&p) != 0){
			type = TypePiece.Fou;
			return new Piece(couleur, type);
		}
		if ((tour&p) != 0){
			type = TypePiece.Tour;
			return new Piece(couleur, type);
		}
		if ((dame&p) != 0){
			type = TypePiece.Dame;
			return new Piece(couleur, type);
		}
		if ((roi&p) != 0){
			type = TypePiece.Roi;
			return new Piece(couleur, type);
		}
		return new Piece();
	}
	
	//Revoie les cases attaquées par un cavalier depuis la case c
	long cavalierAttaqueDepuis(Case c){
		long ord = c.ordinal();
		long pow = Puissance.puissance(c.ordinal());
		//déplacement 2 haut 1 gauche
		long hhg = 0;
		if ((ord % 8 != 0) && !(ord >= 48)){ //vérifie que le cavalier n'est ni sur la colonne a ni sur les lignes 7 ou 8
			hhg = pow<<15;
		}
		
		//déplacement 1 haut deux gauche
		long hgg = 0;
		if ((ord % 8 != 0) && ((ord-1) % 8 != 0) && !(ord >= 56)){
			hgg = pow << 6;
		}
		//déplacement 2 haut 1 droite
		long hhd = 0;
		if((((ord +1) % 8) != 0) && !(ord >= 48)){
			hhd = pow << 17;
		}
		//déplacement 1 haut 2 droite
		long hdd = 0;
		if	((((ord+1) % 8)!= 0) && (((ord + 2) % 8) != 0) && !(ord >= 56)){
			hdd = pow << 10;
		}
		//déplacement 1 bas 2 gauche
		long bgg = 0;
		if ((ord % 8!= 0) && ((ord - 1) % 8 != 0) && (ord > 7))
		{
			bgg = pow >>> 10;
		}
		// déplacement 2 bas 1 gauche
		long bbg = 0;
		if ((ord % 8 != 0) && (ord > 15)){
			bbg = pow >>> 17;
		}
		//déplacement 1 bas 2 droite
		long bdd = 0;
		if (((ord + 1) % 8 != 0) && ((ord + 2) % 8 != 0) && (ord > 7)){
			bdd = pow >>> 6;
		}
		//déplacement 2 bas 1 droite
		long bbd = 0;
		if (((ord + 1) % 8 != 0) && (ord > 15)){
			bbd = pow >>> 15;
		}
		/*if (c.equals(Case.h8))
		{
			System.out.println(Long.toBinaryString(pow));
			System.out.println(Long.toBinaryString(bgg));
			System.out.println(Long.toBinaryString(bbg));
		}*/
		return hhg|hgg|hhd|hdd|bgg|bbg|bdd|bbd;
	}
	
	//Renvoie les cases attaquées par une tour depuis la case c
	long tourAttaqueDepuis (Case c){
		int i = c.ordinal();
		
		//Vers le haut
		long haut = Puissance.puissance(i); 
		//On ajoute la case de départ dans la liste des cases, penser à l'enlever à la fin
		i += 8;
		while (i < 64){
			haut = haut | (haut << 8);
			//arrête la boucle si l'on rencontre une pièce
			if ((haut & (blanc|noir)) != 0){
				break;
			}
			i += 8;
		}
		
		//Vers le bas 
		i = c.ordinal();
		long bas = Puissance.puissance(i);
		//On ajoute la case de départ dans la liste des cases, penser à l'enlever à la fin
		i -= 8;
		while (i >= 0){
			bas = bas | (bas >>> 8);
			if ((bas & (blanc|noir)) != 0){
				break;
			}
			i -= 8;
		}
		
		//vers la droite
		i = c.ordinal();
		long droite = Puissance.puissance(i);
		//On ajoute la case de départ dans la liste des cases, penser à l'enlever à la fin
		i += 1;
		while ((i % 8 != 0) && i < 64){
			droite = droite | (droite << 1);
			if ((droite & (blanc|noir)) != 0){
				break;
			}
			i += 1;
		}
		
		//vers la gauche
		i = c.ordinal();
		long gauche = Puissance.puissance(i);
		//On ajoute la case de départ dans la liste des cases, penser à l'enlever à la fin
		i -= 1;
		while (((i + 1) % 8 != 0) && i >= 0){
			gauche = gauche | (gauche >>> 1);
			if ((gauche & (blanc|noir)) != 0){
				break;
			}
			i -= 1;
		}
		
		return (gauche|droite|haut|bas)&(~Puissance.puissance(c.ordinal()));
	}
	
	//renvoie les cases attaquées par un fou depuis la case c
	long fouAttaqueDepuis(Case c){
		int i = c.ordinal();
		
		//Diagonale haut droite
		long hd = Puissance.puissance(i);
		//On ajoute la case de départ dans la liste des cases, penser à l'enlever à la fin
		i += 9;
		while ((i < 64) && ((i % 8) != 0)){
			hd = hd | (hd << 9);
			//arrête la boucle si l'on rencontre une pièce
			if ((hd & (blanc | noir)) != 0){
				break;
			}
			i += 9;
			
		}
		
		//Diagonale haut gauche
		i = c.ordinal();
		long hg = Puissance.puissance(i);
		i += 7;
		while ((i < 64) && ((i + 1) % 8 != 0)) {
			hg = hg | (hg << 7);
			if ((hg & (blanc | noir)) != 0){
				break;
			}
			i += 7;
		}
		
		//Diagonale bas gauche
		i = c.ordinal();
		long bg = Puissance.puissance(i);
		i -= 9;
		while ((i >= 0) && ((i + 1) % 8 != 0) ){
			bg = bg | (bg >>> 9);
			if ((bg & (blanc | noir)) != 0) {
				break;
			}
			i -= 9;
		}
		
		//Diagonale bas droite
		i = c.ordinal();
		long bd = Puissance.puissance(i);
		i -= 7;
		while ((i >= 0) && ((i % 8 != 0))) {
			bd = bd | (bd >>> 7);
			if ((bd & (blanc | noir)) != 0) {
				break;
			}
			i -= 7;
		}
		return (hd | hg | bd | bg) & ~Puissance.puissance(c.ordinal());
	}

	//renvoie les cases attaquées par une dame depuis la case c
	long dameAttaqueDepuis(Case c){
		return tourAttaqueDepuis(c) | fouAttaqueDepuis(c);
	}
	
	//renvoie les cases attaquées par un roi depuis la case c
	long roiAttaqueDepuis(Case c){
		int i = c.ordinal();
		long pow = Puissance.puissance(i);
		long deplacement = 0;
		
		//vers le haut.
		if (i + 8 < 64) {
			deplacement = deplacement | (pow << 8);
			//diag haut gauche
			if(i % 8 != 0){
				deplacement = deplacement | (pow << 7);
			}
			//diag haut droite
			if (i % 8 != 7) {
				deplacement = deplacement | (pow << 9);
			}
		}
		// vers le bas 
		if (i - 8 >= 0){
			deplacement = deplacement | (pow >>> 8);
			//diag bas gauche
			if (i % 8 != 0){
				deplacement = deplacement | (pow >>> 9);
			}
			//diag bas droite
			if (i % 8 != 7){
				deplacement = deplacement | (pow >>> 7);
			}
		}
		//vers la gauche
		if (i % 8 != 0) {
			deplacement = deplacement | (pow >>> 1);
		}
		//vers la droite
		if (i % 8 != 7) {
			deplacement = deplacement | (pow << 1);
		}
		return deplacement;
	}
	
	//Ces deux méthodes permettent l'affichage de l'échiquier en mode texte
	// 0=case vide, 1=pion, 2=cavalier, 3=fou, 4=tour, 5=roi, 6=dame
	// les chiffres négatifs représentent les pièces noires.
	public void printBitboard(){
		int i = 56;
		while ( i>= 0){
			printPiece(caseOccupe(Case.values()[i]));
			i++;
			if (i % 8 == 0){
				i -= 16;
				System.out.println("");
			}
		}
		
	}
	private void printPiece(Piece piece){
		if (piece == null || !piece.estValide()){
			System.out.print("0");
			return;
		}
		System.out.print(piece.toString());
	}
}
