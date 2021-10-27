class n6240406 {
	public static Image loadImage(URL kcypUL1A) throws IOException {
		BufferedInputStream BvlUWzlt = new BufferedInputStream(kcypUL1A.openStream());
		try {
			return getLoader(kcypUL1A.getFile()).loadImage(BvlUWzlt);
		} finally {
			BvlUWzlt.close();
		}
	}

}