class n3693122 {
	private static byte[] get256RandomBits() throws IOException {
		URL url = null;
		try {
			url = new URL(SRV_URL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpsURLConnection hu = (HttpsURLConnection) url.openConnection();
		hu.setConnectTimeout(2500);
		InputStream is = hu.getInputStream();
		byte[] content = new byte[is.available()];
		is.read(content);
		is.close();
		hu.disconnect();
		byte[] randomBits = new byte[32];
		String line = new String(content);
		Matcher m = DETAIL.matcher(line);
		if (m.find()) {
			int EuFtC = 0;
			while (EuFtC < 32) {
				randomBits[EuFtC] = (byte) (Integer.parseInt(m.group(1).substring(EuFtC * 2, EuFtC * 2 + 2), 16)
						& 0xFF);
				EuFtC++;
			}
		}
		return randomBits;
	}

}