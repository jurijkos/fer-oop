package hr.fer.oop.lab6.prob1;

import java.awt.GridLayout;


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;


/**
 * Cretes window opened when we click on filterButton
 * in our main window.
 * @author Jurij Kos
 *
 */
public class FilterPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JCheckBox skipRecords;
	private JCheckBox leaveRecords;
	private JCheckBox filterByPT;
	private JCheckBox limitDst;
	private JTextField recordsToSkip;
	private JTextField recordsToLeave;
	private JTextField distance;
	private JComboBox<String> limiter;
	private JRadioButton cash;
	private JRadioButton card;
	private JRadioButton unknown;
	private ButtonGroup group;
	/**
	 * In constructor is done all.
	 */
	public FilterPanel(){
		setLayout(new SpringLayout());
		
		skipRecords = new JCheckBox("Skip records");
		add(skipRecords);
		add(new JLabel("Number of records to skip : ", SwingConstants.RIGHT));
		recordsToSkip = new JTextField();
		recordsToSkip.setColumns(10);
		add(recordsToSkip);
		
		
		leaveRecords = new JCheckBox("Leave records");
		add(leaveRecords);
		add(new JLabel("Number of records to leave ", SwingConstants.RIGHT));
		recordsToLeave = new JTextField();
		recordsToLeave.setColumns(10);
		add(recordsToLeave);
		
		filterByPT = new JCheckBox("Filter by payment type ");
		add(filterByPT);
		add(new JPanel());
		JPanel radioPanel = new JPanel();
		radioPanel.setBorder(BorderFactory.createTitledBorder(null, "Payment type",
				TitledBorder.LEADING, TitledBorder.TOP));
		radioPanel.setLayout(new GridLayout(0,1));
		add(radioPanel);
		group = new ButtonGroup();
		cash = new JRadioButton("Cash");
		radioPanel.add(cash);
		group.add(cash);
		card = new JRadioButton("Card");
		radioPanel.add(card);
		group.add(card);
		unknown = new JRadioButton("Unknown");
		radioPanel.add(unknown);
		group.add(unknown);
		
		limitDst = new JCheckBox("Limit distance:");
		add(limitDst);
		String[] limits = {"<",">="};
		limiter = new JComboBox<String>(limits);
		add(limiter);
		distance = new JTextField();
		distance.setColumns(10);
		add(distance);
		
		SpringUtilities.makeCompactGrid(this, 4, 3, 0, 0, 5, 5);
	}
	/**
	 * 
	 * @return condition we put into window.
	 */
	public FilterConditions getfilterConditions(){
		FilterConditions conditions = new FilterConditions();
		
		conditions.setSkipRecords(skipRecords.isSelected());
		if(conditions.isSkipRecords()){
			if(recordsToSkip.getText()==null){
				conditions.setSkipRecords(false);
			}else{
				try{
					conditions.setNumberToSkip(Integer.parseInt(recordsToSkip.getText()));
				}catch(Exception ex){
					conditions.setSkipRecords(false);
				}
			}
		}
		conditions.setLeaveRecords(leaveRecords.isSelected());
		if(conditions.isLeaveRecords()){
			if(recordsToLeave.getText()==null){
				conditions.setLeaveRecords(false);
			}else{
				try{
					conditions.setNumberToLeave(Integer.parseInt(recordsToLeave.getText()));
				}catch(Exception ex){
					conditions.setLeaveRecords(false);
				}
			}
		}
		conditions.setFilterByPT(filterByPT.isSelected());
		if(conditions.isFilterByPT()){
			if(cash.isSelected()){
				conditions.setPaymentType("CSH");
			}else if(card.isSelected()){
				conditions.setPaymentType("CRD");
			}else{
				conditions.setPaymentType("UNK");
			}
		}
		
		conditions.setLimitDst(limitDst.isSelected());
		conditions.setLimiter((String)limiter.getSelectedItem());
		if(conditions.isLimitDst()){
			if(distance.getText()==null){
				conditions.setLimitDst(false);
			}else{
				try{
					conditions.setDistance(Double.parseDouble(distance.getText()));
				}catch(Exception ex){
					conditions.setLimitDst(false);
				}
			}
		}
		return conditions;
	}
}
