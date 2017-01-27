package hr.fer.oop.lab6.prob2;

import java.util.ArrayList;

import java.util.List;

/**
 * This class implements board for Conway's Game of
 * Life. It has array of booleans. If cell state is true 
 * it means that cell is alive, otherwise is dead.
 * Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
 * Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
 * Any live cell with two or three live neighbours lives on to the next generation.
 * Any live cell with more than three live neighbours dies, as if by overpopulation.
 * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 * There is no and of board.It is connected over corners.
 * @author Jurij Kos
 *
 */
public class Board {
	/**Number of columns of cells. */
	private int width;
	/**Number of rows of cells.*/
	private int height;
	/**Set of cells. */
	private boolean [][]boardCells;//kasnije promjeni na private
	/**Buttons that represent cells triggers on these elements*/
	private List<BoardListener> listeners;
	
	/**
	 * Initalizes board
	 * 
	 */
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.boardCells = new boolean[height][width];
		this.listeners = new ArrayList<>();
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	/**
	 * Give us information if cell is alive.
	 * @param x - position on x-axis
	 * @param y - position on y-axis
	 * @return True if cell is alive,false if not.
	 */
	public boolean isCellAlive(int x, int y) {
		if (!(x > height || x < 0 || y > width || y < 0)) {
			if (boardCells[x][y]) {
				return true;
			}
			else {
				return false;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	/**
	 * Sets cell to new state. Could be alive or dead
	 * @param x x-axis position
	 * @param y y-axis position
	 * @param alive true makes cell alive, false dead.
	 */
	public void setCell(int x, int y, boolean alive) {
		if(x < height && x >= 0 && y < width && y >= 0)
			boardCells[x][y] = alive;
		else 
			throw new IndexOutOfBoundsException();
		
	}
	/**
	 * Neighbours are cells that are horizontally, 
	 * vertically, or diagonally adjacent. Every cell
	 * has eight neighbours. 
	 * @return number of alive neighbours
	 */
	public int countAliveNeighbours(int x, int y) {
		if(!(x < height && x >= 0 && y < width && y >= 0))
			throw new IndexOutOfBoundsException();
		int numberOfAlive = 0;
		//left upper
		if(boardCells[(x + height - 1) % height][(y + width - 1) % width])
			numberOfAlive++;
		if(boardCells[(x + height - 1) % height][y]) //upper in same colon
			numberOfAlive++;
		if(boardCells[(x + height - 1) % height][(y + width + 1) % width])
			numberOfAlive++;
		
		if(boardCells[x][(y + width - 1) % width])
			numberOfAlive++;
		if(boardCells[x][(y + width + 1) % width])
			numberOfAlive++;
		
		if(boardCells[(x + height + 1) % height][(y + width - 1) % width])
			numberOfAlive++;
		if(boardCells[(x + height + 1) % height][y])
			numberOfAlive++;
		if(boardCells[(x + height + 1) % height][(y + width + 1) % width])
			numberOfAlive++;
		
		
		return numberOfAlive;
	}
	/**
	 * This method makes one iteration through the game
	 * and updates all cells. After that it triggers all listeners. 
	 */
	public void playOneIteration(){
		boolean [][]field = new boolean[boardCells.length][boardCells[0].length];
		for (int i = 0; i < boardCells.length; i++) {
			for (int j = 0; j < boardCells[i].length; j++) {
				int neighboursNumber = countAliveNeighbours(i, j);
				if (isCellAlive(i, j)) {
					if (neighboursNumber == 2 || neighboursNumber == 3) {
						//setCell(i, j, true);
						field[i][j] = true;
					}
					else {
						field[i][j] = false;
					}
				}
				else {
					if (neighboursNumber == 3) {
						field[i][j] = true;
					}
					else {
						field[i][j] = false;
					}
				}
			}
		}

			boardCells = field.clone();
		
		for (BoardListener bl : listeners) {
			bl.boardChanged(this);
		}

	}
	/**
	 * Add new listener to our list.
	 * 
	 */
	public void addListener(BoardListener listener) {
		if(listeners.contains(listener))
			return;
		listeners.add(listener);
	}
	/**
	 * 
	 * Removes listener from our list.
	 * 
	 */
	public void removeListener(BoardListener listener) {
		listeners.remove(listener);
	}

	public void playOneWithoutDeathIteration(){
		boolean [][]field = new boolean[boardCells.length][boardCells[0].length];
		for (int i = 0; i < boardCells.length; i++) {
			for (int j = 0; j < boardCells[i].length; j++) {
				int neighboursNumber = countAliveNeighbours(i, j);
				if (isCellAlive(i, j)){
					field[i][j] = true;
				}
				if (!isCellAlive(i, j) && neighboursNumber == 3) {
					field[i][j] = true;
				}
				
			}
		}
		boardCells = field.clone();
		
		for (BoardListener bl : listeners) {
			bl.boardChanged(this);
		}
	}

	
}
