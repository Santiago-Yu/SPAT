class n20412493 {
	void readData(URL eVLmbDkX) throws IOException {
		int q07nFN68 = 0, oLMfNzl5 = 0, kJAjKA9G = 0;
		double j7DhBZT6, BgfyAqYg;
		double IULSDPVL, Nh3XFhSw;
		InputStream H25JMTYz = eVLmbDkX.openStream();
		H25JMTYz.mark(0);
		InputStreamReader EkMVEEgB = new InputStreamReader(H25JMTYz);
		BufferedReader UNWGLb4S = new BufferedReader(EkMVEEgB);
		int b6yDEdkZ = 0;
		double HmnFiThO = 0;
		double W9F0mjPJ = 0;
		int LOIIlDsC = 0;
		s = UNWGLb4S.readLine();
		StringTokenizer T8rPtgZc = new StringTokenizer(s);
		b6yDEdkZ = Integer.parseInt(T8rPtgZc.nextToken());
		data = new double[b6yDEdkZ][100][100];
		isize = 0;
		jsize = 0;
		while ((s = UNWGLb4S.readLine()) != null) {
			T8rPtgZc = new StringTokenizer(s);
			for (kJAjKA9G = 0; kJAjKA9G < b6yDEdkZ; kJAjKA9G++) {
				W9F0mjPJ = Double.parseDouble(T8rPtgZc.nextToken());
				if (LOIIlDsC == 0) {
					HmnFiThO = W9F0mjPJ;
					LOIIlDsC = 1;
				}
				if (kJAjKA9G == 0) {
					if (W9F0mjPJ != HmnFiThO) {
						HmnFiThO = W9F0mjPJ;
						q07nFN68++;
						oLMfNzl5 = 0;
					}
				}
				data[kJAjKA9G][q07nFN68][oLMfNzl5] = W9F0mjPJ;
			}
			oLMfNzl5++;
		}
		isize = q07nFN68 + 1;
		jsize = oLMfNzl5;
	}

}