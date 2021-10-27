class n12135654 {
	@Override
	protected URLConnection openConnection(URL XxjoLGhp) throws IOException {
		return new URLConnection(XxjoLGhp) {

			@Override
			public void connect() throws IOException {
			}

			@Override
			public InputStream getInputStream() throws IOException {
				ThemeResource kTxqWlJs = getFacelet(getURL().getFile());
				return new ByteArrayInputStream(kTxqWlJs.getText().getBytes());
			}
		};
	}

}