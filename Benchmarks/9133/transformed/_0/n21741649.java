class n21741649 {
	private InputStream getInputStream() throws URISyntaxException, MalformedURLException, IOException {
		InputStream Pn5cqKgf = null;
		try {
			URL v4eueaJZ = new URI(wsdlFile).toURL();
			URLConnection VvkT7mSe = v4eueaJZ.openConnection();
			VvkT7mSe.connect();
			Pn5cqKgf = VvkT7mSe.getInputStream();
		} catch (IllegalArgumentException k7r66zvU) {
			Pn5cqKgf = new FileInputStream(wsdlFile);
		}
		return Pn5cqKgf;
	}

}