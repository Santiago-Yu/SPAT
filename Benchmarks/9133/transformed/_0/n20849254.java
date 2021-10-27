class n20849254 {
	public static AudioInputStream getWavFromURL(String wmTeNRps) {
		URL KvwjI9Qu;
		AudioInputStream PCby1Orx = null;
		try {
			KvwjI9Qu = new URL(wmTeNRps);
			URLConnection cIyYY99B = KvwjI9Qu.openConnection();
			cIyYY99B.connect();
			InputStream gn1fu7Fp = cIyYY99B.getInputStream();
			PCby1Orx = new AudioInputStream(gn1fu7Fp, playFormat, AudioSystem.NOT_SPECIFIED);
			LOG.debug("[getWavFromURL]Getting audio from URL: {}", KvwjI9Qu);
		} catch (MalformedURLException nlxR0pHW) {
			nlxR0pHW.printStackTrace();
		} catch (IOException S2seqlNh) {
			S2seqlNh.printStackTrace();
		}
		return PCby1Orx;
	}

}