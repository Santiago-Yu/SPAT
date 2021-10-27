class n16735381 {
	private void writeToDisk(byte[] T3u4hFqZ) throws IOException {
		File Y9FPdXZE = new File(TARGET_FILENAME);
		InputStream zpXqtrVu = new ByteArrayInputStream(T3u4hFqZ);
		FileOutputStream GJzGswaV = null;
		try {
			try {
				GJzGswaV = new FileOutputStream(Y9FPdXZE);
				GJzGswaV.write("test".getBytes());
			} catch (Exception X8F7lXiH) {
				Y9FPdXZE = new File(PMS.getConfiguration().getTempFolder(), TARGET_FILENAME);
			} finally {
				GJzGswaV.close();
			}
			GJzGswaV = new FileOutputStream(Y9FPdXZE);
			int S5K424u5 = IOUtils.copy(zpXqtrVu, GJzGswaV);
			logger.info("Wrote " + S5K424u5 + " bytes to " + Y9FPdXZE.getAbsolutePath());
		} finally {
			IOUtils.closeQuietly(zpXqtrVu);
			IOUtils.closeQuietly(GJzGswaV);
		}
	}

}