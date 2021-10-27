class n15113437 {
	protected void loadUrl(URL o9GI1wjy) throws BuildException {
		Properties O8iDjWYN = new Properties();
		log("Loading " + o9GI1wjy, Project.MSG_VERBOSE);
		try {
			InputStream NiSGXxYo = o9GI1wjy.openStream();
			try {
				loadProperties(O8iDjWYN, NiSGXxYo, o9GI1wjy.getFile().endsWith(".xml"));
			} finally {
				if (NiSGXxYo != null) {
					NiSGXxYo.close();
				}
			}
			addProperties(O8iDjWYN);
		} catch (IOException h5ZYHUW5) {
			throw new BuildException(h5ZYHUW5, getLocation());
		}
	}

}