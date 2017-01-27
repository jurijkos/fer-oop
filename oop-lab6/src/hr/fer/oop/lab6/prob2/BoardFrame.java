package hr.fer.oop.lab6.prob2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.lang.reflect.InvocationTargetException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

/**
 * Graphical repentation of Conway's Game of
 * Life. It uses JToggleButtons for cells.
 * @author Jurij Kos
 *
 */
public class BoardFrame extends JFrame {
	

	private static final long serialVersionUID = 1L;
	/**This variable is used to know when game is iterating.*/
	private boolean suspended;
	/**When game is first time played true.*/
	private boolean fistPokreni;
	
	private boolean secondPokreni;
	
	private ButtonGroup group;
	private JRadioButton gameOfLife;
	private JRadioButton lifeWithoutDeath;
	
	private int numIterations;
	private boolean withIterations;

	public BoardFrame() {
		init();
	}
	/**
	 * Initalizes graphical user interface and our Board.
	 */
	public void init () {
		suspended = false;
		fistPokreni = true;
		secondPokreni = true;
		Board board = new Board(30, 30);
		setLocation(350, 50);
		setSize(600, 650);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		JToolBar toolBar = new JToolBar(SwingConstants.HORIZONTAL);
		add(toolBar, BorderLayout.NORTH);
		toolBar.setLayout(new FlowLayout());
		
		JButton pokreni = new JButton("Pokreni");
		
		JButton zaustavi = new JButton("Zaustavi");
		zaustavi.setEnabled(false);
		
		JButton iteracija = new JButton("Jedna iteracija");

		toolBar.add(pokreni);
		toolBar.add(zaustavi);
		toolBar.add(iteracija);
		JToggleButton[][] toggleButtons = new JToggleButton[30][30];
		for (int i = 0; i < toggleButtons.length; i++) {
			for (int j = 0; j < toggleButtons[i].length; j++) {
				JToggleButton tb= new JToggleButton();
				tb.setBackground(Color.PINK);
				int x = i, y = j;
				tb.addActionListener(l ->board.setCell(x, y, tb.isSelected()));
				board.addListener((listener) -> {
					if (board.isCellAlive(x, y)) 
						tb.setSelected(true);
					else 
						tb.setSelected(false);
				});
				toggleButtons[i][j] = tb;
			}
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(30, 30));
		for (int i = 0; i < toggleButtons.length; i++) {
			for (int j = 0; j < toggleButtons[i].length; j++) {
				panel.add(toggleButtons[i][j]);
			}
		}
		add(panel);
		iteracija.addActionListener(e -> board.playOneIteration());
		Thread xThread = new Thread(() -> {
			while (true) {
				synchronized (this) {
					while(suspended || (numIterations == 0 && withIterations)){
						try {
							this.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
				if(withIterations){
					numIterations--;
				}
				if (gameOfLife.isSelected()) {
					board.playOneIteration();
				}
				else {
					board.playOneWithoutDeathIteration();
				}
				try {
					Thread.sleep(500);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		//na labosu
		group = new ButtonGroup();
		gameOfLife = new JRadioButton("Game of life");
		lifeWithoutDeath = new JRadioButton("Live forever");
		gameOfLife.setSelected(true);
		group.add(gameOfLife);
		group.add(lifeWithoutDeath);
		JTextField numOfIterations = new JTextField();
		numOfIterations.setColumns(5);
		toolBar.add(gameOfLife);
		toolBar.add(lifeWithoutDeath);
		toolBar.add(numOfIterations);
		
		Thread yThread = new Thread(() -> {
			while (true) {
				synchronized (this) {
					while(suspended){
						try {
							this.wait();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}
				}
				board.playOneWithoutDeathIteration();
				try {
					Thread.sleep(500);
				}catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		pokreni.addActionListener(l ->{
			pokreni.setEnabled(false);
			iteracija.setEnabled(false);
			zaustavi.setEnabled(true);
			gameOfLife.setEnabled(false);
			lifeWithoutDeath.setEnabled(false);
			suspended = false;
			String text = numOfIterations.getText();
			if (!text.isEmpty()){
				withIterations = true;
				numIterations = Integer.parseInt(text);
				System.out.println(numIterations);
			}
			if (fistPokreni) {
				xThread.start();
				fistPokreni = false;
			}
			else {
				synchronized (this) {
					this.notify();
				}
			}
			
			//else {
				//if (secondPokreni) {
					//yThread.start();
					//fistPokreni = false;
				//}
				//else {
					//synchronized (this) {
						//this.notify();
					//}
				//}
			//}
		});
		zaustavi.addActionListener( e ->{
			zaustavi.setEnabled(false);
			pokreni.setEnabled(true);
			iteracija.setEnabled(true);
			gameOfLife.setEnabled(true);
			lifeWithoutDeath.setEnabled(true);
			suspended = true;
		});
	}
	
	
	/**
	 * Starting point of program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				new BoardFrame();
			});
		} catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}


}
