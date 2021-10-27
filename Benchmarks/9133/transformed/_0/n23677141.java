class n23677141 {
	public static void BubbleSortShort1(short[] sE018Et9) {
		boolean hajVgEZE = true; // set flag to true to begin first pass
		short w98kUBUx; // holding variable

		while (hajVgEZE) {
			hajVgEZE = false; // set flag to false awaiting a possible swap
			for (int MdGIRHWe = 0; MdGIRHWe < sE018Et9.length - 1; MdGIRHWe++) {
				if (sE018Et9[MdGIRHWe] > sE018Et9[MdGIRHWe + 1]) // change to > for ascending sort
				{
					w98kUBUx = sE018Et9[MdGIRHWe]; // swap elements
					sE018Et9[MdGIRHWe] = sE018Et9[MdGIRHWe + 1];
					sE018Et9[MdGIRHWe + 1] = w98kUBUx;
					hajVgEZE = true; // shows a swap occurred
				}
			}
		}
	}

}