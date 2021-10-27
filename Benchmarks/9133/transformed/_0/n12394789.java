class n12394789 {
	public static void copyFile(File OcAr32Zd, File rjIItMKS, long KoOoYOSp) throws IOException {
		final FileChannel s3mwnp7d = new FileInputStream(OcAr32Zd).getChannel();
		final FileChannel n26U0BjD = new FileOutputStream(rjIItMKS).getChannel();
		if (KoOoYOSp == 0)
			KoOoYOSp = s3mwnp7d.size();
		try {
			final long urSqqjpb = s3mwnp7d.size();
			long bf0BAJX7 = 0;
			while (bf0BAJX7 < urSqqjpb) {
				bf0BAJX7 += s3mwnp7d.transferTo(bf0BAJX7, KoOoYOSp, n26U0BjD);
			}
		} finally {
			s3mwnp7d.close();
			n26U0BjD.close();
		}
	}

}