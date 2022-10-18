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
	
//	public void recevoirCoup(int forceCoup) {
//		assert(force > 0);
//		int forceini = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} 
//		else {
//			parler("J'abandonne...");
//		}
//		assert(force < forceini);
//	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement ++;
			System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement + ".");
			break;
		case 1:
			if (equipements[nbEquipement-1] == equipement){
				System.out.println("Le soldat " + this.nom + " possède déjà un " + equipement + ".");
			}
			else {
				equipements[nbEquipement] = equipement;
				nbEquipement ++;
				System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement + ".");
			}
			break;
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		default:
			System.out.println("erreur : [insérer message d'erreur]");
			break;
		}
		
	}
	

	 public Equipement[] recevoirCoup(int forceCoup) { 
	 Equipement[] equipementEjecte = null; 
	 // précondition 
	 assert force > 0; 
	 int oldForce = force; 
	 forceCoup = calculResistanceEquipement(forceCoup); 
	 force -= forceCoup; 
	 //  if (force > 0) { 
	 //  parler("Aïe"); 
	 //  } else { 
	 //  equipementEjecte = ejecterEquipement(); 
	 //  parler("J'abandonne..."); 
	 //  } 
	 if (force == 0) { 
	 parler("Aïe");
	 }
	 else {
	 equipementEjecte = ejecterEquipement(); 
	 parler("J'abandonne..."); 
	 } 
	 
	 // post condition la force à diminuer 
	 assert force < oldForce; 
	 return equipementEjecte; 
	 
	}
	
	

	 private int calculResistanceEquipement(int forceCoup) { 
	 String texte; 
	 texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup; 
	 int resistanceEquipement = 0; 
	 if ((nbEquipement != 0)) { 
	 texte += "\nMais heureusement, grace à mon équipement sa force est diminué de "; 
	 for (int i = 0; i < nbEquipement;) { 
	 if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) { 
	 resistanceEquipement += 8; 
	 } else { 
	 System.out.println("Equipement casque"); 
	 resistanceEquipement += 5; 
	 } 
	 i++; 
	 } 
	 texte =+ resistanceEquipement + "!"; 
	 } 
	 parler(texte); 
	 forceCoup -= resistanceEquipement; 
	 return forceCoup; 
	 } 
	 
	 
	 
	 private Equipement[] ejecterEquipement() { 
	 Equipement[] equipementEjecte = new Equipement[nbEquipement]; 
	 System.out.println("L'équipement  de  "  +  nom.toString()  +  " s'envole sous la force du coup."); 
	 //TODO 
	 int nbEquipementEjecte = 0; 
	 for (int i = 0; i < nbEquipement; i++) {

		 if (equipements[i] == null) { 
		 continue; 
		 } else { 
		 equipementEjecte[nbEquipementEjecte]  = 
		 equipements[i]; 
		 nbEquipementEjecte++; 
		 equipements[i] = null; 
		 } 
		 } 
		 return equipementEjecte; 
		 } 
	
	
	
	public static void main(String[] args) {
		Romain cesar = new Romain("César", 6);
		//Romain cesar = new Romain("César", -6);
		
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
