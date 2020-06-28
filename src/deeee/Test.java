package deeee;

public class Test {

	public static void main(String[] args) {
		Util util = new Util();
		util.initTarifs();
		Colis colis = new Colis(50,50,50,19999,0);
		Colis colis2 = new Colis(140,160,150,1001,1);
		System.out.println("Volume du Colis 1 = " + colis.volume() + " cm3");
		System.out.println("Dénsité du Colis 1 = " + colis.densite());
		System.out.println("Le prix de l'affranchissement du Colis 1 = " + colis.coutAffranchissement() + " €");
		System.out.println("Volume du Colis 2 = " + colis2.volume() + " cm3");
		System.out.println("Dénsité du Colis 2 = " + colis2.densite());
		System.out.println("Le prix de l'affranchissement du Colis 2 = " + colis2.coutAffranchissement() + " €");
	}

}
