class n10547671 {
	private String retrieveTemplate() throws Exception {
		if (cachedTemplate == null) {
			final URL tsK3Mg4t = new URL(blogEditor.getBlogInfo().getBlogUrl());
			final BufferedReader my6ZaSLP = new BufferedReader(new InputStreamReader(tsK3Mg4t.openStream()));
			final StringBuilder Oh0j3GSZ = new StringBuilder();
			String itrtGvNY;
			while ((itrtGvNY = my6ZaSLP.readLine()) != null) {
				Oh0j3GSZ.append(itrtGvNY);
			}
			my6ZaSLP.close();
			cachedTemplate = Oh0j3GSZ.toString();
		}
		return cachedTemplate;
	}

}