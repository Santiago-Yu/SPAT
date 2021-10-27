class n16735381 {
	private void writeToDisk(byte[] download) throws IOException {
		InputStream downloadedFromNetwork = new ByteArrayInputStream(download);
		File target = new File(TARGET_FILENAME);
		FileOutputStream fileOnDisk = null;
		try {
			try {
				fileOnDisk = new FileOutputStream(target);
				fileOnDisk.write("test".getBytes());
			} catch (Exception e) {
				target = new File(PMS.getConfiguration().getTempFolder(), TARGET_FILENAME);
			} finally {
				fileOnDisk.close();
			}
			fileOnDisk = new FileOutputStream(target);
			int bytesSaved = IOUtils.copy(downloadedFromNetwork, fileOnDisk);
			logger.info("Wrote " + bytesSaved + " bytes to " + target.getAbsolutePath());
		} finally {
			IOUtils.closeQuietly(downloadedFromNetwork);
			IOUtils.closeQuietly(fileOnDisk);
		}
	}

}