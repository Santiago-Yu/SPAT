class n3365958 {
	private void bubbleSort(int[] tP3TVYR2) {
		boolean eVb22dQN = true;
		int G0THisjd = 0;
		while (eVb22dQN) {
			eVb22dQN = false;
			for (int mCIvfMkK = 0; mCIvfMkK < tP3TVYR2.length - 1; mCIvfMkK++) {
				if (tP3TVYR2[mCIvfMkK] > tP3TVYR2[mCIvfMkK + 1]) {
					G0THisjd = tP3TVYR2[mCIvfMkK];
					tP3TVYR2[mCIvfMkK] = tP3TVYR2[mCIvfMkK + 1];
					tP3TVYR2[mCIvfMkK + 1] = G0THisjd;
					eVb22dQN = true;
				}
			}
		}
	}

}