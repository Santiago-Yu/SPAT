class n18956017 {
	public void writeFile(OutputStream aQvrkj7p) throws IOException {
		InputStream lwgt1mez = null;
		if (file != null) {
			try {
				lwgt1mez = new FileInputStream(file);
				IOUtils.copy(lwgt1mez, aQvrkj7p);
			} finally {
				if (lwgt1mez != null) {
					IOUtils.closeQuietly(lwgt1mez);
				}
			}
		}
	}

}