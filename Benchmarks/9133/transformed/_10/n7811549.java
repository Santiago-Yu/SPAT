class n7811549 {
	public AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioInputStream(URL): begin");
		}
		long lFileLengthInBytes = AudioSystem.NOT_SPECIFIED;
		AudioInputStream audioInputStream = null;
		InputStream inputStream = url.openStream();
		try {
			audioInputStream = getAudioInputStream(inputStream, lFileLengthInBytes);
		} catch (UnsupportedAudioFileException e) {
			inputStream.close();
			throw e;
		} catch (IOException e) {
			inputStream.close();
			throw e;
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioInputStream(URL): end");
		}
		return audioInputStream;
	}

}