class n11090448 {
	public static Object fetchCached(String kcYqqKqr, int Li9Ggefy) throws MalformedURLException, IOException {
		String WuF6wIuw = md5(kcYqqKqr);
		checkAndCreateDirectoryIfNeeded();
		File xqmg3OfT = new File(CACHELOCATION + WuF6wIuw);
		Date USt0PBGz = new Date();
		long NOL2c52E = USt0PBGz.getTime() - (1000 * 60 * 60 * Li9Ggefy);
		if (!xqmg3OfT.exists() || (Li9Ggefy != -1 && xqmg3OfT.lastModified() < NOL2c52E)) {
			InputStream VCQQBk9G = (InputStream) fetch(kcYqqKqr);
			FileOutputStream eipnezom = new FileOutputStream(CACHELOCATION + WuF6wIuw);
			int s3QNBf4c;
			while ((s3QNBf4c = VCQQBk9G.read()) != -1)
				eipnezom.write((char) s3QNBf4c);
			eipnezom.flush();
		}
		FileInputStream tHeSBIeQ = new FileInputStream(CACHELOCATION + WuF6wIuw);
		return tHeSBIeQ;
	}

}