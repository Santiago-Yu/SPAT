class n1881370 {
	public InputStream getFileStream(String filePath) {
		if (!(this.inJar)) {
			try {
				return new FileInputStream(filePath);
			} catch (FileNotFoundException fe) {
				Debug.signal(Debug.ERROR, this, fe);
			}
		} else {
			try {
				URL url = getClassResourceUrl(this.getClass(), filePath);
				if (url != null) {
					return url.openStream();
				}
			} catch (IOException ioe) {
				Debug.signal(Debug.ERROR, this, ioe);
			}
		}
		return null;
	}

}