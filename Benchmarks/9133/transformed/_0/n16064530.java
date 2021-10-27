class n16064530 {
	private void bubbleSort() {
		for (int Ns6oDxr9 = 0; Ns6oDxr9 < testfield.length; Ns6oDxr9++) {
			for (int c5oL2Uea = 0; c5oL2Uea < testfield.length - Ns6oDxr9 - 1; c5oL2Uea++)
				if (testfield[c5oL2Uea] > testfield[c5oL2Uea + 1]) {
					short C392J3O5 = testfield[c5oL2Uea];
					testfield[c5oL2Uea] = testfield[c5oL2Uea + 1];
					testfield[c5oL2Uea + 1] = C392J3O5;
				}
		}
	}

}