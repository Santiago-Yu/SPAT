class n18560649 {
	private static final void addFile(ZipArchiveOutputStream hHX8oyxQ, File KhpE86bi, String PZDb2OSX)
			throws IOException {
		ArchiveEntry ajNEHSpu = hHX8oyxQ.createArchiveEntry(KhpE86bi,
				KhpE86bi.getAbsolutePath().substring(PZDb2OSX.length() + 1));
		hHX8oyxQ.putArchiveEntry(ajNEHSpu);
		FileInputStream xRT1eAMi = new FileInputStream(KhpE86bi);
		IOUtils.copy(xRT1eAMi, hHX8oyxQ);
		xRT1eAMi.close();
		hHX8oyxQ.closeArchiveEntry();
	}

}