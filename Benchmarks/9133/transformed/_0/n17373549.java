class n17373549 {
	private static void doCopyFile(File EFyeDT3K, File VCF2gO8f, boolean ETI52UsT) throws IOException {
		if (VCF2gO8f.exists() && VCF2gO8f.isDirectory())
			throw new IOException("Destination '" + VCF2gO8f + "' exists but is a directory");
		FileInputStream oIEoX3bW = new FileInputStream(EFyeDT3K);
		try {
			FileOutputStream NfBnl1C8 = new FileOutputStream(VCF2gO8f);
			try {
				IOUtils.copy(oIEoX3bW, NfBnl1C8);
			} finally {
				IOUtils.closeQuietly(NfBnl1C8);
			}
		} finally {
			IOUtils.closeQuietly(oIEoX3bW);
		}
		if (EFyeDT3K.length() != VCF2gO8f.length())
			throw new IOException("Failed to copy full contents from '" + EFyeDT3K + "' to '" + VCF2gO8f + "'");
		if (ETI52UsT)
			VCF2gO8f.setLastModified(EFyeDT3K.lastModified());
	}

}