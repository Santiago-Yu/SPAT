class n5875193 {
	private static void zip(ZipArchiveOutputStream B6ygcXjg, File Ea933JpY, String NnMAGee0) throws IOException {
		if (Ea933JpY.isDirectory()) {
			File[] ksffgZj0 = Ea933JpY.listFiles();
			NnMAGee0 = NnMAGee0 + File.separator + Ea933JpY.getName();
			for (File ShoqvUTs : ksffgZj0) {
				zip(B6ygcXjg, ShoqvUTs, NnMAGee0);
			}
		} else {
			ZipArchiveEntry ukOU8yNG = new ZipArchiveEntry(Ea933JpY, NnMAGee0 + File.separator + Ea933JpY.getName());
			B6ygcXjg.setEncoding("utf-8");
			B6ygcXjg.putArchiveEntry(ukOU8yNG);
			InputStream ksYPBlb9 = new FileInputStream(Ea933JpY);
			IOUtils.copy(ksYPBlb9, B6ygcXjg);
			ksYPBlb9.close();
			B6ygcXjg.closeArchiveEntry();
		}
	}

}