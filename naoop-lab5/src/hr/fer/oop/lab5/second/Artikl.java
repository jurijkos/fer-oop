package hr.fer.oop.lab5.second;


/**
 * Class represents Artikl in our store.
 * @author Jurij Kos
 *
 */
public class Artikl implements Comparable<Artikl> {
	/**Name of the artikl.*/
	private  String naziv;
	/**Price of the arikl.*/
	private double cijena;
	public Artikl(String naziv, double cijena) {
		this.naziv = naziv;
		this.cijena = cijena;
	}
	/**
	 * 
	 * @return price of artikl
	 */
	public double getCijena() {
		return cijena;
	}
	/**
	 * 
	 * @return name of artikl.
	 */
	public String getNaziv() {
		return naziv;
	}
	@Override
	public boolean equals(Object obj) {
		Artikl artikl = (Artikl) obj;
		return artikl.getNaziv() == this.naziv;
	}
	@Override
	public int hashCode() {
		return naziv.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return naziv + Double.toString(Double.valueOf(cijena)) + "\n";
	}
	@Override
	public int compareTo(Artikl o) {
		return this.naziv.compareTo(o.naziv);
	}

}
