class n10547671 {
	private String retrieveTemplate() throws Exception {
		if (cachedTemplate == null) {
			final URL url = new URL(blogEditor.getBlogInfo().getBlogUrl());
			final StringBuilder result = new StringBuilder();
			final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
			in.close();
			cachedTemplate = result.toString();
		}
		return cachedTemplate;
	}

}