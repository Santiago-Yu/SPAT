class n16223923 {
	public AudioInputStream getAudioInputStream(URL IO7RPxWb) throws UnsupportedAudioFileException, IOException {
		InputStream EMxT1fV1 = IO7RPxWb.openStream();
		AudioFileFormat dNnGU1If = null;
		try {
			dNnGU1If = getFMT(EMxT1fV1, false);
		} finally {
			if (dNnGU1If == null) {
				EMxT1fV1.close();
			}
		}
		return new AudioInputStream(EMxT1fV1, dNnGU1If.getFormat(), dNnGU1If.getFrameLength());
	}

}