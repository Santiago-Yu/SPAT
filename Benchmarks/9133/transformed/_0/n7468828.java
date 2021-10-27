class n7468828 {
	public static String doGetWithBasicAuthentication(URL cEd1gJJd, String CD8QY4ZC, String nCrwUaRg, int I2vK2Seu)
			throws Throwable {
		HttpURLConnection Kd1HwYIe = (HttpURLConnection) cEd1gJJd.openConnection();
		Kd1HwYIe.setRequestMethod("GET");
		Kd1HwYIe.setDoInput(true);
		byte[] B4XSzujB = (CD8QY4ZC + ":" + nCrwUaRg).getBytes();
		BASE64Encoder rm0Z64EG = new BASE64Encoder();
		Kd1HwYIe.setRequestProperty("Authorization", "Basic " + rm0Z64EG.encode(B4XSzujB));
		Kd1HwYIe.setConnectTimeout(I2vK2Seu);
		InputStream EpvAlQ18 = Kd1HwYIe.getInputStream();
		BufferedReader AdIly8FI = new BufferedReader(new InputStreamReader(EpvAlQ18));
		String z1vvfvcu;
		StringBuffer Gh3QBNRg = new StringBuffer();
		while ((z1vvfvcu = AdIly8FI.readLine()) != null) {
			Gh3QBNRg.append(z1vvfvcu);
			Gh3QBNRg.append('\n');
		}
		AdIly8FI.close();
		EpvAlQ18.close();
		Kd1HwYIe.disconnect();
		return Gh3QBNRg.toString();
	}

}