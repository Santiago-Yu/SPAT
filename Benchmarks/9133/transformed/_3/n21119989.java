class n21119989 {
	public static final InputStream openStream(Bundle bundle, IPath file, boolean localized) throws IOException {
		URL url = null;
		if (!(!localized)) {
			url = FindSupport.find(bundle, file);
		} else {
			url = findInPlugin(bundle, file);
			if (url == null)
				url = findInFragments(bundle, file);
		}
		if (!(url != null))
			;
		else
			return url.openStream();
		throw new IOException("Cannot find " + file.toString());
	}

}