package hr.fer.oop.lab3.welcomepack;

import hr.fer.oop.lab3.FootballPlayer;

public interface BatchFootballPlayer extends SimpleFootballPlayerCollection {
	/**
	 * Adds players from array to the collection. Player can be added
	 * if there is enough place and if he is already not added.
	 * 
	 * 
	 * @return true if at least one change happend,false if changes didn t happen. 
	 */
	public boolean addAll (FootballPlayer[] players);
	/**
	 * Adds all players from collection in our collection.
	 * Player can be added if he is already not added and if there is enough space for him.
	 * 
	 * @return true if at least on change happend 
	 * false if not any change . 
	 */
	public boolean addAll (SimpleFootballPlayerCollection collection);
		
	
}
