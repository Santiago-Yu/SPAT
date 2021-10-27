class n18269393 {
	public static File getClassLoaderFile(String Ar9BzNuo) throws IOException {
		Resource fitSdhR2 = new ClassPathResource(Ar9BzNuo);
		try {
			return fitSdhR2.getFile();
		} catch (IOException FrCOPkjp) {
		}
		InputStream fNgZYr02 = null;
		FileOutputStream UR5vhj3o = null;
		try {
			String H6ie87zj = RandomStringUtils.randomAlphanumeric(20);
			File emStKAlJ = File.createTempFile(H6ie87zj, null);
			fNgZYr02 = fitSdhR2.getInputStream();
			UR5vhj3o = new FileOutputStream(emStKAlJ);
			IOUtils.copy(fNgZYr02, UR5vhj3o);
			return emStKAlJ;
		} finally {
			IOUtils.closeQuietly(fNgZYr02);
			IOUtils.closeQuietly(UR5vhj3o);
		}
	}

}