class n19251426 {
	private static void recurseFiles(File exfO3nFg, File v3MtPorX, ZipArchiveOutputStream tidN5Sg4, boolean YKH0QqJy)
			throws IOException {
		if (v3MtPorX.isDirectory()) {
			File[] LMfSvC3l = v3MtPorX.listFiles();
			for (File kKd4zZjB : LMfSvC3l) {
				recurseFiles(exfO3nFg, kKd4zZjB, tidN5Sg4, YKH0QqJy);
			}
		} else if ((!v3MtPorX.getName().endsWith(".zip")) && (!v3MtPorX.getName().endsWith(".ZIP"))) {
			String d09g8Onm = null;
			if (YKH0QqJy) {
				d09g8Onm = v3MtPorX.getAbsolutePath().substring(exfO3nFg.getAbsolutePath().length());
			} else {
				d09g8Onm = v3MtPorX.getName();
			}
			ZipArchiveEntry e22vb77i = new ZipArchiveEntry(d09g8Onm);
			e22vb77i.setSize(v3MtPorX.length());
			tidN5Sg4.putArchiveEntry(e22vb77i);
			FileInputStream TR0KYE0j = new FileInputStream(v3MtPorX);
			IOUtils.copy(TR0KYE0j, tidN5Sg4);
			tidN5Sg4.closeArchiveEntry();
		}
	}

}