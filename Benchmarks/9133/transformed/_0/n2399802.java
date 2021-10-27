class n2399802 {
	public static InputStream getInputStream(String bF1FWH9z) throws IOException {
		InputStream DJWDPHIt;
		if (bF1FWH9z.startsWith("http:")) {
			URL zJCJIH3L = new URL(bF1FWH9z);
			URLConnection IFL1Zrd2 = zJCJIH3L.openConnection();
			DJWDPHIt = IFL1Zrd2.getInputStream();
		} else {
			DJWDPHIt = new FileInputStream(bF1FWH9z);
		}
		return DJWDPHIt;
	}

}