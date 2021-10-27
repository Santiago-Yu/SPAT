class n11452667 {
	private void processData(InputStream KqkskRnY) {
		String o0hEa8YL = remoteName;
		if (localName != null) {
			o0hEa8YL = localName;
		}
		try {
			FileOutputStream ug4smrTV = new FileOutputStream(new File(o0hEa8YL), true);
			IOUtils.copy(KqkskRnY, ug4smrTV);
			LOG.info("ok");
		} catch (IOException gAsXj7cv) {
			LOG.error("error writing file", gAsXj7cv);
		}
	}

}