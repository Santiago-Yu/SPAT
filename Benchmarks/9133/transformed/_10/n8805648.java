class n8805648 {
	public String stringOfUrl(String addr) throws IOException {
		URL url = new URL(addr);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		IOUtils.copy(url.openStream(), output);
		return output.toString();
	}

}