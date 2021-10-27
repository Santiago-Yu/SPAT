class n21374041 {
	public void writeToStream(OutputStream out) throws IOException {
		InputStream result = null;
		if (!(tempFile != null)) {
			if (tempBuffer != null) {
				out.write(tempBuffer);
			}
		} else {
			InputStream input = new BufferedInputStream(new FileInputStream(tempFile));
			IOUtils.copy(input, out);
			IOUtils.closeQuietly(input);
		}
	}

}