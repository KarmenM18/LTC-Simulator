public class TransitLine {

	private char lineLetter;
	private Station firstStn;

	public TransitLine(char letter, Station first) {
		lineLetter = letter;
		firstStn = first;
	}

	/*
	 * PURPOSE: gets the line letter
	 */
	public char getLineLetter() {
		return lineLetter;
	}

	/*
	 * PURPOSE: gets the first station
	 */
	public Station getFirstStn() {
		return firstStn;
	}

	/*
	 * PURPOSE: checks if a station has another station after it RETURNS: true if
	 * there is another station, false if there isn't
	 */
	public boolean hasNext(Station stn) {

		if (stn instanceof InterchangeStation) {
			InterchangeStation int_station = (InterchangeStation) stn;
			if (int_station.getNext(lineLetter) != null) {
				return true;

			}
		}

		else if (stn.getNext() != null) {
			return true;
		}

		return false;
	}

	/*
	 * PURPOSE: adds a station to the current station, and checks if the station to
	 * be added is an Interchange or regular Station, and if the current station is
	 * a regular Station or Interchange station
	 */
	public void addStation(Station stn) {

		TransitLine stationInLine = new TransitLine(lineLetter, firstStn);
		TransitLine newNode;
		Station curr = firstStn;

		// checks to see if the current station has another station after it
		while (hasNext(curr) == true) {

			// checks if the current station is an interchange station
			if (curr instanceof InterchangeStation) {
				curr = ((InterchangeStation) curr).getNext(lineLetter); // casts current to interchange, and gets the
																		// next station in the line

			} else {
				curr = curr.getNext(); // current is a regular station,, gets the next station
			}
		}

		if (curr instanceof InterchangeStation) {
			if (stn instanceof InterchangeStation) { // checks if the station to be added is an interchange station
				((InterchangeStation) curr).setNext((InterchangeStation) stn, lineLetter); // sets the next Interchanges
																							// station to the current
																							// Interchange station
				((InterchangeStation) stn).setPrev((InterchangeStation) curr, lineLetter); // creates a previous link to
																							// connect the added station
																							// to the previous
			} else {
				((InterchangeStation) curr).setNext(stn, lineLetter); // sets the next regular station to the current
																		// interchange station
				stn.setPrev((InterchangeStation) curr);
			}
		}

		else {
			if (stn instanceof InterchangeStation) {
				curr.setNext((InterchangeStation) stn);
				((InterchangeStation) stn).setPrev(curr, lineLetter);

			} else {
				curr.setNext(stn);
				stn.setPrev(curr);

			}
		}
	}

	/*
	 * PURPOSE: returns a toString representation of information RETURNS: a string
	 * of the line, line letter, and all the station numbers on a given line
	 */

	public String toString() {

		Station stnObj = firstStn;
		String str = "";
		str = "Line " + lineLetter + ":  " + stnObj.getStnNo() + "  ";

		do {

			if (stnObj instanceof InterchangeStation) {
				stnObj = ((InterchangeStation) stnObj).getNext(lineLetter);

			} else {
				stnObj = stnObj.getNext();
			}
			str = str + stnObj.getStnNo() + "  ";
		} while (hasNext(stnObj));
		return str;
	}

}
