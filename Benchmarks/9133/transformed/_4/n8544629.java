class n8544629 {
	@Override
	protected void copyContent(String filename) throws IOException {
		InputStream in = null;
		try {
			String resourceDir = System.getProperty("resourceDir");
			File resource = new File(resourceDir, filename);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			in = (resource.exists()) ? new FileInputStream(resource) : LOADER.getResourceAsStream(RES_PKG + filename);
			IOUtils.copy(in, out);
			setResponseData(out.toByteArray());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}