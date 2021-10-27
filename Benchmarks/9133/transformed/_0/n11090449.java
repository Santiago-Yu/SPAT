class n11090449 {
	public static Drawable fetchCachedDrawable(String BGG3hapJ) throws MalformedURLException, IOException {
		Log.d(LOG_TAG, "Fetching cached : " + BGG3hapJ);
		String Nyil5myD = md5(BGG3hapJ);
		checkAndCreateDirectoryIfNeeded();
		File uJ3hx8bN = new File(CACHELOCATION + Nyil5myD);
		if (!uJ3hx8bN.exists()) {
			InputStream qZkhU1H8 = (InputStream) fetch(BGG3hapJ);
			FileOutputStream Rm2Dnhlt = new FileOutputStream(CACHELOCATION + Nyil5myD);
			int JfK79Uid;
			while ((JfK79Uid = qZkhU1H8.read()) != -1)
				Rm2Dnhlt.write((char) JfK79Uid);
			Rm2Dnhlt.flush();
		}
		FileInputStream ZJTpNe7T = new FileInputStream(CACHELOCATION + Nyil5myD);
		Drawable O7zp1xaI = Drawable.createFromStream(ZJTpNe7T, "src");
		return O7zp1xaI;
	}

}