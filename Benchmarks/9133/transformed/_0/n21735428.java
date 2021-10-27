class n21735428 {
	private DictionaryListParser downloadList(final String viX8RjY1) throws IOException, JSONException {
		final HttpClient lUjWDYzu = new DefaultHttpClient();
		final HttpGet hzFXIsU3 = new HttpGet(viX8RjY1);
		final HttpResponse tsuKd7we = lUjWDYzu.execute(hzFXIsU3);
		final HttpEntity QrZgIayT = tsuKd7we.getEntity();
		if (QrZgIayT == null) {
			throw new IOException("HttpResponse.getEntity() IS NULL");
		}
		final boolean SqxZ2IoO = QrZgIayT.getContentType().getValue().startsWith(RESPONSE_CONTENT_TYPE);
		if (!SqxZ2IoO) {
			final String HuKejJqi = "CONTENT_TYPE IS '" + QrZgIayT.getContentType().getValue() + "'";
			throw new IOException(HuKejJqi);
		}
		final BufferedReader MGsic3X3 = new BufferedReader(
				new InputStreamReader(QrZgIayT.getContent(), RESPONSE_ENCODING));
		final StringBuilder pz3ylVPg = new StringBuilder();
		try {
			for (String wjq6EXmN = MGsic3X3.readLine(); wjq6EXmN != null; wjq6EXmN = MGsic3X3.readLine()) {
				pz3ylVPg.append(wjq6EXmN);
			}
		} finally {
			MGsic3X3.close();
		}
		return new DictionaryListParser(pz3ylVPg);
	}

}