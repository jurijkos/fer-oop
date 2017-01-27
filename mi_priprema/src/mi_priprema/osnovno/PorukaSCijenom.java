package mi_priprema.osnovno;

public class PorukaSCijenom extends Poruka{
	private double cijena;
	public PorukaSCijenom (String text, double cijena) {
		super(text);
		this.cijena = cijena;
	}
	public double getCijena() {
		return cijena;
	}
}
