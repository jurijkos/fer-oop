package hr.fer.oop.lab3.demo;



import hr.fer.oop.lab3.Coach;
import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.NationalTeam;
import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;

public class CoachTest {

	public static void main(String[] args) {

		Coach defaultCoach = new Coach();
		Coach mainCoach = new Coach("Main", Constants.DEFAULT_COUNTRY, 1, 1, Formation.F352);
		Coach helpCoach = new Coach();

		if (defaultCoach.equals(null)) {
			System.err.println("TEST FAILED: Coach is null");
		}
		
		
		if (mainCoach.equals(defaultCoach)) {
			System.err.println("TEST FAILED: Default and Main coach must be different");
		}
		helpCoach.setCoachingSkill(10);
		helpCoach.setEmotion(10);
		if (!defaultCoach.equals(helpCoach)) {
			System.err.println("TEST FAILED: Wrong comparison of coaches.");
		}
		
		
		Coach wrongCoach = new Coach(null, null, -5, 150, Formation.F541);
		if(wrongCoach.getName()==null || 
				wrongCoach.getCountry() == null || 
				wrongCoach.getEmotion() <0 ||
				wrongCoach.getCoachingSkill() > 100){
			System.err.println("TEST FAILED: Coach values must be in boundries!!");
		}
        
		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");
		
		//test part 2
		//for forceformation, set strating eleven.
		NationalTeam italia = new NationalTeam();
		Coach italiaCoach  = new Coach();
		italiaCoach.setFavoriteFormation(Formation.F541);
		italiaCoach.forceMyFormation(); // check if null pointer will break program.
		
		italiaCoach.setManagingTeam(italia);
		italiaCoach.forceMyFormation();
		if (italiaCoach.getFavoriteFormation() != italia.getFormation())
			System.err.println("TEST FAILED: Your coach does not force his favorite formation. ");
		//System.out.println(italia.getFormation());
		
		FootballPlayer gk = new FootballPlayer("Buffon", null, 50, 90, PlayingPosition.GK);
		FootballPlayer gk2 = new FootballPlayer("Buffon2", null, 50, 90, PlayingPosition.GK);
		italia.registerPlayer(gk);
		italia.registerPlayer(gk2);
		for (int i = 0; i < 5; i++) {
			FootballPlayer df = new FootballPlayer("stoper" + i, null ,60, 50 + 5 * i,PlayingPosition.DF);
			italia.registerPlayer(df);
			FootballPlayer mf = new FootballPlayer("vezni" + i, null ,60, 50 + 5 * i,PlayingPosition.MF);
			italia.registerPlayer(mf);
			//FootballPlayer st = new FootballPlayer("spica"+i, null ,60, 50 + 5*i,PlayingPosition.FW);
			//italia.registerPlayer(st); 
			//ovo je zakomentirano da vidimo dal radi kad u ekipi nema dovoljan
			//broj nekog tipa igraca.
		}
		//ako je sve u redu
		italiaCoach.pickStartingEleven();
		for (FootballPlayer playerFromItaly : italia.getStartingEleven().getPlayers()) {
			System.out.println(playerFromItaly.getName());
			
		}
		
	}
}
