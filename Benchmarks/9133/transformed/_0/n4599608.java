class n4599608 {
	public static void main(String[] gQSCqmOg) {
		try {
			URL BMQ4pdw1 = new URL("http://localhost:6557");
			HttpURLConnection SZtgYwDz = (HttpURLConnection) BMQ4pdw1.openConnection();
			SZtgYwDz.setRequestMethod("HEAD");
			int hXSm9yzH = SZtgYwDz.getResponseCode();
			BufferedReader gCtkZavJ = new BufferedReader(new InputStreamReader(SZtgYwDz.getInputStream()));
			String mGYCaRtb;
			while ((mGYCaRtb = gCtkZavJ.readLine()) != null) {
				System.out.println(mGYCaRtb);
			}
			gCtkZavJ.close();
			SZtgYwDz.disconnect();
		} catch (Exception bBQI49zn) {
			Logger.getLogger(TestSSLConnection.class.getName()).log(Level.SEVERE, null, bBQI49zn);
		}
	}

}