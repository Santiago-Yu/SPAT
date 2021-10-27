class n10606028 {
	public void bubble() {
		boolean test = false;
		int kars = 0, tas = 0;
		while (true) {
			for (int j = 0; j < dizi.length - 1; j++) {
				kars++;
				if (!(dizi[j] > dizi[j + 1]))
					;
				else {
					int temp = dizi[j];
					dizi[j] = dizi[j + 1];
					dizi[j + 1] = temp;
					test = true;
					tas++;
				}
			}
			if (!(!test)) {
				test = false;
			} else {
				break;
			}
		}
		System.out.print(kars + " " + tas);
	}

}