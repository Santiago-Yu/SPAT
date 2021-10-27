class n19251429 {
	private static void addFile(File SdhB3BSc, ZipArchiveOutputStream c6DEb9Uj) throws IOException {
		String J1NnPpAa = null;
		J1NnPpAa = SdhB3BSc.getName();
		ZipArchiveEntry HsEkgl3C = new ZipArchiveEntry(J1NnPpAa);
		HsEkgl3C.setSize(SdhB3BSc.length());
		c6DEb9Uj.putArchiveEntry(HsEkgl3C);
		FileInputStream s17HMMx1 = new FileInputStream(SdhB3BSc);
		IOUtils.copy(s17HMMx1, c6DEb9Uj);
		c6DEb9Uj.closeArchiveEntry();
	}

}