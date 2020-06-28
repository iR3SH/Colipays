package deeee;

import java.util.*;

import deeee.TarifColis;

public class Util {
	private static List<TarifColis> lesTarif;
	private static List<Double> lesRecommandes= new ArrayList<Double>();
	private static Hashtable<Integer, Double> dicoTarifs = new Hashtable<Integer, Double>();
	private static Hashtable<Integer, Double> dicoSupplement = new Hashtable<Integer, Double>();
	public static final int longueurMax = 1000;
	public static final int sommeDesLongMax = 1500;
	
	public void initTarifs()
	{
		lesTarif = new ArrayList<TarifColis>();
		dicoTarifs.put(250, 5.50);
		dicoTarifs.put(500, 6.10);
		dicoTarifs.put(750, 6.90);
		dicoTarifs.put(1000, 7.50);
		dicoTarifs.put(2000, 8.50);
		dicoTarifs.put(3000, 9.70);
		dicoTarifs.put(5000, 11.90);
		dicoTarifs.put(7000, 14.10);
		dicoTarifs.put(10000, 17.40);
		dicoTarifs.put(15000, 20.15);
		dicoTarifs.put(20000, 28.35);
		dicoSupplement.put(1, 2.50);
		dicoSupplement.put(2, 3.40);
		dicoSupplement.put(3, 4.60);
		dicoSupplement.put(4, 5.80);
		dicoSupplement.put(5, 7.00);
		/*TarifColis TC = new TarifColis(250, 5.50);
		TarifColis TC2 = new TarifColis(500, 6.10);
		TarifColis TC3 = new TarifColis(750, 6.90);
		TarifColis TC4 = new TarifColis(1000, 7.50);
		TarifColis TC5 = new TarifColis(2000, 8.50);
		TarifColis TC6 = new TarifColis(3000, 9.70);
		TarifColis TC7 = new TarifColis(5000, 11.90);
		TarifColis TC8 = new TarifColis(7000, 14.10);
		TarifColis TC9 = new TarifColis(10000, 17.40);
		TarifColis TC10 = new TarifColis(15000, 20.15);
		TarifColis TC11 = new TarifColis(20000, 28.35);
		util.ajouteTarif(TC);
		util.ajouteTarif(TC2);
		util.ajouteTarif(TC3);
		util.ajouteTarif(TC4);
		util.ajouteTarif(TC5);
		util.ajouteTarif(TC6);
		util.ajouteTarif(TC7);
		util.ajouteTarif(TC8);
		util.ajouteTarif(TC9);
		util.ajouteTarif(TC10);
		util.ajouteTarif(TC11);
		util.ajouteRecom(2.50);
		util.ajouteRecom(3.40);
		util.ajouteRecom(4.60);
		util.ajouteRecom(5.80);
		util.ajouteRecom(7);*/
	}
	
	public static Double calc_PrixBase2(int poids)
	{
		double poid = 0; // Variable Double
		int i = 250;
		if(poids != 20000) // Exception si le poids est égale à 20Kg
		{
			while(poids >= i || dicoTarifs.get(i) == null) // Tant que le résultat est égal à rien on continue de chercher
			{
				i += 250;
			}
			poid = dicoTarifs.get(i); //Récupère la valeur Double en fonction du poids
		}
		else
		{
			poid = dicoTarifs.get(poids);
		}
		return poid; // Retourne la valeur Double selon le poids
	}
	public static Double calc_Prix2(int poids, int typeRecommande)
	{
		double poid = 0; // Variable Double
		int i = 250;

		if(poids != 20000) // Exception si le poids est égale à 20Kg
		{
			while(poids >= i || dicoTarifs.get(i) == null) // Tant que le résultat est égal à rien on continue de chercher
			{
				i += 250;
			}
			poid = dicoTarifs.get(i); //Récupère la valeur Double en fonction du poids
		}
		else
		{
			poid = dicoTarifs.get(poids);
		}
		poid += dicoSupplement.get(typeRecommande); // Ajoute la valeur Double à la variable en fonction du Type de Recomandé
		return poid; // Retourne la valeur Double final
	}
	
	public void ajouteTarif(TarifColis TC)
	{
		lesTarif.add(TC);
	}
	
	public void ajouteRecom(double type)
	{
		lesRecommandes.add(type);
	}
	
	public static double calcPrixBase(int poidsEnGr)
	{
		double result = 0;
		for(int i = 0; i < lesTarif.size(); i++)
		{
			for(int h = 0; h < lesTarif.size(); h++)
			{
				if(lesTarif.get(i).getPoidsMax() > poidsEnGr && poidsEnGr <= lesTarif.get(h).getPoidsMax())
				{
					int index = 0;
					if(h != 0)
					{
						index = h-1;
					}
					result = lesTarif.get(index).getPrix();
					i = lesTarif.size();
					h = lesTarif.size();
				}
			}
		}
		
		return result;
	}
	
	public static double calcPrix(int poidsEnGr, int typeRecommande)
	{
		double result = 0;
		for(int i = 0; i < lesTarif.size(); i++)
		{
			for(int h = 0; h < lesTarif.size(); h++)
			{
				if(lesTarif.get(i).getPoidsMax() > poidsEnGr && poidsEnGr <= lesTarif.get(h).getPoidsMax())
				{
					int index = 0;
					if(h != 0)
					{
						index = h-1;
					}
					result = lesTarif.get(index).getPrix();
					i = lesTarif.size();
					h = lesTarif.size();
				}
			}
		}
		result += lesRecommandes.get(typeRecommande - 1);
		return result;
	}
}
