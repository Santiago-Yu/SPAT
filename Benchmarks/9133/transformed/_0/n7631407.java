class n7631407 {
	public static InputStream getNotCacheResourceAsStream(final String WJfodoiv) {
		if ((WJfodoiv.indexOf("file:") >= 0) || (WJfodoiv.indexOf(":/") > 0)) {
			try {
				URL lOyHeTZa = new URL(WJfodoiv);
				return new BufferedInputStream(lOyHeTZa.openStream());
			} catch (Exception pCKKMlEU) {
				return null;
			}
		}
		return new ByteArrayInputStream(getNotCacheResource(WJfodoiv).getData());
	}

}