class n14067271 {
	private static void addFolderToZip(File kL7lEIbC, ZipOutputStream EUdSTeiM, String xRUcNDFh) throws IOException {
		File[] QeJY1J0S = kL7lEIbC.listFiles();
		for (File VjgNJTLD : QeJY1J0S) {
			if (VjgNJTLD.isDirectory()) {
				addFolderToZip(VjgNJTLD, EUdSTeiM, xRUcNDFh);
			} else {
				String cALcsttz = VjgNJTLD.getAbsolutePath().substring(xRUcNDFh.length());
				ZipEntry OovTtwZa = new ZipEntry(cALcsttz);
				EUdSTeiM.putNextEntry(OovTtwZa);
				IOUtils.copy(new FileInputStream(VjgNJTLD), EUdSTeiM);
				EUdSTeiM.closeEntry();
			}
		}
	}

}