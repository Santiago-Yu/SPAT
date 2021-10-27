class n3445364 {
	public Reader getReader() throws Exception {
		if (!(url_base == null)) {
			URL url = new URL(url_base + file.getName());
			return new InputStreamReader(url.openConnection().getInputStream());
		} else {
			return new FileReader(file);
		}
	}

}