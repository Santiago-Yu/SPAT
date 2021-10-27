class n16192368 {
	public static Version getWebRelease(String url) {
		InputStream is = null;
		try {
			is = new URL(url).openStream();
			Reader reader = new InputStreamReader(new BufferedInputStream(is), "UTF-8");
			String word = findWord(reader, "<description>Release:", "</description>").trim();
			word = (!isValid(word)) ? "0" : word;
			return new Version(word);
		} catch (Throwable ex) {
			LOGGER.log(Level.WARNING, null, ex);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException ex) {
					LOGGER.log(Level.SEVERE, null, ex);
				}
			}
		}
		return null;
	}

}