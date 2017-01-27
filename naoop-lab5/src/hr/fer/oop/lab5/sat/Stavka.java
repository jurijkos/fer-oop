package hr.fer.oop.lab5.sat;

import hr.fer.oop.lab5.second.Artikl;

public class Stavka extends Artikl {
	private int brKomada;
	
	
	
	public Stavka(String naziv, double cijena, int brKomada) {
		super(naziv, cijena);
		// TODO Auto-generated constructor stub
		this.brKomada = brKomada;
	}
	
	
	public int getBrKomada() {
		return brKomada;
	}
}
