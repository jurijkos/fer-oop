package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;

import hr.fer.oop.lab3.welcomepack.Formation;
import hr.fer.oop.lab3.welcomepack.ManageableTeam;
import hr.fer.oop.lab3.welcomepack.Manager;
/**
 * Class represents coach of a football team. It inherits Person
 * and implements Manager so he knows how to manage team. 
 * @author Jurij Kos
 *
 */

public class Coach extends Person implements Manager {
	/** Value representing skill of coach in interval 0-100. Bigger value-better caoach.*/
	private int coachingSkill;
	/** His favorite formation. It could be 4-4-2 3-5-2 or 5-4-1.*/
	private Formation favoriteFormation;
	
	private ManageableTeam managingTeam;
	
	/**
	 * Constructor for creating object with wanted values.
	 * @param emotion It must be from 0-100 or it will be set to 50 automatically.
	 * @param coachingSkill It must be from 0-100 or it will be set to 50 automatically.
	 * @param favoriteFormation Chose one of the following 5-4-1 4-4-2 and 3-5-2 or it will be 
	 * 4-4-2
	 */
	public Coach(String name, String country, 
			int emotion, int coachingSkill, Formation favoriteFormation) {
		super(name, country, emotion);
		// TODO Auto-generated constructor stub
		if (coachingSkill <= Constants.MAX_COACHING_SKILL && 
				coachingSkill >= Constants.MIN_COACHING_SKILL)
			this.coachingSkill = coachingSkill;
		else {
			this.coachingSkill = Constants.DEFAULT_COACHING_SKILL;
			System.err.println("You send value out of range for coach skill.It was automatically set to 50.");
		}
		switch (favoriteFormation) {
			case F352:
				this.favoriteFormation = favoriteFormation;
				break;
			case F541:
				this.favoriteFormation = favoriteFormation;
				break;
			default:
				this.favoriteFormation = Constants.DEFAULT_FORMATION;
				System.err.println("Sent wrong information about favorite formation. Set to 4-4-2.");
				break;
		}
	}
	/**
	 * This constructors put variables of object to default values. Default values
	 * are 50 for emotion and coaching skill 4-4-2 for formation, Noland for country and 
	 * Jon Doe for name. Name and country couldnt be changed after you created object.
	 */
	public Coach() {
		// TODO Auto-generated constructor stub
		super();
		coachingSkill = Constants.DEFAULT_COACHING_SKILL;
		favoriteFormation = Constants.DEFAULT_FORMATION;
	}
	/**
	 * Returning skill of a coach
	 * @return skill Int in range 0-100. Better player has higher 
	 * skill.
	 */
	public int getCoachingSkill() {
		return coachingSkill;
	}
	
	/**
	 * Set value of  a coach. If you send impossible value function doesn t make any changes.
	 * @param coachingSkill 0-100 Bigger value means better coach.
	 */
	public void setCoachingSkill(int coachingSkill) {
		if (coachingSkill <= Constants.MAX_COACHING_SKILL && 
				coachingSkill >= Constants.MIN_COACHING_SKILL)
			this.coachingSkill = coachingSkill;
		else 
			System.err.println("Sent value out of range for coaching skill");
	}
	/**
	 * 
	 * @return Coach s favorite formation.
	 */
	public Formation getFavoriteFormation() {
		return favoriteFormation;
	}
	/**
	 * If parameter favoriteFormation is not one of possible method doesn t make any changes.
	 * @param favoriteFormation Possible formations are F352 F541 and F442
	 */
	public void setFavoriteFormation(Formation favoriteFormation) {
		switch (favoriteFormation) {
		case F352:
			this.favoriteFormation = favoriteFormation;
			break;
		case F541:
			this.favoriteFormation = favoriteFormation;
			break;
		case F442:
			this.favoriteFormation = favoriteFormation;
			break;
		default:
			System.err.println("Formation out of range.");
	}
	}
	/** getter for managing team*/
	public ManageableTeam getManagingTeam() {
		return managingTeam;
	}
	@Override
	public void setManagingTeam(ManageableTeam managingTeam) {
		if (managingTeam ==null)
			System.err.println("You send null pointer for managin team.");
		else
			this.managingTeam = managingTeam;
	}

	@Override
	public void pickStartingEleven(){
		this.managingTeam.getStartingEleven().clear(); // it moves all players form starting eleven
		//so coach can make new starting eleven.
	    Formation formation = this.managingTeam.getFormation();
	    int goalkeeper=formation.getNoGK();
	    int defender=formation.getNoDF();
	    int midfielder=formation.getNoMF();
	    int striker=formation.getNoFW();
	    selectionSortDownside();
	    for( FootballPlayer other: this.managingTeam.getRegisteredPlayers().getPlayers()){
	    	if (other == null || 
	    			this.managingTeam.getStartingEleven().size() > Constants.STARTING_ELEVEN_SIZE)
	    		break;
	    	switch (other.getPlayingPosition()) {
	        case FW: 
	        	if (striker > 0) {
	        		managingTeam.addPlayerToStartingEleven(other);
	        		striker--;
	        	}
	        	break;
	        case MF: 
	        	if(midfielder > 0) {
	        		managingTeam.addPlayerToStartingEleven(other);
	                midfielder--;
	        	}
	            break;
	        case DF: 
	        	if(defender > 0) {
	        		managingTeam.addPlayerToStartingEleven(other);
	        		defender--;
	            }
	            break;
	        case GK: 
	        	if(goalkeeper > 0) {
	        		managingTeam.addPlayerToStartingEleven(other);
	        		goalkeeper--;
	            }
	            break;
	              
	    	}
	    }
	    for( FootballPlayer other: managingTeam.getRegisteredPlayers().getPlayers()){
	    	if (managingTeam.getStartingEleven().size() < Constants.STARTING_ELEVEN_SIZE 
	    			&& managingTeam.getStartingEleven().size() < managingTeam.getRegisteredPlayers().size()){
	    		managingTeam.addPlayerToStartingEleven(other);
	    	}
	    	else 
	    		break;
	    }
	}
	@Override
	public void forceMyFormation(){
		if (this.managingTeam == null) 
			System.err.println("This coach does not manage any team.");
		else
			this.managingTeam.setFormation(this.favoriteFormation);
	}
	/**
	 * It sorts player from highest skill to lowest.
	 */
	private void selectionSortDownside () {
		FootballPlayer[] player = managingTeam.getRegisteredPlayers().getPlayers();
		for (int i = 0; i < managingTeam.getRegisteredPlayers().size(); i++){
			int bestPlayer = i;
			for (int j = i + 1; j < managingTeam.getRegisteredPlayers().size(); j++){
				if (player[j].getPlayingSkill() > player[bestPlayer].getPlayingSkill())
					bestPlayer = j;
			}
			FootballPlayer swapPlayer = player[bestPlayer];
			player[bestPlayer] = player[i];
			player[i] =swapPlayer;
		}
	}

}
