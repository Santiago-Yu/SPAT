class n7811546 {
	public AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioFileFormat(URL): begin");
		}
		long lFileLengthInBytes = AudioSystem.NOT_SPECIFIED;
		AudioFileFormat audioFileFormat = null;
		InputStream inputStream = url.openStream();
		try {
			audioFileFormat = getAudioFileFormat(inputStream, lFileLengthInBytes);
		} finally {
			inputStream.close();
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioFileFormat(URL): end");
		}
		return audioFileFormat;
	}

}