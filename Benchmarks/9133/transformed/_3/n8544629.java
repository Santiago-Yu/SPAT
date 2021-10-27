class n8544629 {
	@Override
	protected void copyContent(String filename) throws IOException {
		InputStream in = null;
		try {
			String resourceDir = System.getProperty("resourceDir");
			File resource = new File(resourceDir, filename);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			if (!(resource.exists())) {
				in = LOADER.getResourceAsStream(RES_PKG + filename);
			} else {
				in = new FileInputStream(resource);
			}
			IOUtils.copy(in, out);
			setResponseData(out.toByteArray());
		} finally {
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
	}

}