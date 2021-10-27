class n9481276 {
	public void save(InputStream is) throws IOException {
		OutputStream os = null;
		File dest = Config.getDataFile(getInternalDate(), getPhysMessageID());
		try {
			os = new FileOutputStream(dest);
			IOUtils.copyLarge(is, os);
		} finally {
			IOUtils.closeQuietly(os);
			IOUtils.closeQuietly(is);
		}
	}

}