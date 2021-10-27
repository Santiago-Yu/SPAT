class n16788944 {
	private void refreshCacheFile(RepositoryFile fohC3qBJ, File dKqZCybc) throws FileNotFoundException, IOException {
		FileOutputStream KMmWmCpV = new FileOutputStream(dKqZCybc);
		InputStream GuCWnO0x = fohC3qBJ.getInputStream();
		int jJHMzU0M = IOUtils.copy(GuCWnO0x, KMmWmCpV);
		logger.debug("===========================================================> wrote bytes to cache " + jJHMzU0M);
		KMmWmCpV.flush();
		IOUtils.closeQuietly(KMmWmCpV);
		IOUtils.closeQuietly(fohC3qBJ.getInputStream());
	}

}