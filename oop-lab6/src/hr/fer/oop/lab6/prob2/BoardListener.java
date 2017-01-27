package hr.fer.oop.lab6.prob2;
/**
 * Class that implements this interface do some action
 * when board is changed.
 * @author Jurij Kos
 *
 */
public interface BoardListener {
	/**
	 * 
	 * Function called when change on board happens.
	 */
	void boardChanged(Board board);
}
