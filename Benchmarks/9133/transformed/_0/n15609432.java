class n15609432 {
	public static int[] bubbleSort(int[] NQ5RTnrC) {
		if (NQ5RTnrC != null && NQ5RTnrC.length > 0) {
			boolean CxsMtwWE = true;
			while (CxsMtwWE) {
				CxsMtwWE = false;
				for (int u3cES23H = 0; u3cES23H < NQ5RTnrC.length - 1; u3cES23H++) {
					if (NQ5RTnrC[u3cES23H] > NQ5RTnrC[u3cES23H + 1]) {
						int tmHV0OoG = NQ5RTnrC[u3cES23H];
						NQ5RTnrC[u3cES23H] = NQ5RTnrC[u3cES23H + 1];
						NQ5RTnrC[u3cES23H + 1] = tmHV0OoG;
						CxsMtwWE = true;
					}
				}
			}
		}
		return NQ5RTnrC;
	}

}