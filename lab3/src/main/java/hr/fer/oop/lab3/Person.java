package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
/**
 * The class represents one person with basic informations name, country
 * and emotions. 
 * @author Jurij Kos
 *
 */
public abstract class Person {
	/**The value is used for player name.*/
	private String name;
	/**The value is used for player country.*/
	private String country;
	/**Current emotion of player.*/
	private int emotion;
	/**Initializes new object to default values.*/
	public Person() {
		// TODO Auto-generated constructor stub
		this.name = Constants.DEFAULT_PLAYER_NAME;
		this.country = Constants.DEFAULT_COUNTRY;
		this.emotion = Constants.DEFAULT_EMOTION;
	}
	/**Initializes new object with wanted values.*/
	public Person(String name, String country, int emotion){
		if (name != null)
			this.name = name;
		else 
			this.name = Constants.DEFAULT_PLAYER_NAME;
		
		if (country != null)
			this.country = country;
		else 
			this.country = Constants.DEFAULT_COUNTRY;
		
		if (emotion <= Constants.MAX_EMOTION && emotion >= Constants.MIN_EMOTION)
			this.emotion = emotion;
		else 
			this.emotion = Constants.DEFAULT_EMOTION;
	}
	/**Setter for emotion.*/
	public void setEmotion(int emotion) {
		if (emotion >= Constants.MIN_EMOTION && emotion <= Constants.MAX_EMOTION)
			this.emotion = emotion;
	}
	/**
	 * Getter for name of a person
	 * @return person s name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Get country of a person.
	 * @return person s country.
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Get emotion of player. 
	 * @return players emotion.
	 */
	public int getEmotion() {
		return emotion;
	}
	/**
	 * Hash code returns hash value for this object. Hash value is differnt for every object
	 */
	@Override
	public int hashCode(){
		return name.hashCode() + country.hashCode();

	}
	/**
	 * Two persons are equal if they have same name and are from same country.
	 */
	@Override
	public boolean equals(Object obj){
		Person drugi = (Person) obj;
		if (drugi == null || this == null){
			
			return false;
		}
		else if (this.name.equals(drugi.name) && 
				this.country.equals(drugi.country)){
			return true;
		}
		else return false;
	}
	
}
