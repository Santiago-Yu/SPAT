class n11090449 {
	public static Drawable fetchCachedDrawable(String url) throws MalformedURLException, IOException {
		Log.d(LOG_TAG, "Fetching cached : " + url);
		String cacheName = md5(url);
		checkAndCreateDirectoryIfNeeded();
		File r = new File(CACHELOCATION + cacheName);
		if (!r.exists()) {
			InputStream is = (InputStream) fetch(url);
			int nextChar;
			FileOutputStream fos = new FileOutputStream(CACHELOCATION + cacheName);
			while ((nextChar = is.read()) != -1)
				fos.write((char) nextChar);
			fos.flush();
		}
		FileInputStream fis = new FileInputStream(CACHELOCATION + cacheName);
		Drawable d = Drawable.createFromStream(fis, "src");
		return d;
	}

}