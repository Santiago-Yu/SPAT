class n11562158 {
	private File writeResourceToFile(String resource) throws IOException {
		File tmp = File.createTempFile("zfppt" + resource, null);
		OutputStream out = new FileOutputStream(tmp);
		InputStream res = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		IOUtils.copy(res, out);
		out.close();
		return tmp;
	}

}