import personnages.*;

 public class Village {
	 
	 private String nom; 
	 private Chef chef; 
	 private int nbVillageois = 0;
	 private Gaulois[] villageois;
	 private int nbVillageoisMaximum;
	 
 public Village(String nom, int nbVillageoisMaximum) { 
	 this.nom = nom; 
	 this.nbVillageoisMaximum = nbVillageoisMaximum;
	 this.villageois = new Gaulois[nbVillageoisMaximum];
 } 
 
 public void setChef(Chef chef) { 
	 this.chef = chef; 
 } 
 
 public void ajouterHabitant(Gaulois gaulois) {
	 if (nbVillageois < nbVillageoisMaximum) {
		 villageois[nbVillageois] = gaulois;
		 nbVillageois++;
	 }
 }
 
 public void trouverHabitant(int numVillageois) {
	 
 }
 
 public String getNom() { 
	 return nom; 
 } 
 
 }
