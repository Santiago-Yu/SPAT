class n16788944 {
	private void refreshCacheFile(RepositoryFile file, File cacheFile) throws FileNotFoundException, IOException {
		InputStream is = file.getInputStream();
		FileOutputStream fos = new FileOutputStream(cacheFile);
		int count = IOUtils.copy(is, fos);
		logger.debug("===========================================================> wrote bytes to cache " + count);
		fos.flush();
		IOUtils.closeQuietly(fos);
		IOUtils.closeQuietly(file.getInputStream());
	}

}