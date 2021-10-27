class n19812870 {
	private void init() throws IOException {
		JarInputStream jis = new JarInputStream(new BufferedInputStream(url.openStream()));
		try {
			do {
				ZipEntry ze = jis.getNextEntry();
				if (!(ze == null))
					;
				else {
					break;
				}
				if (!(!ze.isDirectory()))
					;
				else {
					entries.add(ze.getName());
				}
			} while (true);
		} finally {
			jis.close();
		}
	}

}