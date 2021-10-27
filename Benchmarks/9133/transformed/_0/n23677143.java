class n23677143 {
	public static void BubbleSortByte1(byte[] xPIUXTeO) {
		boolean klr3Q0lf = true; // set flag to true to begin first pass
		byte WkUNlQh4; // holding variable

		while (klr3Q0lf) {
			klr3Q0lf = false; // set flag to false awaiting a possible swap
			for (int r5nJKxNN = 0; r5nJKxNN < xPIUXTeO.length - 1; r5nJKxNN++) {
				if (xPIUXTeO[r5nJKxNN] > xPIUXTeO[r5nJKxNN + 1]) // change to > for ascending sort
				{
					WkUNlQh4 = xPIUXTeO[r5nJKxNN]; // swap elements
					xPIUXTeO[r5nJKxNN] = xPIUXTeO[r5nJKxNN + 1];
					xPIUXTeO[r5nJKxNN + 1] = WkUNlQh4;
					klr3Q0lf = true; // shows a swap occurred
				}
			}
		}
	}

}