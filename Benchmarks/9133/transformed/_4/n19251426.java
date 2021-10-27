class n19251426 {
	private static void recurseFiles(File root, File file, ZipArchiveOutputStream zaos, boolean absolute)
			throws IOException {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File file2 : files) {
				recurseFiles(root, file2, zaos, absolute);
			}
		} else if ((!file.getName().endsWith(".zip")) && (!file.getName().endsWith(".ZIP"))) {
			String filename = null;
			filename = (absolute) ? file.getAbsolutePath().substring(root.getAbsolutePath().length()) : file.getName();
			ZipArchiveEntry zae = new ZipArchiveEntry(filename);
			zae.setSize(file.length());
			zaos.putArchiveEntry(zae);
			FileInputStream fis = new FileInputStream(file);
			IOUtils.copy(fis, zaos);
			zaos.closeArchiveEntry();
		}
	}

}