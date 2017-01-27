package hr.fer.oop.lab6.prob1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;
import hr.fer.oop.generictable.GenericTablePanel;

/**
 * Main class of application. Contains main window.
 * Shows records of taxi drivers.
 * @author Jurij Kos
 *
 */
public class TaxiRecordViewerMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private  GenericTablePanel<TaxiRecord> tablePanel;
	private JButton exitButton;
	private JTextField field;
	private JTextArea textArea;
	private JButton loadButton;
	private JButton filterButton;
	private JButton applyFilterButton;
	private JToolBar toolBar;
	private JFrame filterFrame = null;
	private FilterPanel panel;
	private List<TaxiRecord> allRecords;
	/**
	 * Constructor. It initalizes window and all elements inside it.
	 */
	public TaxiRecordViewerMain() {
		setTitle("Taxi Record Viewer");
		setLocation(100, 100);
		setSize(1200, 600);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
        //define the table size and add it to the frame center
        tablePanel = new GenericTablePanel<>(TaxiRecord.class);
        tablePanel.setPreferredSize(new Dimension(200, 100));
        add(tablePanel, BorderLayout.CENTER);
        
        //elements in toolbar
        exitButton = new JButton("Exit");
        exitButton.addActionListener(e ->System.exit(0));
        
        field = new JTextField();
        
        textArea = new JTextArea();
        //add(textArea, BorderLayout.SOUTH);
		textArea.setRows(5);
		JScrollPane scrollPane = new JScrollPane(textArea);
		getContentPane().add(scrollPane,BorderLayout.SOUTH);
        
        loadButton = new JButton("Load File");
        loadButton.addActionListener(e -> {
        	Path data = Paths.get(field.getText());
        	if(!Files.exists(data)){
        		textArea.append("File " + data.toString() + " doesn's exist!\n");
        		return;
        	}
        	loadButton.setEnabled(false);
        	applyFilterButton.setEnabled(false);
        	new ReadData(data).execute();
        });
        
        filterButton = new JButton("Define Filter");
        filterButton.addActionListener(l -> {
			if(filterFrame == null){
				filterFrame = new JFrame();
				filterFrame.setVisible(true);
				filterFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				filterFrame.setBounds(600,300,400,400);
				Container cpp = filterFrame.getContentPane();
				cpp.setLayout(new BorderLayout());
				panel = new FilterPanel();
				cpp.add(panel, BorderLayout.CENTER);
				filterFrame.pack();
			}else if(filterFrame.isVisible()){
				filterFrame.setVisible(false);
			}else{
				filterFrame.setVisible(true);
			}
        });
        applyFilterButton = new JButton("Apply Filter");
        applyFilterButton.addActionListener(e -> {
        	if (filterFrame!=null){
				loadButton.setEnabled(false);
				applyFilterButton.setEnabled(false);
				new FiltrateData(panel.getfilterConditions()).execute();
			}
        });
        
        
        //defining tool bar on the top of the window.
        toolBar = new JToolBar(SwingConstants.HORIZONTAL);
        toolBar.add(exitButton);
        toolBar.add(field);
        toolBar.add(loadButton);
        toolBar.add(filterButton);
        toolBar.add(applyFilterButton);
        add(toolBar, BorderLayout.NORTH);
		
	}
	/**
	 * Starting point of the program. Creates TaxiRecordViewer object.
	 * @param args
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(() -> {
			new TaxiRecordViewerMain();
		});
	}
	
	
	
	
	
	/**
	 * It represent record of every taxi serice.
	 * @author Jurij Kos
	 *
	 */
	public static class TaxiRecord {
		/**an md5sum of the identifier of the taxi - vehicle bound*/
		private String medallion;
		/**an md5sum of the identifier for the taxi license*/
		private String hackLicense;
		/**time when the passenger(s) were picked up*/
		private String pickup;
		/**time when the passenger(s) were dropped off*/
		private String dropoff;
		/**Duration of trip*/
		private int duration;
		/**Distance of trip*/
		private double distance;
		//Loacations of pickup and dropoff
		private double pickupLongitude;
		private double pickupLatitude;
		private double dropoffLongitude;
		private double dropoffLatitude;
		//cash card or unknown
		private String paymentType;
		private double fare;
		private double surcharge;
		private double tax;
		private double tip;
		private double tolls;
		private double total;
		private int id;
		
		/**
		 * Creates object from info it gets in csv line.
		 * @param podaci
		 * @param id
		 */
		public TaxiRecord(String podaci, int id) {
			// TODO Auto-generated constructor stub
			String []argumenti = podaci.split(",");
			if (argumenti.length != 17){
				throw new IllegalArgumentException();
			}
			this.medallion = argumenti[0];
			this.hackLicense = argumenti[1];
			this.pickup = argumenti[2];
			this.dropoff = argumenti[3];
			this.duration = Integer.parseInt(argumenti[4]);
			this.distance = Double.parseDouble(argumenti[5]);
			this.pickupLongitude = Double.parseDouble(argumenti[6]);
			this.pickupLatitude = Double.parseDouble(argumenti[7]);
			this.dropoffLongitude = Double.parseDouble(argumenti[8]);
			this.dropoffLatitude = Double.parseDouble(argumenti[9]);
			this.paymentType = argumenti[10];
			this.fare = Double.parseDouble(argumenti[11]);
			this.surcharge = Double.parseDouble(argumenti[12]);
			this.tax = Double.parseDouble(argumenti[13]);
			this.tip = Double.parseDouble(argumenti[14]);
			this.tolls = Double.parseDouble(argumenti[15]);
			this.total = Double.parseDouble(argumenti[16]);
			
			this.id = id;
		}
		public String getMedallion() {
			return medallion;
		}
		public String getHackLicense() {
			return hackLicense;
		}
		public String getPickup() {
			return pickup;
		}
		public String getDropoff() {
			return dropoff;
		}
		public int getDuration() {
			return duration;
		}
		public double getDistance() {
			return distance;
		}
		public double getPickupLongitude() {
			return pickupLongitude;
		}
		public double getPickupLatitude() {
			return pickupLatitude;
		}
		public double getDropoffLongitude() {
			return dropoffLongitude;
		}
		public double getDropoffLatitude() {
			return dropoffLatitude;
		}
		public double getFare() {
			return fare;
		}
		public double getSurcharge() {
			return surcharge;
		}
		public double getTax() {
			return tax;
		}
		public double getTip() {
			return tip;
		}
		public double getTolls() {
			return tolls;
		}
		public double getTotal() {
			return total;
		}
		/**
		 * 
		 * @return CSH-cash
		 * 		   CRD-card
		 * 		   UNK-unknown	
		 */
		public String getPaymentType() {
			return paymentType;
		}
		/**
		 * 
		 * @return ordinal number of fare.
		 */
		public int getId() {
			return id;
		}
		
		@Override
		public String toString() {
			return "TaxiRecord [id = "+ id + "medallion=" + medallion + ", hack_license=" + hackLicense + ", pickup_datetime="
					+ pickup + ", dropoff_datetime=" + dropoff + ", trip_time_in_secs="
					+ duration + ", trip_distance=" + distance + ", pickup_longitude=" + pickupLongitude
					+ ", pickup_latitude=" + pickupLatitude + ", dropoff_longitude=" + dropoffLongitude
					+ ", dropoff_latitude=" + dropoffLatitude + ", payment_type=" + paymentType+ ", fare_amount="
					+ fare + ", surcharge=" + surcharge + ", mta_tax=" + tax + ", tip_amount=" + tip
					+ ", tolls_amount=" + tolls + ", total_amount=" + total + "]";
		}
	}
	/**
	 * This class do  big job in background thread. It is used when
	 * we read from file.
	 * @author Jurij Kos
	 *
	 */
	private class ReadData extends SwingWorker<List<TaxiRecord>, Path> {
		private Path data;
		private int i = 1;
		public ReadData(Path data) {
			this.data = data;
		}
		@Override
		protected List<TaxiRecord> doInBackground() throws Exception {
			//List<TaxiRecord> list = new ArrayList<>();
			try (Stream<String> smallData = Files.lines(data);){
				//list
				allRecords= smallData.map((s) ->{
					return new TaxiRecord(s, i++);
				}).collect(Collectors.toList());
				return allRecords;
						//list;
			}
			
		}
		@Override
		protected void done() {
			loadButton.setEnabled(true);
			applyFilterButton.setEnabled(true);
			try {
				tablePanel.update(this.get());
			} catch (Exception e) {
				textArea.append("Unable to write in table...\n");
				//System.exit(0);
			}
		}
		
	}
	/**
	 * This class do  big job in background thread. It is used when
	 * we filter our data.
	 * @author Jurij Kos
	 *
	 */
	private class FiltrateData extends SwingWorker<List<TaxiRecord>,FilterConditions>{
		FilterConditions conditions;
		public FiltrateData(FilterConditions conditions){
			this.conditions = conditions;
		}
		@Override
		protected List<TaxiRecord> doInBackground() throws Exception {
			List<TaxiRecord> records = new ArrayList<>(allRecords);
					//tablePanel.getRecords();
			
			if(conditions.isSkipRecords()){
				records = records.stream().skip(conditions.getNumberToSkip()).collect(Collectors.toList());
			}
			if(conditions.isLeaveRecords()){
				records = records.stream().limit(conditions.getNumberToLeave()).collect(Collectors.toList());
			}
			records = records.stream().filter(p->{
				if(conditions.isFilterByPT()){
					return p.getPaymentType().equals(conditions.getPaymentType());
				}
				return true;
			}).filter(p->{
				if(conditions.isLimitDst()){
					if(conditions.getLimiter().equals("<")){
						return p.getDistance() < conditions.getDistance();
					}else if (conditions.getLimiter().equals(">=")){
						return p.getDistance() >= conditions.getDistance();
					}
				}
				return true;
			}).collect(Collectors.toList());
			
			return records;
		}
		
		@Override
		protected void done(){
			loadButton.setEnabled(true);
			applyFilterButton.setEnabled(true);
			
			try {
				tablePanel.update(this.get());
			} catch (Exception e) {
				textArea.append("An error has ocurred during writing data into the table\n");
				System.exit(0);
			}
		}
		
	} 
}









/*new Thread(()->{
try (Stream<String> smallData= Files.lines(data);) {
	List<TaxiRecord> list =smallData.map(new Function<String, TaxiRecord>() {
		@Override
		public TaxiRecord apply(String t) {
			String[] tr = t.split(",");
			TaxiRecord tRecord = new TaxiRecord(tr[0],tr[1],
					tr[2], tr[3], Integer.parseInt(tr[4]), Double.parseDouble(tr[5]), 
					Double.parseDouble(tr[6]), Double.parseDouble(tr[7]), Double.parseDouble(tr[8]), 
					Double.parseDouble(tr[9]),tr[10], Double.parseDouble(tr[11]), Double.parseDouble(tr[12]),
					Double.parseDouble(tr[13]), Double.parseDouble(tr[14]), Double.parseDouble(tr[15]),
					Double.parseDouble(tr[16]));
			return tRecord;
		}
	}).collect(Collectors.toList());
	SwingUtilities.invokeLater(() ->tablePanel.update(list));
}catch (IOException e1) {
	textArea.append(e1.toString());
	textArea.append("\n");
}
}).start();
*/
