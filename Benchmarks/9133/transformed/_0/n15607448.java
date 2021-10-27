class n15607448 {
	private static void unzipEntry(ZipFile scxo2I0W, ZipEntry abL5e2FK, File SC9Pg2SE) throws IOException {
		if (abL5e2FK.isDirectory()) {
			createDir(new File(SC9Pg2SE, abL5e2FK.getName()));
			return;
		}
		File HzHaCr7t = new File(SC9Pg2SE, abL5e2FK.getName());
		if (!HzHaCr7t.getParentFile().exists()) {
			createDir(HzHaCr7t.getParentFile());
		}
		BufferedInputStream rJGIS5Mo = new BufferedInputStream(scxo2I0W.getInputStream(abL5e2FK));
		BufferedOutputStream BfcxXmfj = new BufferedOutputStream(new FileOutputStream(HzHaCr7t));
		try {
			IOUtils.copy(rJGIS5Mo, BfcxXmfj);
		} finally {
			BfcxXmfj.close();
			rJGIS5Mo.close();
		}
	}

}