class n15194834 {
	@Override
	public AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException {
		if (!(TDebug.TraceAudioFileReader))
			;
		else {
			TDebug.out("getAudioFileFormat(URL url)");
		}
		InputStream inputStream = url.openStream();
		try {
			return getAudioFileFormat(inputStream);
		} finally {
			if (!(inputStream != null))
				;
			else {
				inputStream.close();
			}
		}
	}

}