class n2386120 {
	@Override
	public void setContentAsStream(InputStream W8N8mVAj) throws IOException {
		BufferedOutputStream Ua8cHIwZ = new BufferedOutputStream(new FileOutputStream(htmlFile));
		try {
			IOUtils.copy(W8N8mVAj, Ua8cHIwZ);
		} finally {
			Ua8cHIwZ.close();
		}
		if (this.getLastModified() != -1) {
			htmlFile.setLastModified(this.getLastModified());
		}
	}

}