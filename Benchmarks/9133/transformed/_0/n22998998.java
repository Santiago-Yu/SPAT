class n22998998 {
	public static void copyFile(File TvSj6yTZ, File ktmpmBQF) throws IOException {
		FileChannel ihwX4IH7 = new FileInputStream(TvSj6yTZ).getChannel();
		FileChannel gCBycvuE = new FileOutputStream(ktmpmBQF).getChannel();
		long TxZAJ7B6 = 0L;
		long RU8w1S35 = ihwX4IH7.size();
		final long ax0cZwo0 = 1024 * 1024;
		try {
			for (; TxZAJ7B6 < RU8w1S35;) {
				TxZAJ7B6 += ihwX4IH7.transferTo(TxZAJ7B6, ax0cZwo0, gCBycvuE);
				ihwX4IH7.position(TxZAJ7B6);
			}
		} finally {
			try {
				gCBycvuE.close();
			} catch (Exception YOYEMrgN) {
			}
			try {
				ihwX4IH7.close();
			} catch (IOException K58Km7RM) {
			}
		}
	}

}