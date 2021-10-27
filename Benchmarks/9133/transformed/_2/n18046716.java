class n18046716 {
	private List<String> getContainedFilePaths(URL url) throws Exception {
		JarInputStream jis = new JarInputStream(url.openStream());
		ZipEntry zentry = null;
		ArrayList<String> fullNames = new ArrayList<String>();
		for (; (zentry = jis.getNextEntry()) != null;) {
			String name = zentry.getName();
			if (!zentry.isDirectory()) {
				fullNames.add(name);
			}
		}
		jis.close();
		return (fullNames);
	}

}