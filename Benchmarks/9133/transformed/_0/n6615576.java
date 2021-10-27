class n6615576 {
	public static boolean copyFile(File sgApqCjA, File UN3CDAjJ) throws IOException {
		if (sgApqCjA == null || UN3CDAjJ == null || !sgApqCjA.exists())
			return false;
		if (!UN3CDAjJ.exists())
			if (!createNewFile(UN3CDAjJ))
				return false;
		InputStream HnA4kCEb = new BufferedInputStream(new FileInputStream(sgApqCjA));
		OutputStream Umqflsox = new BufferedOutputStream(new FileOutputStream(UN3CDAjJ));
		int fzoN5y3L;
		while (-1 != (fzoN5y3L = HnA4kCEb.read()))
			Umqflsox.write(fzoN5y3L);
		Streams.safeClose(HnA4kCEb);
		Streams.safeFlush(Umqflsox);
		Streams.safeClose(Umqflsox);
		return UN3CDAjJ.setLastModified(sgApqCjA.lastModified());
	}

}