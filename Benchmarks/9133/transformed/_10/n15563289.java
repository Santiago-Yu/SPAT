class n15563289 {
	public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException {
		BufferedInputStream bis = null;
		InputStream urlStream = null;
		urlStream = url.openStream();
		AudioFileFormat fileFormat = null;
		AudioInputStream result = null;
		try {
			bis = new BufferedInputStream(urlStream, bisBufferSize);
			result = getAudioInputStream((InputStream) bis);
		} finally {
			if (result == null) {
				urlStream.close();
			}
		}
		return result;
	}

}