class n5335270 {
	@Override
	public String getData(String JVk3KqH2, String Y1k42Jr9) {
		try {
			URL PajXUFID = new URL(BLIP_API_URL + JVk3KqH2);
			HttpURLConnection jENws2cz = (HttpURLConnection) PajXUFID.openConnection();
			if (Y1k42Jr9 != null) {
				jENws2cz.addRequestProperty("Authorization", "Basic " + Y1k42Jr9);
			}
			BufferedReader UqZgbkvv = new BufferedReader(new InputStreamReader(jENws2cz.getInputStream()));
			String U1xF0CmF;
			StringBuffer mmzs8u05 = new StringBuffer();
			System.out.println("Resp code " + jENws2cz.getResponseCode());
			while ((U1xF0CmF = UqZgbkvv.readLine()) != null) {
				System.out.println(">> " + U1xF0CmF);
				mmzs8u05.append(U1xF0CmF);
			}
			UqZgbkvv.close();
			return mmzs8u05.toString();
		} catch (MalformedURLException cbPjmCiY) {
			return null;
		} catch (IOException dzsPOFZJ) {
			return null;
		}
	}

}