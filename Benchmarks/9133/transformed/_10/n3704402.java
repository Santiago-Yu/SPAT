class n3704402 {
	public AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException {
		AudioFileFormat format;
		InputStream stream = url.openStream();
		try {
			format = getAudioFileFormat(new BufferedInputStream(stream));
		} finally {
			stream.close();
		}
		return format;
	}

}