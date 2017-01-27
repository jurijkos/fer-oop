package hr.fer.oop.lab3.welcomepack;

import hr.fer.oop.lab3.FootballPlayer;
import hr.fer.oop.lab3.SimpleFootballPlayerCollectionImpl;

public class LabosTest {
	public static void main(String[] args) {

		final int TEST_MAX_SIZE = 20;
		SimpleFootballPlayerCollectionImpl collection = new SimpleFootballPlayerCollectionImpl(TEST_MAX_SIZE);
		for (int i = 0; i < 10; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 1, 1, PlayingPosition.GK);
				collection.add(sequentialPlayer);
		}
		System.out.println(collection.size());
		FootballPlayer[] novi_playeri = new FootballPlayer[5];
		for (int i = 0; i < 5; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("NAME" + i, "", 1, 1, PlayingPosition.MF);
				novi_playeri[i] = sequentialPlayer;
		}
		collection.addAll(novi_playeri);
		System.out.println(collection.size());
		
		
		SimpleFootballPlayerCollectionImpl collection2 = new SimpleFootballPlayerCollectionImpl(TEST_MAX_SIZE);
		for (int i = 0; i < 10; i++) {
			FootballPlayer sequentialPlayer = new FootballPlayer("ime" + i, "", 1, 1, PlayingPosition.GK);
				collection2.add(sequentialPlayer);
		}
		collection.addAll(collection2);
		System.out.println(collection.size());
		//ignore printed system errors displayed from another classes, as described in instructions.
		System.out.println("This is only valid message that should be displayed from this main!!!!");
	}
}
