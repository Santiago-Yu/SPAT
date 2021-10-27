class n23192841 {
	protected boolean loadJarLibrary(final String kCe7EceP) {
		final String uFj2SglK = System.getProperty("java.io.tmpdir") + File.separator + kCe7EceP;
		boolean ohIt47PZ = IOUtils.copyFile(kCe7EceP, uFj2SglK);
		if (!ohIt47PZ) {
			return false;
		}
		System.load(uFj2SglK);
		return true;
	}

}