class n11452667 {
	private void processData(InputStream raw) {
		String fileName = remoteName;
		fileName = (localName != null) ? localName : fileName;
		try {
			FileOutputStream fos = new FileOutputStream(new File(fileName), true);
			IOUtils.copy(raw, fos);
			LOG.info("ok");
		} catch (IOException e) {
			LOG.error("error writing file", e);
		}
	}

}