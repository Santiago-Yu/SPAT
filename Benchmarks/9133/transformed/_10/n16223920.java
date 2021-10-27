class n16223920 {
	public AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException {
		AudioFileFormat fileFormat = null;
		InputStream urlStream = url.openStream();
		try {
			fileFormat = getFMT(urlStream, false);
		} finally {
			urlStream.close();
		}
		return fileFormat;
	}

}