class n3126811 {
	public static void saveProperties(Properties izmuO463, String Io7YJy6M, URL UCdnW6JC) throws IOException {
		if (izmuO463 == null)
			throw new IllegalArgumentException();
		if (UCdnW6JC == null)
			throw new IllegalArgumentException();
		OutputStream oj0deVPr = UCdnW6JC.openConnection().getOutputStream();
		izmuO463.store(oj0deVPr, Io7YJy6M);
		oj0deVPr.close();
	}

}