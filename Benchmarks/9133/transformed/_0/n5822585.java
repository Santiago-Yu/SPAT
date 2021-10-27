class n5822585 {
	public static void copyFile(final FileInputStream JfIAr69x, final File BGBuIrSn) throws IOException {
		final FileChannel TFdPgaIp = JfIAr69x.getChannel();
		final FileChannel QrCXK7th = new FileOutputStream(BGBuIrSn).getChannel();
		try {
			TFdPgaIp.transferTo(0, TFdPgaIp.size(), QrCXK7th);
		} catch (final IOException hII5P7gR) {
			throw hII5P7gR;
		} finally {
			if (TFdPgaIp != null)
				TFdPgaIp.close();
			if (QrCXK7th != null)
				QrCXK7th.close();
		}
	}

}