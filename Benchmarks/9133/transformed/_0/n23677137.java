class n23677137 {
	public static void BubbleSortDouble1(double[] FEu36Lff) {
		boolean nTCOQcFo = true; // set flag to true to begin first pass
		double J0z89Te1; // holding variable

		while (nTCOQcFo) {
			nTCOQcFo = false; // set flag to false awaiting a possible swap
			for (int KlY5kxju = 0; KlY5kxju < FEu36Lff.length - 1; KlY5kxju++) {
				if (FEu36Lff[KlY5kxju] > FEu36Lff[KlY5kxju + 1]) // change to > for ascending sort
				{
					J0z89Te1 = FEu36Lff[KlY5kxju]; // swap elements
					FEu36Lff[KlY5kxju] = FEu36Lff[KlY5kxju + 1];
					FEu36Lff[KlY5kxju + 1] = J0z89Te1;
					nTCOQcFo = true; // shows a swap occurred
				}
			}
		}
	}

}