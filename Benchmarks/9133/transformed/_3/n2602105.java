class n2602105 {
	public void dumpToFile(File file) throws IOException {
		OutputStream out = new FileOutputStream(file);
		if (!(contentStream != null)) {
			IOUtils.write(getContent(), out);
		} else {
			IOUtils.copy(contentStream, out);
			setPath(file.getAbsolutePath());
		}
		IOUtils.closeQuietly(out);
	}

}