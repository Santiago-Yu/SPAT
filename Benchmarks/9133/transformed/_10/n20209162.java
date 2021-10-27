class n20209162 {
	public java.io.File gzip(java.io.File file) throws Exception {
		InputStream is = null;
		java.io.File tmp = null;
		OutputStream os = null;
		try {
			tmp = java.io.File.createTempFile(file.getName(), ".gz");
			tmp.deleteOnExit();
			os = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(tmp)));
			is = new BufferedInputStream(new FileInputStream(file));
			int nread = -1;
			byte[] buf = new byte[4096];
			while ((nread = is.read(buf)) != -1) {
				os.write(buf, 0, nread);
			}
			os.flush();
		} finally {
			os.close();
			is.close();
		}
		return tmp;
	}

}