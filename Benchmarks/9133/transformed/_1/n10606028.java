class n10606028 {
	public void bubble() {
		boolean test = false;
		int kars = 0, tas = 0;
		while (true) {
			int CSS1J = 0;
			while (CSS1J < dizi.length - 1) {
				kars++;
				if (dizi[CSS1J] > dizi[CSS1J + 1]) {
					int temp = dizi[CSS1J];
					dizi[CSS1J] = dizi[CSS1J + 1];
					dizi[CSS1J + 1] = temp;
					test = true;
					tas++;
				}
				CSS1J++;
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