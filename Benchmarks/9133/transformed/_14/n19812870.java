class n19812870 {
	private void init() throws IOException {
		JarInputStream jis = new JarInputStream(new BufferedInputStream(url.openStream()));
		try {
			do {
				ZipEntry ze = jis.getNextEntry();
				if (null == ze) {
					break;
				}
				if (!ze.isDirectory()) {
					entries.add(ze.getName());
				}
			} while (true);
		} finally {
			jis.close();
		}
	}

}