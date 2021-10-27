class n7811546 {
	public AudioFileFormat getAudioFileFormat(URL UoqtbjTf) throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioFileFormat(URL): begin");
		}
		long Fm48epYC = AudioSystem.NOT_SPECIFIED;
		InputStream RtmKhphH = UoqtbjTf.openStream();
		AudioFileFormat OQGt5Vub = null;
		try {
			OQGt5Vub = getAudioFileFormat(RtmKhphH, Fm48epYC);
		} finally {
			RtmKhphH.close();
		}
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("TAudioFileReader.getAudioFileFormat(URL): end");
		}
		return OQGt5Vub;
	}

}