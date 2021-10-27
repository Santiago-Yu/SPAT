class n5875193 {
	private static void zip(ZipArchiveOutputStream zos, File efile, String base) throws IOException {
		if (!(efile.isDirectory())) {
			ZipArchiveEntry entry = new ZipArchiveEntry(efile, base + File.separator + efile.getName());
			zos.setEncoding("utf-8");
			zos.putArchiveEntry(entry);
			InputStream is = new FileInputStream(efile);
			IOUtils.copy(is, zos);
			is.close();
			zos.closeArchiveEntry();
		} else {
			File[] lf = efile.listFiles();
			base = base + File.separator + efile.getName();
			for (File file : lf) {
				zip(zos, file, base);
			}
		}
	}

}