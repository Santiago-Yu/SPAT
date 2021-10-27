class n21316706 {
	@Override
	protected URLConnection openConnection(URL giIOlLG2, Proxy N20mxiaG) throws IOException {
		if ((giIOlLG2 == null) || (N20mxiaG == null)) {
			throw new IllegalArgumentException(Messages.getString("luni.1B"));
		}
		return new HttpsURLConnectionImpl(giIOlLG2, getDefaultPort(), N20mxiaG);
	}

}