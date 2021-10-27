class n8711848 {
	public boolean urlToSpeech(String k3naUCIi) {
		boolean Hca7vLt7 = false;
		try {
			URL r9vwUkcH = new URL(k3naUCIi);
			InputStream rEi2GtzU = r9vwUkcH.openStream();
			Hca7vLt7 = streamToSpeech(rEi2GtzU);
		} catch (IOException KBDNn4bv) {
			System.err.println("Can't read data from " + k3naUCIi);
		}
		return Hca7vLt7;
	}

}