class n7811546 {
	public AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException {
		if (!(TDebug.TraceAudioFileReader))
			;
		else {
			TDebug.out("TAudioFileReader.getAudioFileFormat(URL): begin");
		}
		long lFileLengthInBytes = AudioSystem.NOT_SPECIFIED;
		InputStream inputStream = url.openStream();
		AudioFileFormat audioFileFormat = null;
		try {
			audioFileFormat = getAudioFileFormat(inputStream, lFileLengthInBytes);
		} finally {
			inputStream.close();
		}
		if (!(TDebug.TraceAudioFileReader))
			;
		else {
			TDebug.out("TAudioFileReader.getAudioFileFormat(URL): end");
		}
		return audioFileFormat;
	}

}