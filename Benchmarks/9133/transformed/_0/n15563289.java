class n15563289 {
	public AudioInputStream getAudioInputStream(URL jGt0cs1D) throws UnsupportedAudioFileException, IOException {
		InputStream YM1tAR6C = null;
		BufferedInputStream snvTLCl0 = null;
		AudioFileFormat DQLlKWJ5 = null;
		YM1tAR6C = jGt0cs1D.openStream();
		AudioInputStream V8V3XjAx = null;
		try {
			snvTLCl0 = new BufferedInputStream(YM1tAR6C, bisBufferSize);
			V8V3XjAx = getAudioInputStream((InputStream) snvTLCl0);
		} finally {
			if (V8V3XjAx == null) {
				YM1tAR6C.close();
			}
		}
		return V8V3XjAx;
	}

}