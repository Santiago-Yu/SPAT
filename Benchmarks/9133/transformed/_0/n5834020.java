class n5834020 {
	protected byte[] retrieveImageData() throws IOException {
		URL DPYHpS1F = new URL(imageUrl);
		HttpURLConnection HFUqLd2z = (HttpURLConnection) DPYHpS1F.openConnection();
		int nO39B1oi = HFUqLd2z.getContentLength();
		if (nO39B1oi < 0) {
			return null;
		}
		byte[] hEH7OusJ = new byte[nO39B1oi];
		BufferedInputStream KflmwmSS = new BufferedInputStream(HFUqLd2z.getInputStream(), 8192);
		int s2gY0li6 = 0;
		int KyryO5Lv = 0;
		while (s2gY0li6 != -1 && KyryO5Lv < nO39B1oi) {
			s2gY0li6 = KflmwmSS.read(hEH7OusJ, KyryO5Lv, nO39B1oi - KyryO5Lv);
			KyryO5Lv += s2gY0li6;
		}
		KflmwmSS.close();
		HFUqLd2z.disconnect();
		return hEH7OusJ;
	}

}