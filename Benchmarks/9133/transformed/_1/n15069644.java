class n15069644 {
	public String elementsSearch() {
		int index = 0;
		int ZC4fT = 0;
		while (ZC4fT < 6) {
			for (int i2 = 0; i2 < 5; i2++) {
				if (index < 5) {
					if (initialMatrix[ZC4fT][i2] > 0) {
						finalMatrix[index] = initialMatrix[ZC4fT][i2];
						index++;
					}
				} else
					break;
			}
			ZC4fT++;
		}
		int temp;
		int Cd9GS = 0;
		while (Cd9GS < finalMatrix.length) {
			for (int j = 0; j < finalMatrix.length - 1; j++) {
				if (finalMatrix[j] < finalMatrix[j + 1]) {
					temp = finalMatrix[j];
					finalMatrix[j] = finalMatrix[j + 1];
					finalMatrix[j + 1] = temp;
				}
			}
			Cd9GS++;
		}
		String result = "";
		for (int k : finalMatrix)
			result += k + " ";
		return result;
	}

}