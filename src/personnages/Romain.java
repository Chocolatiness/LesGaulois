package personnages;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];
	

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
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement ++;
			System.out.println("Le soldat " + this.nom + " s'�quipe avec un " + equipement + ".");
			break;
		case 1:
			if (equipements[nbEquipement-1] == equipement){
				System.out.println("Le soldat " + this.nom + " poss�de d�j� un " + equipement + ".");
			}
			else {
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat " + this.nom + " s'�quipe avec un " + equipement + ".");
			}
			break;
		case 2:
			System.out.println("Le soldat " + this.nom + " est d�j� bien prot�g� !");
			break;
		default:
			System.out.println("erreur : [ins�rer message d'erreur]");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Romain cesar = new Romain("C�sar", 6);
		//Romain cesar = new Romain("C�sar", -6);
		
		System.out.println(cesar.prendreParole());
		cesar.parler("Test");
		cesar.recevoirCoup(3); // force <
		cesar.recevoirCoup(8); // force >
		//System.out.println(Equipement.CASQUE);
		//System.out.println(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.CASQUE);
		cesar.sEquiper(Equipement.BOUCLIER);
		cesar.sEquiper(Equipement.CASQUE);
	}
	
}
