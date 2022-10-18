package personnages;


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
 
 public Gaulois trouverHabitant(int numVillageois) {
	 return villageois[numVillageois];
 }
 
 public void afficherVillageois() {
	 System.out.println("Dans le " + this.nom + " du chef " + this.chef.getNom() + " vivent les légendaires Gaulois : ");
	 for(int i = 0; i<this.nbVillageois; i++) {
		 System.out.println("- " + this.trouverHabitant(i).getNom());
	 }
 }
 
 public String getNom() { 
	 return nom; 
 } 
 
 
 public static void main(String[] args) {
	 Village test = new Village("Village des Irréductibles",30);
	 Chef abraracourcix = new Chef("Abraracourcix",6,test);
	 test.setChef(abraracourcix);
	 Gaulois asterix = new Gaulois("Asterix",8);	
	 Gaulois obelix = new Gaulois("Obélix", 25);
	 test.ajouterHabitant(asterix);
	 test.ajouterHabitant(obelix);
	 test.afficherVillageois();
	 
	 
	 
	 
	 
	 //Gaulois gaulois = test.trouverHabitant(30); 
	 // erreur car habitant sont de 0 à 29 donc 30 est hors du tableau
	 //Gaulois gaulois = test.trouverHabitant(1); 
	 //System.out.println(gaulois);
	 // renvoie null dans le cas demandé car on avait pas encore ajouté de gaulois au village
	 
	
}
 }

 