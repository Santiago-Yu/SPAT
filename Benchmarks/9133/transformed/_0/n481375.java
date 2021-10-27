class n481375 {
	public void bubbleSort(int[] biaMESYu) {
		boolean vzSXx1TG = true;
		int wZr8wFzw = 0;
		int eMl2fgf9;
		while (vzSXx1TG) {
			vzSXx1TG = false;
			wZr8wFzw++;
			for (int yELonHZR = 0; yELonHZR < biaMESYu.length - wZr8wFzw; yELonHZR++) {
				if (biaMESYu[yELonHZR] > biaMESYu[yELonHZR + 1]) {
					eMl2fgf9 = biaMESYu[yELonHZR];
					biaMESYu[yELonHZR] = biaMESYu[yELonHZR + 1];
					biaMESYu[yELonHZR + 1] = eMl2fgf9;
					vzSXx1TG = true;
				}
			}
		}
	}

}