package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.ManageableTeam;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;
/**
 * This abstract class represents abstract football team.
 * It consists of   methods and 
 * variables  common for every team. Includes methods 
 * for getting name and formation and setting name, and 
 * for manipulating with players. It implements inetraface ManageableTeam.
 * 
 * @author Jurij Kos
 *
 */
public abstract class Team implements ManageableTeam {
	/**The value is used for storing team name.*/
	private String name;
	/**It keeps teams formation.*/
	private Formation formation;
	/**It is reference to acollection of all registred players in team.*/
	protected SimpleFootballPlayerCollection registredPlayers;
	/**Reference to startin eleven of a team.*/
	private SimpleFootballPlayerCollection startingEleven = new 
			SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);
	
	/**
	 * This constructor initializes name and formation of a team.
	 * @param name Must be string. If you send null reference it 
	 * will be automatically set to DEFAULT_TEAM_NAME and error will be written to System.error.
	 * @param formation Type of team `s formation. Possible are F442 F352 F541. If you send something 
	 * different it will send message to System.error and set to F442. 
	 */
	public Team(String name, Formation formation){
		if (name != null)
			this.name = name;
		else
			this.name = Constants.DEFAULT_TEAM_NAME;
		for (Formation allforms : Formation.values()){
			if (allforms == formation)
				this.formation = formation;
		}
		if (this.formation == null)
			this.formation = Constants.DEFAULT_FORMATION;
	}
	/** 
	 *Returns team name.
	 */
	public String getName() {
		return name;
	}


	@Override
	public Formation getFormation() {
		return formation;
	}

	@Override
	public boolean isPlayerRegistered(FootballPlayer player) {
		if (this.registredPlayers.contains(player))
			return true;
		else 
			return false;
	}
	
	@Override
	public boolean addPlayerToStartingEleven(FootballPlayer player) {
		if (startingEleven.size() >= Constants.STARTING_ELEVEN_SIZE)
			return false;
		if (this.startingEleven.contains(player))
			return false;
		startingEleven.add(player);
		return true;
	}
	@Override
	public SimpleFootballPlayerCollection getRegisteredPlayers() {
		
		return registredPlayers;
	}
	@Override
	public SimpleFootballPlayerCollection getStartingEleven() {
		return startingEleven;
	}
	
	@Override
	public void setFormation(Formation formation) {
		switch (formation) {
		case F352:
			this.formation = formation;
			break;
		case F442:
			this.formation = formation;
			break;
		case F541:
			this.formation = formation;
			break;
		default:
			System.err.println("You send wrong argument for formation");
			break;
		}
		
		
	}
	
	@Override
	public void clearStartingEleven() {
		startingEleven.clear();
	}
}
