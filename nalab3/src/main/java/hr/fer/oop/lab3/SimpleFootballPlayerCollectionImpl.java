package hr.fer.oop.lab3;


import hr.fer.oop.lab3.welcomepack.BatchFootballPlayer;
import hr.fer.oop.lab3.welcomepack.SimpleFootballPlayerCollection;

/**
 * This class represents collection of players.
 * Collection size can be in range 0-25.
 * 
 * @author Jurij Kos
 *
 */
public class SimpleFootballPlayerCollectionImpl implements BatchFootballPlayer {
	/**Maximum size collection*/
	private final int MAX_SIZE;
	/**Maximum possible size of collection */
	private final int MAX_PLAYERS_NUM = 25;
	/**Collection of football players, array.*/
	private FootballPlayer[] players;
	/**It stores current size of team.*/
	private int size;
	/**Minimum size of team.*/
	private final int MIN_SIZE = 0;
	/**Constant for starting  emotion sum if team.*/
	private final int MIN_EMOTION_SUM = 0;
	/**Constant storing starting sum  of team s skill. */
	private final int MIN_SKILL_SUM = 0;
	
	/**
	 * Initializes newly created object so that it represnts empty collerction of players  
	 * that can be added up to a MAX_SIZE players. 
	 * @param MAX_SIZE The maximum size that team can have.It is not possible to change 
	 * these.
	 */
	public SimpleFootballPlayerCollectionImpl(int MAX_SIZE) {
		// TODO Auto-generated constructor stub
		if (MAX_SIZE <= MAX_PLAYERS_NUM && MAX_SIZE > MIN_SIZE)
			this.MAX_SIZE = MAX_SIZE;
		else 
			this.MAX_SIZE = 0;
		players = new FootballPlayer[MAX_SIZE];
		
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean contains(FootballPlayer player) {
		for (FootballPlayer footballPlayer : players) {
			if (footballPlayer == null) 
				return false;
			else if (footballPlayer.equals(player))
				return true;
		}
		return false;
		
	}

	@Override
	public boolean add(FootballPlayer player) {
		if (size >= MAX_SIZE)
			return false;
		int i = 0;
		for (FootballPlayer footballPlayer : players) {
			if (footballPlayer == null){
				players[i] = player;
				size++;
				return true;
			}
			else if (footballPlayer.equals(player))
				return false;
			i++;
		}
		return false;
	}

	@Override
	public void clear() {
		for(FootballPlayer footballPlayer : players)
			footballPlayer = null;
		size = MIN_SIZE;
	}

	@Override
	public int getMaxSize() {
		return MAX_SIZE;
	}
	@Override
	public int calculateEmotionSum() {
		int emotionSum = MIN_EMOTION_SUM;
		for (FootballPlayer footballPlayer : players) {
			if (footballPlayer != null)
				emotionSum += footballPlayer.getEmotion();
		}
		return emotionSum;
	}

	@Override
	public int calculateSkillSum() {
		int skillSum = MIN_SKILL_SUM;
		for (FootballPlayer footballPlayer : players) {
			if (footballPlayer != null)
				skillSum += footballPlayer.getPlayingSkill();
		}
		return skillSum;
	}

	@Override
	public FootballPlayer[] getPlayers() {
		return players;
	}
	public boolean addAll(FootballPlayer[] players){
		boolean change = false;
		if (MAX_SIZE == size )
			return false;
		for (FootballPlayer footballPlayer : players) {
			if (footballPlayer != null && size <MAX_SIZE){
				add(footballPlayer);
				change = true;
			}
			else if (size >= MAX_SIZE)
				break;
		}
		return change;
	}
	public boolean addAll(SimpleFootballPlayerCollection collection){
		return addAll(collection.getPlayers());
		
	}
}
