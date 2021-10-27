class n10606028 {
	public void bubble() {
		boolean test = false;
		int kars = 0, tas = 0;
		while (true) {
			for (int j = 0; j < dizi.length - 1; j++) {
				kars++;
				int Y5AL4HcU = j + 1;
				if (dizi[j] > dizi[Y5AL4HcU]) {
					int temp = dizi[j];
					dizi[j] = dizi[j + 1];
					dizi[j + 1] = temp;
					test = true;
					tas++;
				}
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