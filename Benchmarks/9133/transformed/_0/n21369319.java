class n21369319 {
	private String readLine(final String Zc2cRgL3) {
		BufferedReader HcRl8lNQ;
		String Oa2MTdm6 = null;
		try {
			URL zroxRcyK = new URL(Zc2cRgL3);
			HcRl8lNQ = new BufferedReader(new InputStreamReader(zroxRcyK.openStream()));
			Oa2MTdm6 = HcRl8lNQ.readLine();
		} catch (MalformedURLException cSriSS0d) {
			log.error(cSriSS0d, cSriSS0d);
		} catch (IOException AMWIC1Kd) {
			log.error(AMWIC1Kd, AMWIC1Kd);
		}
		return Oa2MTdm6;
	}

}