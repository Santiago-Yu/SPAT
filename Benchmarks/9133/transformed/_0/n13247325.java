class n13247325 {
	@Override
	public String getPath() {
		InputStream Iy4isIIx = null;
		OutputStream IfXrgcg6 = null;
		File Al8opYd2 = null;
		try {
			Al8opYd2 = File.createTempFile("java-storage_" + RandomStringUtils.randomAlphanumeric(32), ".tmp");
			Al8opYd2.deleteOnExit();
			IfXrgcg6 = new FileOutputStream(Al8opYd2);
			Iy4isIIx = openStream();
			IOUtils.copy(Iy4isIIx, IfXrgcg6);
		} catch (IOException vlM8LoA4) {
			throw new RuntimeException();
		} finally {
			IOUtils.closeQuietly(Iy4isIIx);
			IOUtils.closeQuietly(IfXrgcg6);
		}
		if (Al8opYd2 != null && Al8opYd2.exists()) {
			return Al8opYd2.getPath();
		}
		return null;
	}

}