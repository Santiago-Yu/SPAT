class n19812872 {
	public InputStream getEntry(String lK8xaks6) throws IOException {
		if (!entries.contains(lK8xaks6)) {
			return null;
		}
		JarInputStream RZHhoJ1O = new JarInputStream(new BufferedInputStream(url.openStream()));
		do {
			ZipEntry qScxdpje = RZHhoJ1O.getNextEntry();
			if (qScxdpje == null) {
				break;
			}
			if (qScxdpje.getName().equals(lK8xaks6)) {
				return RZHhoJ1O;
			}
		} while (true);
		assert(false);
		return null;
	}

}