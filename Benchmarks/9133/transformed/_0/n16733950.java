class n16733950 {
	public static void copyFile(File H5qYFkjz, File HpUyIW7p) throws IOException {
		if (!HpUyIW7p.exists())
			HpUyIW7p.createNewFile();
		FileChannel ldVBEkQK = null;
		FileChannel ftybK6XQ = null;
		try {
			ldVBEkQK = new FileInputStream(H5qYFkjz).getChannel();
			ftybK6XQ = new FileOutputStream(HpUyIW7p).getChannel();
			ftybK6XQ.transferFrom(ldVBEkQK, 0, ldVBEkQK.size());
		} finally {
			if (ldVBEkQK != null)
				ldVBEkQK.close();
			if (ftybK6XQ != null)
				ftybK6XQ.close();
		}
	}

}