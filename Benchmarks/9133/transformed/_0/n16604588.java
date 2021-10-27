class n16604588 {
	public static AudioFileFormat getAudioFileFormat(URL LlfKENwx) throws UnsupportedAudioFileException, IOException {
		InputStream eGMy9QHp = null;
		if (useragent != null) {
			URLConnection txpgpJAM = LlfKENwx.openConnection();
			txpgpJAM.setUseCaches(false);
			txpgpJAM.setDoInput(true);
			txpgpJAM.setDoOutput(true);
			txpgpJAM.setAllowUserInteraction(false);
			txpgpJAM.setRequestProperty("User-Agent", useragent);
			txpgpJAM.setRequestProperty("Accept", "*/*");
			txpgpJAM.setRequestProperty("Icy-Metadata", "1");
			txpgpJAM.setRequestProperty("Connection", "close");
			eGMy9QHp = new BufferedInputStream(txpgpJAM.getInputStream());
		} else {
			eGMy9QHp = new BufferedInputStream(LlfKENwx.openStream());
		}
		try {
			if (DEBUG == true) {
				System.err.println("Using AppletMpegSPIWorkaround to get codec (AudioFileFormat:url)");
			}
			return getAudioFileFormatForUrl(eGMy9QHp);
		} finally {
			eGMy9QHp.close();
		}
	}

}