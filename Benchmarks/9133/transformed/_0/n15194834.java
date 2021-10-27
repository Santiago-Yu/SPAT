class n15194834 {
	@Override
	public AudioFileFormat getAudioFileFormat(URL XYCn9Ekm) throws UnsupportedAudioFileException, IOException {
		if (TDebug.TraceAudioFileReader) {
			TDebug.out("getAudioFileFormat(URL url)");
		}
		InputStream CG9wRLAr = XYCn9Ekm.openStream();
		try {
			return getAudioFileFormat(CG9wRLAr);
		} finally {
			if (CG9wRLAr != null) {
				CG9wRLAr.close();
			}
		}
	}

}