package personnages;


public class Gaulois {
	private String nom;
	private int force;
	private int nb_trophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];
	
	
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String text) {
		System.out.println(prendreParole() + "<< " + text + ">>");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	

	 private String prendreParole() { 
	 return "Le gaulois " + nom + " : "; 
	 } 
	
	
	
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup((force / 3)*effetPotion);
//	}
	 
	 

	 public void frapper(Romain romain) {
			System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
			Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
			for (int i = 0; trophees != null && i < trophees.length; i++,nb_trophees++) {
				this.trophees[nb_trophees] = trophees[i];
			}
			
		}
	 
	 
	 

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois d�cupl�e.");
	}
	
	
	public void faireUneDonation(Musee musee) {
		if (nb_trophees!=0) {
			parler("Je donne au musee tous mes trophees :");
			for (int i=0; i<nb_trophees;i++) {
				System.out.println(trophees[i].toString());
				musee.donnerTrophee(this, trophees[i]);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain cesar = new Romain("C�sar", 5);
		System.out.println(asterix);
		System.out.println(asterix.getNom());
		
		System.out.println(asterix.prendreParole());
		asterix.parler("Miaou");
		asterix.frapper(cesar);
		
		asterix.boirePotion(7);
		
	}
}
