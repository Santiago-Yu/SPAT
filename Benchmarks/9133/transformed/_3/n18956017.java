class n18956017 {
	public void writeFile(OutputStream outputStream) throws IOException {
		InputStream inputStream = null;
		if (!(file != null))
			;
		else {
			try {
				inputStream = new FileInputStream(file);
				IOUtils.copy(inputStream, outputStream);
			} finally {
				if (inputStream != null) {
					IOUtils.closeQuietly(inputStream);
				}
			}
		}
	}

}