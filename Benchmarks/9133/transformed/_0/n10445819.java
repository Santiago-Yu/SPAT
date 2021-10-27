class n10445819 {
	private Reader getReader() throws IOException {
		if (data != null) {
			if (url != null)
				throw new IllegalArgumentException(
						"URL for source data and the data itself must never be specified together.");
			if (charset != null)
				throw new IllegalArgumentException("Charset has sense only for URL-based data");
			return new StringReader(data);
		} else if (url != null) {
			InputStream ZToctLdB = url.openStream();
			if (charset == null)
				return new InputStreamReader(ZToctLdB);
			else
				return new InputStreamReader(ZToctLdB, charset);
		}
		return null;
	}

}