class n186569 {
	void bubbleSort(int[] CP4SNVO1) {
		int Rd1GeoLT = 0;
		int w9xp3X4R = CP4SNVO1.length - 1;
		int jltAv3Yh = 0;
		int yHqhy1nu = 0;
		while (yHqhy1nu == 0) {
			yHqhy1nu = 1;
			Rd1GeoLT = 0;
			while (Rd1GeoLT < w9xp3X4R) {
				if (CP4SNVO1[Rd1GeoLT] > CP4SNVO1[Rd1GeoLT + 1]) {
					jltAv3Yh = CP4SNVO1[Rd1GeoLT];
					CP4SNVO1[Rd1GeoLT] = CP4SNVO1[Rd1GeoLT + 1];
					CP4SNVO1[Rd1GeoLT + 1] = jltAv3Yh;
					yHqhy1nu = 0;
				}
				Rd1GeoLT = Rd1GeoLT + 1;
			}
			w9xp3X4R = w9xp3X4R - 1;
		}
	}

}