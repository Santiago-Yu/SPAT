class n101811 {
	public void bubbleSort(int[] A3Gj0dRf) {
		boolean GFijgmE0 = true;
		int IBJJ8Iac = 0;
		int A33FNMQj;
		while (GFijgmE0) {
			GFijgmE0 = false;
			IBJJ8Iac++;
			for (int nsbPYPSO = 0; nsbPYPSO < A3Gj0dRf.length - IBJJ8Iac; nsbPYPSO++) {
				if (A3Gj0dRf[nsbPYPSO] > A3Gj0dRf[nsbPYPSO + 1]) {
					A33FNMQj = A3Gj0dRf[nsbPYPSO];
					A3Gj0dRf[nsbPYPSO] = A3Gj0dRf[nsbPYPSO + 1];
					A3Gj0dRf[nsbPYPSO + 1] = A33FNMQj;
					GFijgmE0 = true;
				}
			}
		}
	}

}