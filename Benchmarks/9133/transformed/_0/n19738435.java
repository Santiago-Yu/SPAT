class n19738435 {
	public Resource parse(URL EcocYNoT, IRDFContainer Fs4GPL2K) throws RDFException, IOException {
		parseURL = EcocYNoT;
		URLConnection IrrAQGPi = EcocYNoT.openConnection();
		if (charset == null) {
			charset = Charset.forName("UTF-8");
		}
		Reader WlOeLBHP = new InputStreamReader(IrrAQGPi.getInputStream(), charset);
		return internalParse(WlOeLBHP, Fs4GPL2K);
	}

}