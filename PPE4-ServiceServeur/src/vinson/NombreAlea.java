package vinson;

import java.util.Random;

public class NombreAlea {
	private int lenombrealea;
	private Random r = new Random();
	
	public NombreAlea(){
		
		this.lenombrealea=r.nextInt(1000000)+1 ;
	}
	
	public int getNombreAlea(){
		return this.lenombrealea;
	}
	
	public void ChangeAlea(){
		this.lenombrealea=r.nextInt(1000000)+1;
	}
}
