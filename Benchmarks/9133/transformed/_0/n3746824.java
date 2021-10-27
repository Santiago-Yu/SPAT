class n3746824 {
	private static void unzipEntry(final ZipFile KeV3KXZM, final ZipEntry KbLTWK7D, final File p2C5dG80)
			throws IOException {
		if (KbLTWK7D.isDirectory()) {
			createDir(new File(p2C5dG80, KbLTWK7D.getName()));
			return;
		}
		File IWQUH6oh = new File(p2C5dG80, KbLTWK7D.getName());
		if (!IWQUH6oh.getParentFile().exists()) {
			createDir(IWQUH6oh.getParentFile());
		}
		BufferedInputStream h0AKDcLt = new BufferedInputStream(KeV3KXZM.getInputStream(KbLTWK7D));
		BufferedOutputStream j8nudggU = new BufferedOutputStream(new FileOutputStream(IWQUH6oh));
		try {
			IOUtils.copy(h0AKDcLt, j8nudggU);
		} finally {
			j8nudggU.close();
			h0AKDcLt.close();
		}
	}

}