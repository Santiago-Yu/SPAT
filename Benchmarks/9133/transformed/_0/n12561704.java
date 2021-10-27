class n12561704 {
	private void bubbleSort(int[] qrFPLjsY) {
		boolean D6G7dSyK = true;
		while (D6G7dSyK) {
			D6G7dSyK = false;
			for (int EWDUfpgQ = 0; EWDUfpgQ < qrFPLjsY.length - 1; EWDUfpgQ++) {
				if (qrFPLjsY[EWDUfpgQ] > qrFPLjsY[EWDUfpgQ + 1]) {
					int wP8US8y8 = qrFPLjsY[EWDUfpgQ];
					qrFPLjsY[EWDUfpgQ] = qrFPLjsY[EWDUfpgQ + 1];
					qrFPLjsY[EWDUfpgQ + 1] = wP8US8y8;
					D6G7dSyK = true;
				}
			}
		}
	}

}