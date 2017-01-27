package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;

/**
 * Class implements football clubteam. It extends team because 
 * every clubteam is team. 
 * @author Jurij Kos
 *
 */
public class ClubTeam extends Team {
	private int reputation;
	private final double MIN_RATING = 0;
	
	public ClubTeam (String name, Formation formation, int reputation) {
		super(name, formation);
		if (reputation <= Constants.MAX_REPUTATION && reputation >= Constants.MIN_REPUTATION)
			this.reputation = reputation;
		else 
			this.reputation = Constants.DEFAULT_REPUTATION;
		registredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
		
	}
	
	public ClubTeam () {
		super(Constants.DEFAULT_TEAM_NAME, Constants.DEFAULT_FORMATION);
		this.reputation = Constants.DEFAULT_REPUTATION;
		registredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_CLUB);
	}
	/**
	 * Returns a value of team reputation.
	 * @return
	 */
	public int getReputation() {
		return reputation;
	}
	/**
	 * It sets reputation of team to reputation.
	 * @param reputation It must be in in range 0-100.
	 */
	public void setReputation(int reputation) {
		if (reputation <= Constants.MAX_REPUTATION && reputation >= Constants.MIN_REPUTATION)
			this.reputation = reputation;
		else
			System.err.println("Argument koji ste poslali nije u intervalu 0-100");
	}
	
	@Override
	public boolean registerPlayer(FootballPlayer player) {
		if (player == null){
			System.err.println("You send null pointer instead of a player");
			return false;
		}
		else if (player.getPlayingSkill() < this.reputation) {
			System.err.println("Igrac je ispod potrebne timske reputacije");
			return false;
		}
		else if (this.getRegisteredPlayers().size() >= 
				this.getRegisteredPlayers().getMaxSize()){
			System.err.println("There is no enough place for this player.");
			return false;
		}
		else if (this.isPlayerRegistered(player)){
			System.err.println("This player is already registred.");
			return false;
		}
		this.getRegisteredPlayers().add(player);
		return true;
		
	}
	
	@Override
	public double calculateRating () {
		double ratingSum = MIN_RATING;
		for (FootballPlayer player : this.getRegisteredPlayers().getPlayers()) {
			if (player == null) 
				return ratingSum;
			ratingSum += player.getEmotion() * Constants.THIRTY_PERCENT + 
					player.getPlayingSkill() * Constants.SEVENTY_PERCENT;
		}
		return ratingSum;
	}
				

}
