class n16223923 {
	public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException {
		AudioFileFormat fileFormat = null;
		InputStream urlStream = url.openStream();
		try {
			fileFormat = getFMT(urlStream, false);
		} finally {
			if (fileFormat == null) {
				urlStream.close();
			}
		}
		return new AudioInputStream(urlStream, fileFormat.getFormat(), fileFormat.getFrameLength());
	}

}