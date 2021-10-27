class n13247325 {
	@Override
	public String getPath() {
		OutputStream out = null;
		InputStream in = null;
		File file = null;
		try {
			file = File.createTempFile("java-storage_" + RandomStringUtils.randomAlphanumeric(32), ".tmp");
			file.deleteOnExit();
			in = openStream();
			out = new FileOutputStream(file);
			IOUtils.copy(in, out);
		} catch (IOException e) {
			throw new RuntimeException();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		if (file != null && file.exists()) {
			return file.getPath();
		}
		return null;
	}

}