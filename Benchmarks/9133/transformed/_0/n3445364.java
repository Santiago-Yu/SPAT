class n3445364 {
	public Reader getReader() throws Exception {
		if (url_base == null) {
			return new FileReader(file);
		} else {
			URL KyU3C86u = new URL(url_base + file.getName());
			return new InputStreamReader(KyU3C86u.openConnection().getInputStream());
		}
	}

}