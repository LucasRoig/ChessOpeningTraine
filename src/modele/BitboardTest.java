package modele;

import static org.junit.Assert.*;

import java.awt.image.RescaleOp;

import org.junit.Test;

public class BitboardTest {

	@Test
	public void testCavalierAttaqueDepuis() {
		
		Bitboard bitboard = new Bitboard();
		long res = 0;
		//test Cavalier depuis a1
		res = Long.parseUnsignedLong("132096");
		
		assertTrue("a1", bitboard.cavalierAttaqueDepuis(Square.getIndex("a1")) == res);
		//test Cavalier a2
		res = Long.parseUnsignedLong("33816580");
		assertTrue("a2", bitboard.cavalierAttaqueDepuis(Square.getIndex("a2")) == res);
		//test Cavalier a4
		res = Long.parseUnsignedLong("2216203387392");
		assertTrue("a4", bitboard.cavalierAttaqueDepuis(Square.getIndex("a4")) == res);
		//test Cavalier a7
		res = Long.parseUnsignedLong("288234782788157440");
		assertTrue("a7", bitboard.cavalierAttaqueDepuis(Square.getIndex("a7")) == res);
		//test Cavalier a8
		res = Long.parseUnsignedLong("1128098930098176");
		assertTrue("a8", bitboard.cavalierAttaqueDepuis(Square.getIndex("a8")) == res);
		//test Cavalier b1
		res = Long.parseUnsignedLong("329728");
		assertTrue("b1", bitboard.cavalierAttaqueDepuis(Square.getIndex("b1")) == res);
		//test Cavalier b2
		res = Long.parseUnsignedLong("84410376");
		assertTrue("b2", bitboard.cavalierAttaqueDepuis(Square.getIndex("b2")) == res);
		//test cavalier b4
		res = Long.parseUnsignedLong("5531918402816");
		assertTrue("b4", bitboard.cavalierAttaqueDepuis(Square.getIndex("b4")) == res);
		//test cavalier b7
		res = Long.parseUnsignedLong("576469569871282176");
		assertTrue("b7", bitboard.cavalierAttaqueDepuis(Square.getIndex("b7")) == res);
		//test cavalier b8
		res = Long.parseUnsignedLong("2257297371824128");
		assertTrue("b8", bitboard.cavalierAttaqueDepuis(Square.getIndex("b8")) == res);
		//test cavalier e1
		res = Long.parseUnsignedLong("2638848");
		assertTrue("e1", bitboard.cavalierAttaqueDepuis(Square.getIndex("e1")) == res);
		//test cavalier e2
		res = Long.parseUnsignedLong("675545156");
		assertTrue("e2", bitboard.cavalierAttaqueDepuis(Square.getIndex("e2")) == res);
		//test cavalier e4
		res = Long.parseUnsignedLong("44272527353856");
		assertTrue("e4", bitboard.cavalierAttaqueDepuis(Square.getIndex("e4")) == res);
		//test cavalier e7
		res = Long.parseUnsignedLong("4899991333168480256");
		assertTrue("e7", bitboard.cavalierAttaqueDepuis(Square.getIndex("e7")) == res);
		//test cavalier e8
		res = Long.parseUnsignedLong("19184278881435648");
		assertTrue("e8", bitboard.cavalierAttaqueDepuis(Square.getIndex("e8")) == res);
		//test cavalier g1
		res = Long.parseUnsignedLong("10489856");
		assertTrue("g1", bitboard.cavalierAttaqueDepuis(Square.getIndex("g1")) == res);
		//test cavalier g2
		res = Long.parseUnsignedLong("2685403152");
		assertTrue("g2", bitboard.cavalierAttaqueDepuis(Square.getIndex("g2")) == res);
		//test cavalier g4
		res = Long.parseUnsignedLong("175990581010432");
		assertTrue("g4", bitboard.cavalierAttaqueDepuis(Square.getIndex("g4")) == res);
		//test cavalier g7
		res = Long.parseUnsignedLong("1152939783987658752");
		assertTrue("g7", bitboard.cavalierAttaqueDepuis(Square.getIndex("g7")) == res);
		//test cavalier g8
		res = Long.parseUnsignedLong("4679521487814656");
		//System.out.println(bitboard.cavalierAttaqueDepuis(Case.g8));
		assertTrue("g8", bitboard.cavalierAttaqueDepuis(Square.getIndex("g8")) == res);
		//test cavalier h1
		res = Long.parseUnsignedLong("4202496");
		assertTrue("h1", bitboard.cavalierAttaqueDepuis(Square.getIndex("h1")) == res);
		//test cavalier h2
		res = Long.parseUnsignedLong("1075839008");
		assertTrue("h2", bitboard.cavalierAttaqueDepuis(Square.getIndex("h2")) == res);
		//test cavalier h4
		res = Long.parseUnsignedLong("70506185244672");
		assertTrue("h4", bitboard.cavalierAttaqueDepuis(Square.getIndex("h4")) == res);
		//test cavalier h7
		res = Long.parseUnsignedLong("2305878468463689728");
		assertTrue("h7", bitboard.cavalierAttaqueDepuis(Square.getIndex("h7")) == res);
		//test cavalier h8
		res = Long.parseUnsignedLong("9077567998918656");
		//System.out.println(bitboard.cavalierAttaqueDepuis(Case.h8));
		assertTrue("h8", bitboard.cavalierAttaqueDepuis(Square.getIndex("h8")) == res);
	}
	
	@Test
	public void testTourAttaqueDepuis(){
		Bitboard bitboard = new Bitboard();
		bitboard.positionVide();
		Piece piece = new Piece(Couleur.Blanc, TypePiece.Pion);
		long res = 0;
		
		//Tour seule en d4
		res = Long.parseUnsignedLong("578721386714368008");
		assertTrue("Tour seule en d4", bitboard.tourAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Tour en d4 bloquée en d3
		bitboard.insererPiece(Square.getIndex("d3"), piece);
		res = Long.parseUnsignedLong("578721386714365952");
		assertTrue("Tour en d4 bloquée en d3", bitboard.tourAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Tour en d4 bloquée en c4
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("c4"), piece);
		res = Long.parseUnsignedLong("578721386664036360");
		assertTrue("Tour en d4 bloquée en c4", bitboard.tourAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Tour en d4 bloquée en d5
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("d5"), piece);
		res = Long.parseUnsignedLong("38504237064");
		assertTrue("Tour en d4 bloquée en d5", bitboard.tourAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Tour en d4 bloquée en e4
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("e4"), piece);
		res = Long.parseUnsignedLong("578721382956271624");
		assertTrue("Tour en d4 bloquée en e4", bitboard.tourAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Tour seule en a1
		bitboard.positionVide();
		res = Long.parseUnsignedLong("72340172838076926");
		assertTrue("Tour seule en a1", bitboard.tourAttaqueDepuis(Square.getIndex("a1")) == res);
		
		//tour en a1 bloquée en a2
		bitboard.insererPiece(Square.getIndex("a2"), piece);
		res = Long.parseUnsignedLong("510");
		assertTrue("tour en a1 bloquée en a2", bitboard.tourAttaqueDepuis(Square.getIndex("a1")) == res);
		
		//tour en a1 bloquée en b1
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("b1"), piece);
		res = Long.parseUnsignedLong("72340172838076674");
		assertTrue("tour en a1 bloquée en b1", bitboard.tourAttaqueDepuis(Square.getIndex("a1")) == res);
		
		//Tour seule en a8 
		bitboard.positionVide();
		res = Long.parseUnsignedLong("18302911464433844481");
		//System.out.println(Long.toBinaryString(bitboard.tourAttaqueDepuis(Case.a8)));
		assertTrue("Tour seule en a8 ", bitboard.tourAttaqueDepuis(Square.getIndex("a8")) == res);
		
		//tour en a8 bloquée en a7
		bitboard.insererPiece(Square.getIndex("a7"), piece);
		res = Long.parseUnsignedLong("18302910360610406400");
		assertTrue("tour en a8 bloquée en a7 ", bitboard.tourAttaqueDepuis(Square.getIndex("a8")) == res);
		
		//tour en a8 bloquée en b8
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("b8"), piece);
		res = Long.parseUnsignedLong("144397766876004609");
		assertTrue("tour en a8 bloquée en b8 ", bitboard.tourAttaqueDepuis(Square.getIndex("a8")) == res);
		
		//tour en h1 seule
		bitboard.positionVide();
		res = Long.parseUnsignedLong("9259542123273814143");
		assertTrue("tour en h1 seule", bitboard.tourAttaqueDepuis(Square.getIndex("h1")) == res);
		
		//tour en h1 bloquée en h2
		bitboard.insererPiece(Square.getIndex("h2"), piece);
		res = Long.parseUnsignedLong("32895");
		assertTrue("tour en h1 bloquée en h2", bitboard.tourAttaqueDepuis(Square.getIndex("h1")) == res);
		
		//tour en h1 bloquée en g1
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("g1"), piece);
		res = Long.parseUnsignedLong("9259542123273814080");
		assertTrue("tour en h1 bloquée en g1", bitboard.tourAttaqueDepuis(Square.getIndex("h1")) == res);
		
		//tour en h8 seule
		bitboard.positionVide();
		res = Long.parseUnsignedLong("9187484529235886208");
		assertTrue("tour en h8 seule", bitboard.tourAttaqueDepuis(Square.getIndex("h8")) == res);
		
		//tour en h8 bloquée en h7
		bitboard.insererPiece(Square.getIndex("h7"), piece);
		res = Long.parseUnsignedLong("9187343239835811840");
		assertTrue("tour en h8 bloquée en h7", bitboard.tourAttaqueDepuis(Square.getIndex("h8")) == res);
		//tour en h8 bloquée en g8
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("g8"), piece);
		res = Long.parseUnsignedLong("4647856104846426240");
		assertTrue("tour en h8 bloquée en h7", bitboard.tourAttaqueDepuis(Square.getIndex("h8")) == res);
	}

	@Test
	public void testFouAttaqueDepuis(){
		Bitboard bitboard = new Bitboard();
		bitboard.positionVide();
		long res = 0;
		Piece piece = new Piece(Couleur.Blanc, TypePiece.Pion);
		
		//Fou en d4 seul
		res = Long.parseUnsignedLong("9241705379636978241");
		assertTrue("Fou en d4 seul", bitboard.fouAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Fou en d4 bloqué en c3
		bitboard.insererPiece(Square.getIndex("c3"), piece);
		res = Long.parseUnsignedLong("9241705379636977728");
		assertTrue("Fou en d4 bloqué en c3", bitboard.fouAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Fou en d4 bloqué en c5
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("c5"), piece);
		res = Long.parseUnsignedLong("9241421705637012033");
		assertTrue("Fou en d4 bloqué en c5", bitboard.fouAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Fou en d4 bloqué en e3
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("e3"), piece);
		res = Long.parseUnsignedLong("9241705379636969985");
		assertTrue("Fou en d4 bloqué en e3", bitboard.fouAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Fou en d4 bloqué en e5
		bitboard.positionVide();
		bitboard.insererPiece(Square.getIndex("e5"), piece);
		res = Long.parseUnsignedLong("283759900631617");
		assertTrue("Fou en d4 bloqué en e5", bitboard.fouAttaqueDepuis(Square.getIndex("d4")) == res);
		
		//Fou en a1 seul
		bitboard.positionVide();
		res = Long.parseUnsignedLong("9241421688590303744");
		assertTrue("Fou en a1 seul", bitboard.fouAttaqueDepuis(Square.getIndex("a1")) == res);
		
		//Fou en a1 bloqué en b2
		bitboard.insererPiece(Square.getIndex("b2"), piece);
		res = Long.parseUnsignedLong("512");
		assertTrue("Fou en a1 bloqué en b2", bitboard.fouAttaqueDepuis(Square.getIndex("a1")) == res);
		
		//Fou en a8 seul
		bitboard.positionVide();
		res = Long.parseUnsignedLong("567382630219904");
		assertTrue("Fou en a8 seul", bitboard.fouAttaqueDepuis(Square.getIndex("a8")) == res);
		
		//Fou en a8 bloqué en b7
		bitboard.insererPiece(Square.getIndex("b7"), piece);
		res = Long.parseUnsignedLong("562949953421312");
		assertTrue("Fou en a8 bloqué en b7", bitboard.fouAttaqueDepuis(Square.getIndex("a8")) == res);
		
		//Fou en h1 seul
		bitboard.positionVide();
		res = Long.parseUnsignedLong("72624976668147712");
		assertTrue("Fou en h1 seul", bitboard.fouAttaqueDepuis(Square.getIndex("h1")) == res);
		
		//Fou en h1 bloqué en g2
		bitboard.insererPiece(Square.getIndex("g2"), piece);
		res = Long.parseUnsignedLong("16384");
		assertTrue("Fou en h1 bloqué en g2", bitboard.fouAttaqueDepuis(Square.getIndex("h1")) == res);
		
		//Fou en h8 seul
		bitboard.positionVide();
		res = Long.parseUnsignedLong("18049651735527937");
		assertTrue("Fou en h8 seul", bitboard.fouAttaqueDepuis(Square.getIndex("h8")) == res);
		
		//Fou en h8 bloqué en g7
		bitboard.insererPiece(Square.getIndex("g7"), piece);
		res = Long.parseUnsignedLong("18014398509481984");
		assertTrue("Fou en h8 bloqué en g7", bitboard.fouAttaqueDepuis(Square.getIndex("h8")) == res);
	}
	
	@Test
	public void testRoiAttaqueDepuis(){
		Bitboard bitboard = new Bitboard();
		long res = 0;
		//Roi en a1
		res = Long.parseUnsignedLong("770");
		//System.out.println(Long.toBinaryString(bitboard.roiAttaqueDepuis(Case.a1)));
		assertTrue("Roi en a1", bitboard.roiAttaqueDepuis(Square.getIndex("a1")) == res);
		//Roi en a8
		res = Long.parseUnsignedLong("144959613005987840");
		assertTrue("Roi en a8", bitboard.roiAttaqueDepuis(Square.getIndex("a8")) == res);
		//Roi en h1
		res = Long.parseUnsignedLong("49216");
		assertTrue("Roi en h1", bitboard.roiAttaqueDepuis(Square.getIndex("h1")) == res);
		//Roi en h8
		res = Long.parseUnsignedLong("4665729213955833856");
		assertTrue("Roi en h8", bitboard.roiAttaqueDepuis(Square.getIndex("h8")) == res);
		//Roi en e4
		res = Long.parseUnsignedLong("241192927232");
		assertTrue("Roi en e4", bitboard.roiAttaqueDepuis(Square.getIndex("e4")) == res);
	}
}
