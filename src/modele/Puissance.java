package modele;

public class Puissance {
	static boolean initialise = false;
	static long[] pow = new long[64];
	
	//Renvoie des puissances de 2 comme unsigned long
	static long puissance(int exposant){
		if (!initialise) {
			pow[0] = 1;
			for (int i = 1; i < pow.length; i++) {
				pow[i] = pow[i-1] << 1;
			}
			initialise = true;
		}
		return pow[exposant];
	}
}
