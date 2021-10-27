class n10606028 {
	public void bubble() {
		int kars = 0, tas = 0;
		boolean test = false;
		while (true) {
			for (int j = 0; j < dizi.length - 1; j++) {
				if (dizi[j] > dizi[j + 1]) {
					int temp = dizi[j];
					dizi[j] = dizi[j + 1];
					dizi[j + 1] = temp;
					test = true;
					tas++;
				}
				kars++;
			}
			if (!test) {
				break;
			} else {
				test = false;
			}
		}
		System.out.print(kars + " " + tas);
	}

}