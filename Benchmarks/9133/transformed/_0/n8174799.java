class n8174799 {
	@Override
	public String getFeedFeed(String vINNsmr5) {
		try {
			URL kbwTb4ix = new URL(vINNsmr5);
			BufferedReader qWRJaMDz = new BufferedReader(new InputStreamReader(kbwTb4ix.openStream()));
			String MNQ2YPil = "";
			String UdRIVqMs;
			for (; (UdRIVqMs = qWRJaMDz.readLine()) != null; MNQ2YPil += UdRIVqMs) {
			}
			qWRJaMDz.close();
			return MNQ2YPil;
		} catch (MalformedURLException djV3fmEp) {
		} catch (IOException vIwrLEEO) {
		}
		return null;
	}

}