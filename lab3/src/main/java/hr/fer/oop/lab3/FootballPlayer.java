package hr.fer.oop.lab3;


import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab3.welcomepack.PlayingPosition;
import hr.fer.oop.lab3.Person;;

/**
 * This class implements footbal player. Footbal player is person so it 
 * extends class Person.
 * @author Jurij Kos
 *
 */
public class FootballPlayer extends Person {
	/**Players skill could range from 0-100. Bigger value means it is better player.*/
	private int playingSkill;
	/**Can be GK, DF, MF, FW*/
	private PlayingPosition playingPosition;
	/**
	 * Creates object with default values. It is 50 for playingSkill and emotions. James Doe 
	 * for name, Noland for country, and MF for playing position
	 */
	public FootballPlayer() {
		// TODO Auto-generated constructor stub
		super();
		this.playingSkill = Constants.DEFAULT_PLAYING_SKILL;
		this.playingPosition = Constants.DEFAULT_PLAYING_POSITION;
	}
	/**
	 * It gives you possibility to set values of players when it is created
	 * @param emotion Should be in range 0-100 or it will automatically be 50
	 * @param playingSkill Should be in range 0-100 or it will automatically be 50
	 * @param playingPosition It should be GK, DF, MF or FW. Otherwise it will be set to MF
	 */
	public FootballPlayer(String name, String country, int emotion,
			int playingSkill, PlayingPosition  playingPosition){
		super(name, country, emotion);
		if (playingSkill <= Constants.MAX_PLAYING_SKILL && 
				playingSkill >= Constants.MIN_PLAYING_SKILL)
			this.playingSkill = playingSkill;
		else 
			this.playingSkill = Constants.DEFAULT_PLAYING_SKILL;
		
		for (PlayingPosition position : PlayingPosition.values()) {
			if (position == playingPosition) {
				this.playingPosition = playingPosition;
				break;
			}
		}
		if (this.playingPosition == null)
			this.playingPosition = Constants.DEFAULT_PLAYING_POSITION;
	}
	
	/**
	 * Give you information about playingSkill. Better player has higher playingSkill.
	 * @return integer in range 0-100.
	 */
	public int getPlayingSkill() {
		return playingSkill;
	}
	
	/**
	 * Sets playingSkill. Better player has higher playingSkill. If you send value out 
	 * of range method wont change anything. 
	 * @param playingSkill whole number 0-100
	 */
	public void setPlayingSkill(int playingSkill) {
		if (playingSkill <= Constants.MAX_PLAYING_SKILL && 
				playingSkill >= Constants.MIN_PLAYING_SKILL)
			this.playingSkill = playingSkill;
		else 
			System.err.println("You send playing skills out of range");
	}
	/**
	 * Function gets you playing position of a player.
	 * @return playing position GK, DF, MF, FW
	 */
	
	public PlayingPosition getPlayingPosition() {
		return playingPosition;
	}
	
	/**
	 * Set playing position. If it is not one of possible playing positions function will
	 * not change playing position 
	 * @param playingPosition
	 */
	public void setPlayingPosition(PlayingPosition playingPosition) {
		for (PlayingPosition position : PlayingPosition.values()) {
			if (playingPosition == position){
				this.playingPosition = playingPosition;
				return;
			}
		}
		System.err.println("You send non-existing playing position.");
		
	}

}
