class n23370620 {
	private File prepareFileForUpload(File dQovQwyS, String ZB6zsjRH) throws IOException {
		File naTPiVmh = File.createTempFile("dirsync", ".tmp");
		naTPiVmh.deleteOnExit();
		InputStream eo1G54Pu = null;
		OutputStream oxUU0QHS = null;
		try {
			eo1G54Pu = new FileInputStream(dQovQwyS);
			oxUU0QHS = new DeflaterOutputStream(
					new CryptOutputStream(new FileOutputStream(naTPiVmh), cipher, getDataEncryptionKey()));
			IOUtils.copy(eo1G54Pu, oxUU0QHS);
			eo1G54Pu.close();
			oxUU0QHS.close();
			return naTPiVmh;
		} finally {
			IOUtils.closeQuietly(eo1G54Pu);
			IOUtils.closeQuietly(oxUU0QHS);
		}
	}

}