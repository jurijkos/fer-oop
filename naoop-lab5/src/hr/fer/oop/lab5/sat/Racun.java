package hr.fer.oop.lab5.sat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashSet;



public class Racun implements Comparable<Racun> {
	private int brRacuna;
	public Collection<Stavka> kolekcijaStavki;
	
	public Racun(int brRacuna) {
		this.brRacuna = brRacuna;
		kolekcijaStavki = new HashSet<>();
	}
	public Double ukupniIznos() {
		double ukupniIznos = 0;
		for (Stavka stavka : kolekcijaStavki) {
			ukupniIznos += stavka.getCijena()* stavka.getBrKomada();
		}
		return ukupniIznos;
	}
	public int getBrRacuna() {
		return brRacuna;
	}
	public void setBrRacuna(int brRacuna) {
		this.brRacuna = brRacuna;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Racun racun = (Racun) obj;
		return racun.getBrRacuna() == this.getBrRacuna();
	}
	@Override
	public int hashCode() {
		Integer integer = this.brRacuna;
		return integer.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		NumberFormat formatter = new DecimalFormat("#0.00");     
		//System.out.println(formatter.format(4.0));
		return this.getBrRacuna() + " " + formatter.format(this.ukupniIznos());
	}

	@Override
	public int compareTo(Racun o) {
		return (int)(100 * (o.ukupniIznos() - this.ukupniIznos()));
	}

}
