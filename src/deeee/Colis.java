package deeee;

import deeee.Util;

public class Colis {
	private int longueur; //en cm
	private int largeur; // en cm
	private int profondeur; // en cm
	private int poids; // en g
	private int typeRecommande; // de 0 à 5
	
	public Colis(int lo, int la, int pro, int po, int type)
	{
		longueur = lo;
		largeur = la;
		profondeur = pro;
		poids = po;
		typeRecommande = type;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getTypeRecommande() {
		return typeRecommande;
	}

	public void setTypeRecommande(int typeRecommande) {
		this.typeRecommande = typeRecommande;
	}
	
	public int volume()
	{
		return (longueur * largeur * profondeur);
	}
	
	public int densite()
	{
		int calc = (longueur * largeur * profondeur)/5000;
		return calc;
	}
	
	public boolean estValide()
	{
		boolean valid = false;
		if(poids > 20000 || longueur > Util.longueurMax || (longueur + largeur + profondeur) > Util.sommeDesLongMax)
		{
			valid = false;
		}
		else
		{
			valid = true;
		}
		return valid;
	}
	
	public double coutAffranchissement()
	{
		double result = 0;
		if(estValide() == true)
		{
			if(typeRecommande == 0)
			{
				result = Util.calc_PrixBase2(getPoids());
			}
			else
			{
				if(typeRecommande < 6)
				{
					result = Util.calc_Prix2(poids, typeRecommande);
				}
				else
				{
					result = 0;
				}
			}
		}
		else
		{
			result = 0;
		}
		return result;
	}
}
