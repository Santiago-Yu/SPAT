class n10606028 {
	public void bubble() {
		boolean kP6qpUag = false;
		int mBjoArxT = 0, Kxjx88WN = 0;
		while (true) {
			for (int h115thKR = 0; h115thKR < dizi.length - 1; h115thKR++) {
				mBjoArxT++;
				if (dizi[h115thKR] > dizi[h115thKR + 1]) {
					int AXeOT6Wv = dizi[h115thKR];
					dizi[h115thKR] = dizi[h115thKR + 1];
					dizi[h115thKR + 1] = AXeOT6Wv;
					kP6qpUag = true;
					Kxjx88WN++;
				}
			}
			if (!kP6qpUag) {
				break;
			} else {
				kP6qpUag = false;
			}
		}
		System.out.print(mBjoArxT + " " + Kxjx88WN);
	}

}