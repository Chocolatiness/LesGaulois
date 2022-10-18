package personnages;

public class Romain {
	private String nom;
	private int force;
	

	public Romain(String nom, int force) {
		assert(force>0);
		this.nom = nom;
		this.force = force;
	}


	public String getNom() {
		return nom;
	}
	
	public void parler(String text) {
		System.out.println(prendreParole() + "<< " + text + ">>");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(force > 0);
		int forceini = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} 
		else {
			parler("J'abandonne...");
		}
		assert(force < forceini);

	}
	
	public static void main(String[] args) {
		//Romain cesar = new Romain("César", 5);
		Romain cesar = new Romain("César", -6);
		
		System.out.println(cesar.prendreParole());
		cesar.parler("Wouaf");
		cesar.recevoirCoup(3); // force <
		cesar.recevoirCoup(8); // force >
	}
	
}
