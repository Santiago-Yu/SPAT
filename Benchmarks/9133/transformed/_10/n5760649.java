class n5760649 {
	public void createFile(File src, String filename) throws IOException {
		try {
			OutputStream fos = this.fileResourceManager.writeResource(this.txId, filename);
			FileInputStream fis = new FileInputStream(src);
			IOUtils.copy(fis, fos);
			fos.close();
			fis.close();
		} catch (ResourceManagerException e) {
			LOGGER.error(e);
		}
	}

}