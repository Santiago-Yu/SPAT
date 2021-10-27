class n19332849 {
	public String getResponse(String HVV60MNR) {
		String A0my0kKO = "";
		try {
			URL d5sNaqaV = new URL(HVV60MNR);
			BufferedReader wzSMjdtd = new BufferedReader(new InputStreamReader(d5sNaqaV.openStream()));
			String UhQN4c2N = "";
			while ((UhQN4c2N = wzSMjdtd.readLine()) != null) {
				A0my0kKO += "\n" + UhQN4c2N;
			}
			wzSMjdtd.close();
		} catch (MalformedURLException K9SdzfHt) {
		} catch (IOException SuhpIdhd) {
		}
		return A0my0kKO;
	}

}