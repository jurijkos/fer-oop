package hr.fer.oop.lab6.prob1;
/**
 * 
 * 
 * Contains info about all our conditions 
 * we use to filter.
 * @author Jurij Kos
 *
 */
public class FilterConditions {
	private boolean skipRecords;
	private int numberToSkip;
	private boolean leaveRecords;
	private int numberToLeave;
	private boolean filterByPT;
	private String paymentType;
	private boolean limitDst;
	private String limiter;
	private double distance;
	/**
	 * Constructor - to inital values.
	 */
	public FilterConditions(){
		numberToSkip = numberToLeave = 0;
		distance = 0;
	}
	/**
	 * 
	 * @return true if we  skip
	 * 	records.
	 */
	public boolean isSkipRecords() {
		return skipRecords;
	}
	/**
	 * Setter for variable skipRecords
	 * @param skipRecords
	 */
	public void setSkipRecords(boolean skipRecords) {
		this.skipRecords = skipRecords;
	}
	/**
	 * 
	 * @return how many to skip
	 */
	public int getNumberToSkip() {
		return numberToSkip;
	}
	/**
	 * 
	 * @param numberToSkip how many should be skipped.
	 */
	public void setNumberToSkip(int numberToSkip) {
		this.numberToSkip = numberToSkip;
	}
	/**
	 * 
	 * @return true if we will leave some rows ..
	 */
	public boolean isLeaveRecords() {
		return leaveRecords;
	}
	public void setLeaveRecords(boolean leaveRecords) {
		this.leaveRecords = leaveRecords;
	}
	/**
	 * 
	 * @return how many records we will live.
	 */
	public int getNumberToLeave() {
		return numberToLeave;
	}
	/**
	 * 
	 * @param numberToLeave how many record we will left.
	 */
	public void setNumberToLeave(int numberToLeave) {
		this.numberToLeave = numberToLeave;
	}
	/**
	 * 
	 * @return true if we filter based payment method.
	 */
	public boolean isFilterByPT() {
		return filterByPT;
	}
	public void setFilterByPT(boolean filterByPT) {
		this.filterByPT = filterByPT;
	}
	/**
	 * 
	 * @return way of payment.
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * 
	 * @param paymentType type of payment
	 * cash, card or unknown..
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * 
	 * @return true if filter based on limit distance..
	 */
	public boolean isLimitDst() {
		return limitDst;
	}
	/**
	 * 
	 * @param limitDst true to filter on limit dist
	 */
	public void setLimitDst(boolean limitDst) {
		this.limitDst = limitDst;
	}
	/**
	 * 
	 * @return sign for less < or more or eq >=
	 */
	public String getLimiter() {
		return limiter;
	}
	public void setLimiter(String limiter) {
		this.limiter = limiter;
	}
	/**
	 * 
	 * @return distance
	 */
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "FilterConditions [skipRecords=" + skipRecords + ", numberToSkip=" + numberToSkip + ", leaveRecords="
				+ leaveRecords + ", numberToLeave=" + numberToLeave + ", filterByPT=" + filterByPT + ", paymentType="
				+ paymentType + ", limitDst=" + limitDst + ", limiter=" + limiter + ", distance=" + distance + "]";
	}

	
	
}