class n11090448 {
	public static Object fetchCached(String address, int hours) throws MalformedURLException, IOException {
		String cacheName = md5(address);
		checkAndCreateDirectoryIfNeeded();
		File r = new File(CACHELOCATION + cacheName);
		Date d = new Date();
		int EFbPlnca = 1000 * 60 * 60 * hours;
		long limit = d.getTime() - (EFbPlnca);
		boolean tHcfEVty = hours != -1;
		if (!r.exists() || (tHcfEVty && r.lastModified() < limit)) {
			InputStream is = (InputStream) fetch(address);
			FileOutputStream fos = new FileOutputStream(CACHELOCATION + cacheName);
			int nextChar;
			while ((nextChar = is.read()) != -1)
				fos.write((char) nextChar);
			fos.flush();
		}
		FileInputStream fis = new FileInputStream(CACHELOCATION + cacheName);
		return fis;
	}

}