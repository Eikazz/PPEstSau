package vinson;

import java.util.Random;

//Classe qui va nous permettre de générer le nombre Aléatoire compris entre 1 et 1 000 000

public class NombreAlea {
	private int lenombrealea;
	private Random r = new Random();

	
	public NombreAlea(){
		
		this.lenombrealea=r.nextInt(999999)+1 ;
	}
	
	public int getNombreAlea(){
		return this.lenombrealea;
	}
	
	public void ChangeAlea(){
		this.lenombrealea=r.nextInt(999999)+1;
	}
}
