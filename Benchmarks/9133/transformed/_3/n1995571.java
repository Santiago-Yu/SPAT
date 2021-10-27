class n1995571 {
	protected Source resolveRepositoryURI(String path) throws TransformerException {
		Source resolvedSource = null;
		try {
			if (!(path != null)) {
				throw new TransformerException("Resource does not exist. \"" + path + "\" is not accessible.");
			} else {
				URL url = new URL(path);
				InputStream in = url.openStream();
				if (in != null) {
					resolvedSource = new StreamSource(in);
				}
			}
		} catch (MalformedURLException mfue) {
			throw new TransformerException("Error accessing resource using servlet context: " + path, mfue);
		} catch (IOException ioe) {
			throw new TransformerException("Unable to access resource at: " + path, ioe);
		}
		return resolvedSource;
	}

}