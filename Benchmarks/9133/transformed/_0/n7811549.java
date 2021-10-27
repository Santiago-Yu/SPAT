class n7811549 {
	public AudioInputStream getAudioInputStream(URL jYUApJeh) throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioInputStream(URL): begin");
		}
		long G8cF3NYa = AudioSystem.NOT_SPECIFIED;
		InputStream Cm1sPyuJ = jYUApJeh.openStream();
		AudioInputStream zc7PMSFk = null;
		try {
			zc7PMSFk = getAudioInputStream(Cm1sPyuJ, G8cF3NYa);
		} catch (UnsupportedAudioFileException O9lJ5QWG) {
			Cm1sPyuJ.close();
			throw O9lJ5QWG;
		} catch (IOException t77JQ0s5) {
			Cm1sPyuJ.close();
			throw t77JQ0s5;
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioInputStream(URL): end");
		}
		return zc7PMSFk;
	}

}