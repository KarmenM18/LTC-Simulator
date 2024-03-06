public class InterchangeStation extends Station {

	private Station[] prevs; // array of Station objects, stores a list of previous stations
	private Station[] nexts; // array of Station objects, stores a list of next stations

	public InterchangeStation(int stnNo, String stnName, int x, int y) {
		super(stnNo, stnName, x, y);

		// note: default size is set to 2, but may have to be expanded later
		this.prevs = new Station[2];
		this.nexts = new Station[2];

	}

	// Throws exceptions for class Station's getters and setters

	public Station getPrev() throws StationException {
		throw new StationException("InterchangeStation cannot use getPrev()");
	}

	public Station getNext() throws StationException {
		throw new StationException("InterchangeStation cannot use getNext()");
	}

	public void setPrev(Station stn) throws StationException {
		throw new StationException("InterchangeStation cannot use setPrev()");
	}

	public void setNext(Station stn) throws StationException {
		throw new StationException("InterchangeStation cannot use setNext()");
	}

	// NEW getters and setters for InterchangeStation Class

	/*
	 * PURPOSE: gets the previous station on a given line
	 */
	public Station getPrev(char lineLetter) {

		int lineNum = lineLetter - 65;
		if (lineNum > (prevs.length - 1)) {
			return null;
		}
		return prevs[lineNum];
	}

	/*
	 * PURPOSE: gets the next station on a given line
	 */
	public Station getNext(char lineLetter) {

		int lineNum = lineLetter - 65;
		if (lineNum > (nexts.length - 1)) {
			return null;
		}
		return nexts[lineNum];

	}

	/*
	 * PARAMETERS: Station object, character indicating line letter PURPOSE: sets
	 * the previous station along an indicated line, expands capacity if needed
	 * RETURN: void
	 */
	public void setPrev(Station stn, char lineLetter) {
		Station[] dupArrayofNexts = nexts; // temporary array that stores the same values as nexts
		Station[] dupArrayOfPrevs = prevs; // temporary array that stores the same values as prevs
		int lineNum = lineLetter - 65;

		// EXPAND CAPACITY: checks if an additional space needs to be made for a new
		// station line, expands capacity by one
		if ((lineNum + 1) > (nexts.length)) {
			prevs = new Station[lineNum + 1];
			nexts = new Station[lineNum + 1];

		}

		// elements from prevs and nexts are copied into the new prevs and nexts arrays with expanded capacities
		for (int i = 0; i < dupArrayofNexts.length; i++) {
			prevs[i] = dupArrayOfPrevs[i];
			nexts[i] = dupArrayofNexts[i];
		}

		// if no expanding is necessary, the Station object will be added into the last available space
		if ((nexts.length - 1) == (lineNum)) {
		}

		prevs[lineNum] = stn;

	}

	/*
	 * PARAMETERS: Station object, character indicating line letter PURPOSE: sets
	 * the next station along an indicated line, expands capacity if needed RETURN:
	 * void
	 */
	public void setNext(Station stn, char lineLetter) {
		Station[] dupArrayofNexts = nexts; // temporary array that stores the same values as nexts
		Station[] dupArrayOfPrevs = prevs; // temporary array that stores the same values as prevs
		int lineNum = lineLetter - 65;

		// EXPAND CAPACITY: checks if an additional space needs to be made for a new
		// station line, expands capacity by one
		if ((lineNum + 1) > (nexts.length)) {
			prevs = new Station[lineNum + 1];
			nexts = new Station[lineNum + 1];

		}

		// copies elements from prevs and nexts array into their respective arrays with expanded capacities
		for (int i = 0; i < dupArrayofNexts.length; i++) {
			prevs[i] = dupArrayOfPrevs[i];
			nexts[i] = dupArrayofNexts[i];
		}

		nexts[lineNum] = stn;
	}

	/*
	 * PURPOSE: gets the array of all previous Station objects
	 */
	public Station[] getPrevArray() {
		return prevs;
	}

	/*
	 * PURPOSE: gets the array of all next Station objects
	 */
	public Station[] getNextArray() {
		return nexts;
	}

	/*
	 * PURPOSE: builds a string containing the station numbers of previous stations
	 * RETURN: a string of previous Station numbers
	 */
	public String getPrevString() {
		String str = "";

		for (int i = 0; i < prevs.length; i++) {

			if (prevs[i] == null) {
				str = str + "__  ";
			} else {
				str = str + prevs[i].getStnNo() + "  ";
			}
		}
		return str;
	}

	/*
	 * PURPOSE: builds a string containing the station numbers of next stations
	 * RETURN: a string of next Station numbers
	 */
	public String getNextString() {
		String str = "";

		for (int i = 0; i < nexts.length; i++) {

			if (nexts[i] == null) {
				str = str + "__  ";
			} else {
				str = str + nexts[i].getStnNo() + "  ";

			}
		}
		return str;
	}

	/*
	 * PURPOSE: helper method, which retrieves the line letters that an
	 * InterchangeStation object lies on RETURN: a string of line letters
	 */
	private String getLineNames() {

		String str = "";

		int listOfIndices[] = new int[prevs.length];

		for (int i = 0; i < prevs.length; i++) {
			if (prevs[i] != null || nexts[i] != null) {
				listOfIndices[i] = i;

			}

			else {
				listOfIndices[i] = -1;
			}

		}

		for (int i = 0; i < listOfIndices.length; i++) {
			if (listOfIndices[i] != -1) {
				str += (char) ((listOfIndices[i]) + 65) + " ";
			}
		}

		return str;

	}

	/*
	 * PURPOSE: a toString representing key interchange station information RETURNS:
	 * string representation of station number, station name, and line letters
	 */
	public String toString() {
		String str = "";
		str = "Stn: " + getStnNo() + " (" + getName() + ")" + " on Lines: " + getLineNames();

		return str;
	}

}
