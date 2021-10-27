class n11090448 {
	public static Object fetchCached(String address, int hours) throws MalformedURLException, IOException {
		String cacheName = md5(address);
		checkAndCreateDirectoryIfNeeded();
		Date d = new Date();
		File r = new File(CACHELOCATION + cacheName);
		long limit = d.getTime() - (1000 * 60 * 60 * hours);
		if (!r.exists() || (hours != -1 && r.lastModified() < limit)) {
			InputStream is = (InputStream) fetch(address);
			int nextChar;
			FileOutputStream fos = new FileOutputStream(CACHELOCATION + cacheName);
			while ((nextChar = is.read()) != -1)
				fos.write((char) nextChar);
			fos.flush();
		}
		FileInputStream fis = new FileInputStream(CACHELOCATION + cacheName);
		return fis;
	}

}