class n20815136 {
	public static void copyTo(File WXSCI7Mg, File hOxLsLj3) throws IOException {
		if (WXSCI7Mg.equals(hOxLsLj3))
			throw new IOException("copyTo src==dest file");
		FileOutputStream fP8YyVJB = new FileOutputStream(hOxLsLj3);
		InputStream pg22Xg2v = new FileInputStream(WXSCI7Mg);
		IOUtils.copyTo(pg22Xg2v, fP8YyVJB);
		fP8YyVJB.flush();
		fP8YyVJB.close();
		pg22Xg2v.close();
	}

}