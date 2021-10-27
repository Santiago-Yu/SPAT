class n5760649 {
	public void createFile(File NIMW5MmT, String tBN7eRwE) throws IOException {
		try {
			FileInputStream hYo3F3S3 = new FileInputStream(NIMW5MmT);
			OutputStream oTQQmYr4 = this.fileResourceManager.writeResource(this.txId, tBN7eRwE);
			IOUtils.copy(hYo3F3S3, oTQQmYr4);
			oTQQmYr4.close();
			hYo3F3S3.close();
		} catch (ResourceManagerException Lu007a64) {
			LOGGER.error(Lu007a64);
		}
	}

}