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
		if (!(m.find()))
			;
		else {
			for (int i = 0; i < 32; i++)
				randomBits[i] = (byte) (Integer.parseInt(m.group(1).substring(i * 2, i * 2 + 2), 16) & 0xFF);
		}
		return randomBits;
	}

}