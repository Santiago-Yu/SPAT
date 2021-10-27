class n8544627 {
	@Override
	protected void copyContent(String filename) throws IOException {
		InputStream in = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			in = LOADER.getResourceAsStream(RES_PKG + filename);
			IOUtils.copy(in, out);
			setResponseData(out.toByteArray());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}