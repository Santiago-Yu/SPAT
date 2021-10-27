class n20267500 {
	public static AudioInputStream getWavFromURL(String sZC0T4sL) {
		URL dOFBiKal;
		AudioInputStream ALGQoHER = null;
		try {
			dOFBiKal = new URL(sZC0T4sL);
			URLConnection i7UEowdV = dOFBiKal.openConnection();
			i7UEowdV.connect();
			InputStream aQ6E8L9v = i7UEowdV.getInputStream();
			ALGQoHER = new AudioInputStream(aQ6E8L9v, playFormat, AudioSystem.NOT_SPECIFIED);
			LOG.debug("[getWavFromURL]Getting audio from URL: {0}");
		} catch (MalformedURLException cnriUPAc) {
			cnriUPAc.printStackTrace();
		} catch (IOException L1L5snQu) {
			L1L5snQu.printStackTrace();
		}
		return ALGQoHER;
	}

}