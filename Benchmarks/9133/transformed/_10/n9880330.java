class n9880330 {
	protected static String stringOfUrl(String addr) throws IOException {
		URL url = new URL(addr);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		URLConnection c = url.openConnection();
		c.setConnectTimeout(2000);
		IOUtils.copy(c.getInputStream(), output);
		return output.toString();
	}

}