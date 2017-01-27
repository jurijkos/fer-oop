package primjeri.zadaci;
import java.util.function.Predicate;
public class NekaKlasa   {
	public int x;
	public String name;
	public NekaKlasa(int x, String name) {
		this. x = x;
		this.name = name;
	}
	
	public int compareTo(NekaKlasa o) {
		if (this.x < o.x)
			return -1;
		else if(this.x == o.x)
			return 0;
		return 1;
			
	}
	
}
	
