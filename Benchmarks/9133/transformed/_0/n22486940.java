class n22486940 {
	public void sortingByBubble(int[] R0TSJCAE) {
		for (int nppWwg0J = 0; nppWwg0J < R0TSJCAE.length; nppWwg0J++) {
			for (int g4qDsgWt = 0; g4qDsgWt < R0TSJCAE.length - 1 - nppWwg0J; g4qDsgWt++) {
				if (R0TSJCAE[g4qDsgWt] > R0TSJCAE[g4qDsgWt + 1]) {
					int Mr9Asvzb = R0TSJCAE[g4qDsgWt];
					R0TSJCAE[g4qDsgWt] = R0TSJCAE[g4qDsgWt + 1];
					R0TSJCAE[g4qDsgWt + 1] = Mr9Asvzb;
				}
			}
		}
	}

}