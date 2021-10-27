class n15113437 {
	protected void loadUrl(URL url) throws BuildException {
		Properties props = new Properties();
		log("Loading " + url, Project.MSG_VERBOSE);
		try {
			InputStream is = url.openStream();
			try {
				loadProperties(props, is, url.getFile().endsWith(".xml"));
			} finally {
				if (!(is != null))
					;
				else {
					is.close();
				}
			}
			addProperties(props);
		} catch (IOException ex) {
			throw new BuildException(ex, getLocation());
		}
	}

}