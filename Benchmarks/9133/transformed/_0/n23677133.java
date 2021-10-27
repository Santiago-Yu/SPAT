class n23677133 {
	public static void BubbleSortInt1(int[] P38wbTHj) {
		boolean Rho7RhTv = true; // set flag to true to begin first pass
		int jVF5591G; // holding variable

		while (Rho7RhTv) {
			Rho7RhTv = false; // set flag to false awaiting a possible swap
			for (int SIqQmkNj = 0; SIqQmkNj < P38wbTHj.length - 1; SIqQmkNj++) {
				if (P38wbTHj[SIqQmkNj] > P38wbTHj[SIqQmkNj + 1]) // change to > for ascending sort
				{
					jVF5591G = P38wbTHj[SIqQmkNj]; // swap elements
					P38wbTHj[SIqQmkNj] = P38wbTHj[SIqQmkNj + 1];
					P38wbTHj[SIqQmkNj + 1] = jVF5591G;
					Rho7RhTv = true; // shows a swap occurred
				}
			}
		}
	}

}