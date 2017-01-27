package zi2016.treci;
import java.util.LinkedList;
import java.util.List;

public class DBLoader {
    public static List<Scientist> loadScientists() {
        List<Scientist> result = new LinkedList<>();
        
        result.add(new Scientist("Mislav", "Grgić", 223272L, 17, 11, 1973));
        result.add(new Scientist("Ivan", "Ivić", 874234L, 1, 4, 1986));
        result.add(new Scientist("Pero", "Perić", 559434L, 12, 1, 1978));
        result.add(new Scientist("Krešimir", "Pripužić", 267692L, 18, 3, 1980));
        result.add(new Scientist("Ana", "Anić", 948534L, 5, 11, 1962));
        result.add(new Scientist("Marija", "Marijić", 138292L, 21, 12, 1953));
        result.add(new Scientist("Petra", "Petrović", 132982L, 16, 7, 1972));
        result.add(new Scientist("Mijo", "Mijić", 843943L, 13, 6, 1989));
        
        return result;
    }
}