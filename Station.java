public class Station {

	private static int nextID = 0;
	private int id;
	private int stnNo;
	private String name;
	private Station prev;
	private Station next;
	private int x;
	private int y;

	public Station(int stnNo, String stnName, int x, int y) {
		this.stnNo = stnNo;
		this.name = stnName;
		this.x = x;
		this.y = y;
		this.prev = null;
		this.next = null;
		this.id = nextID; // setting "private int" variable to "static int" variable
		nextID++;
	}

	// GETTERS

	/*
	 * PURPOSE: gets the unique ID of a Station object
	 */
	public int getID() {
		return id;
	}

	/*
	 * PURPOSE: gets the station number
	 */
	public int getStnNo() {
		return stnNo;
	}

	/*
	 * PURPOSE: gets the name of the station
	 */
	public String getName() {
		return name;
	}

	/*
	 * PURPOSE: gets the previous Station object
	 */
	public Station getPrev() {
		return prev;
	}

	/*
	 * PURPOSE: gets the next Station object
	 */
	public Station getNext() {
		return next;
	}

	/*
	 * PURPOSE: gets the x-value coordinate
	 */
	public int getX() {
		return x;
	}

	/*
	 * PURPOSE: gets the y-value coordinate
	 */
	public int getY() {
		return y;
	}

	// SETTERS:

	/*
	 * PARAMETER: Station object PURPOSE: sets the previous Station object
	 */
	public void setPrev(Station stn) {
		prev = stn;
	}

	/*
	 * PARAMETER: Station object PURPOSE: sets the next Station object
	 */
	public void setNext(Station stn) {
		next = stn;
	}

	/*
	 * PURPOSE: returns a String representation of station number and station name
	 */
	public String toString() {
		return "Stn: " + stnNo + " (" + name + ")";
	}

}
