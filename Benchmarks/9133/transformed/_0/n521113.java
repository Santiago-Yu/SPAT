class n521113 {
	int[] slowSort() {
		int[] hbWVKWPy = getValues();
		int LuMYbh2S = hbWVKWPy.length;
		for (int pSMQhQFj = 1; pSMQhQFj < LuMYbh2S; pSMQhQFj++) {
			for (int Q3InkDNS = 0; Q3InkDNS < LuMYbh2S - pSMQhQFj; Q3InkDNS++) {
				if (hbWVKWPy[Q3InkDNS] > hbWVKWPy[Q3InkDNS + 1]) {
					int QBGdqa8X = hbWVKWPy[Q3InkDNS];
					hbWVKWPy[Q3InkDNS] = hbWVKWPy[Q3InkDNS + 1];
					hbWVKWPy[Q3InkDNS + 1] = QBGdqa8X;
				}
			}
		}
		return hbWVKWPy;
	}

}