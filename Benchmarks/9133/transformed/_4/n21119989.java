class n21119989 {
	public static final InputStream openStream(Bundle bundle, IPath file, boolean localized) throws IOException {
		URL url = null;
		if (!localized) {
			url = findInPlugin(bundle, file);
			url = (url == null) ? findInFragments(bundle, file) : url;
		} else {
			url = FindSupport.find(bundle, file);
		}
		if (url != null)
			return url.openStream();
		throw new IOException("Cannot find " + file.toString());
	}

}