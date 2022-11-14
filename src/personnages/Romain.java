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
	

	 public Equipement[] recevoirCoup(int forceCoup) { 
	 Equipement[] equipementEjecte = null; 
	 // pr�condition 
	 assert force > 0; 
	 int oldForce = force; 
	 forceCoup = calculResistanceEquipement(forceCoup); 
	 force -= forceCoup; 
	 //  if (force > 0) { 
	 //  parler("A�e"); 
	 //  } else { 
	 //  equipementEjecte = ejecterEquipement(); 
	 //  parler("J'abandonne..."); 
	 //  } 
	 if (force == 0) { 
	 parler("Aie");
	 }
	 else {
	 equipementEjecte = ejecterEquipement(); 
	 parler("J'abandonne..."); 
	 } 
	 
	 // post condition la force � diminuer 
	 assert force < oldForce; 
	 return equipementEjecte; 
	 
	}
	
	

	 private int calculResistanceEquipement(int forceCoup) {
			String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
			int resistanceEquipement = 0;
			if ((nbEquipement != 0)) {
				texte += "\nMais heureusement, grace a mon equipement sa force est diminue de ";
				for (int i = 0; i < nbEquipement; i++) {

					if(equipements[i]!=null) {
						switch (equipements[i])
							{
							case BOUCLIER:
								resistanceEquipement+=8;
								break;
							
							case CASQUE: 
								resistanceEquipement+=5;
								break;
							
							default: 
								break;
							}	
						}
					}
					texte += resistanceEquipement + "!";
				}
				parler(texte);
				forceCoup -= resistanceEquipement;
				return forceCoup;
			} 
	 
	 
	 
	 private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'equipement de " + nom + "s envole sous la force du coup.");
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null) {
					equipementEjecte[nbEquipementEjecte] =equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
					}
				}
				return equipementEjecte;
			}
	
	
	 public int getForce() {
			return force;
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
