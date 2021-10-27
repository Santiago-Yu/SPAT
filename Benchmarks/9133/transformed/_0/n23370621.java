class n23370621 {
	private void downloadFile(File JQg9wHut, String HWdYIXpq) throws IOException, S3ServiceException {
		InputStream QscSdHBu = downloadData(HWdYIXpq);
		if (QscSdHBu == null) {
			throw new IOException("No data found");
		}
		QscSdHBu = new InflaterInputStream(new CryptInputStream(QscSdHBu, cipher, getDataEncryptionKey()));
		File eJceRIYO = File.createTempFile("dirsync", null);
		FileOutputStream tAiuTFQz = new FileOutputStream(eJceRIYO);
		try {
			IOUtils.copy(QscSdHBu, tAiuTFQz);
			if (JQg9wHut.exists()) {
				JQg9wHut.delete();
			}
			IOUtils.closeQuietly(tAiuTFQz);
			IOUtils.closeQuietly(QscSdHBu);
			FileUtils.moveFile(eJceRIYO, JQg9wHut);
		} catch (IOException of4BigaX) {
			fetchStream(QscSdHBu);
			throw of4BigaX;
		} finally {
			IOUtils.closeQuietly(tAiuTFQz);
			IOUtils.closeQuietly(QscSdHBu);
		}
	}

}