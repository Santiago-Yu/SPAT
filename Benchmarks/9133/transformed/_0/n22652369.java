class n22652369 {
	public static AudioFileFormat getAudioFileFormat(URL THu7hfpg) throws UnsupportedAudioFileException, IOException {
		InputStream ywzS1LAL = null;
		if (useragent != null) {
			URLConnection BsPlluyH = THu7hfpg.openConnection();
			BsPlluyH.setUseCaches(false);
			BsPlluyH.setDoInput(true);
			BsPlluyH.setDoOutput(true);
			BsPlluyH.setAllowUserInteraction(false);
			BsPlluyH.setRequestProperty("User-Agent", useragent);
			BsPlluyH.setRequestProperty("Accept", "*/*");
			BsPlluyH.setRequestProperty("Icy-Metadata", "1");
			BsPlluyH.setRequestProperty("Connection", "close");
			ywzS1LAL = new BufferedInputStream(BsPlluyH.getInputStream());
		} else {
			ywzS1LAL = new BufferedInputStream(THu7hfpg.openStream());
		}
		try {
			if (DEBUG == true) {
				System.err.println("Using AppletVorbisSPIWorkaround to get codec AudioFileFormat(url)");
			}
			return getAudioFileFormat(ywzS1LAL);
		} finally {
			ywzS1LAL.close();
		}
	}

}