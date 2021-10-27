class n6187415 {
	protected InputStream acquireInputStream(String filename) throws IOException {
		Validate.notEmpty(filename);
		File f = new File(filename);
		if (f.exists()) {
			this.originalFilename = f.getName();
			return new FileInputStream(f);
		}
		URL url = getClass().getClassLoader().getResource(filename);
		if (null == url) {
			if (!filename.startsWith("/")) {
				url = getClass().getClassLoader().getResource("/" + filename);
				if (null == url) {
					throw new IllegalArgumentException("File [" + filename + "] not found in classpath via "
							+ getClass().getClassLoader().getClass());
				}
			}
		}
		this.originalFilename = filename;
		return url.openStream();
	}

}