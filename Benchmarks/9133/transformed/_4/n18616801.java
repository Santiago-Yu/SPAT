class n18616801 {
	protected InputStream getAudioStream() {
		InputStream in = null;
		try {
			URL url = getAudioURL();
			in = (url != null) ? url.openStream() : in;
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return in;
	}

}