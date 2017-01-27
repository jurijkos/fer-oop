package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.Formation;

/**
 * Class represents  national football team. It extends abstract class team representing 
 * any kind of football team. 
 * @author jurij
 *
 */

public class NationalTeam extends Team {
	/**Country of NationalTean.*/
	private String country;
	/**Minimal possible rating is stored in this variable/*/
	private final double MIN_RATING = 0;
	
	/**
	 * Initializes newly created object.
	 * @param name It must be string. If null is send it will be set to default value
	 * @param formation Formation of a team. F442,352 and 541 all possibilites.
	 * 
	 */
	public NationalTeam (String name , Formation formation, String country) {
		super(name, formation);
		if (country != null)
			this.country = country;
		else 
			this.country = Constants.DEFAULT_COUNTRY;
		registredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_NATIONAL);
			
	}
	/**
	 * Initializes newly created object to default values.
	 */
	public NationalTeam () {
		super(Constants.DEFAULT_TEAM_NAME, Constants.DEFAULT_FORMATION);
		this.country = Constants.DEFAULT_COUNTRY;
		registredPlayers = new SimpleFootballPlayerCollectionImpl(Constants.MAX_NO_PLAYERS_NATIONAL);
	}
	
	public String getCountry () {
		return country;
	}
	
	@Override
	public boolean registerPlayer (FootballPlayer player) {
		if (!player.getCountry().equals(this.country))
			return false;
		else if (this.getRegisteredPlayers().size() >= 
				this.getRegisteredPlayers().getMaxSize())
			return false;
		else if (this.isPlayerRegistered(player))
			return false;
		this.getRegisteredPlayers().add(player);
		return true;

	}
	
	@Override
	public double calculateRating () {
		double ratingSum = MIN_RATING;
		for (FootballPlayer player : this.getRegisteredPlayers().getPlayers()) {
			if (player == null) 
				return ratingSum;
			ratingSum += player.getEmotion() * Constants.SEVENTY_PERCENT + 
					player.getPlayingSkill() * Constants.THIRTY_PERCENT;
		}
		return ratingSum;
	}
}
