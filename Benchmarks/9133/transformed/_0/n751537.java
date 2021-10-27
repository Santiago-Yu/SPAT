class n751537 {
	void bubbleSort(int[] WpC3p4Mq) {
		int oUr3apFo = 0;
		int aIq1ztTt = WpC3p4Mq.length - 1;
		int rKgDvLof = 0;
		int t522EWLT = 0;
		while (t522EWLT == 0) {
			t522EWLT = 1;
			oUr3apFo = 0;
			while (oUr3apFo < aIq1ztTt) {
				if (WpC3p4Mq[oUr3apFo] > WpC3p4Mq[oUr3apFo + 1]) {
					rKgDvLof = WpC3p4Mq[oUr3apFo];
					WpC3p4Mq[oUr3apFo] = WpC3p4Mq[oUr3apFo + 1];
					WpC3p4Mq[oUr3apFo + 1] = rKgDvLof;
					t522EWLT = 0;
				}
				oUr3apFo = oUr3apFo + 1;
			}
			aIq1ztTt = aIq1ztTt - 1;
		}
	}

}