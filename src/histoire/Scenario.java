package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Gaulois obelix = new Gaulois("Ob�lix", 42);
		Romain minus = new Romain("Minus", 6);
		panoramix.preparerPotion();
		//panoramix.preparerPotion();panoramix.preparerPotion();panoramix.preparerPotion();panoramix.preparerPotion();panoramix.preparerPotion();panoramix.preparerPotion();panoramix.preparerPotion();panoramix.preparerPotion();
		//ci dessus � but de tester que la fonction respecte l'�cart entre 5 et 10 et pas autre chose
		panoramix.booster(obelix);
		obelix.parler("Par B�l�nos, ce n'est pas juste !");
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		
	}

}
