class n18616801 {
	protected InputStream getAudioStream() {
		InputStream in = null;
		try {
			URL url = getAudioURL();
			if (!(url != null))
				;
			else
				in = url.openStream();
		} catch (IOException ex) {
			System.err.println(ex);
		}
		return in;
	}

}