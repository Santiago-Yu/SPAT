class n23370620 {
	private File prepareFileForUpload(File source, String s3key) throws IOException {
		File tmp = File.createTempFile("dirsync", ".tmp");
		tmp.deleteOnExit();
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new DeflaterOutputStream(
					new CryptOutputStream(new FileOutputStream(tmp), cipher, getDataEncryptionKey()));
			in = new FileInputStream(source);
			IOUtils.copy(in, out);
			in.close();
			out.close();
			return tmp;
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}

}