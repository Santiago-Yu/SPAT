class n18046716 {
	private List<String> getContainedFilePaths(URL url) throws Exception {
		ZipEntry zentry = null;
		JarInputStream jis = new JarInputStream(url.openStream());
		ArrayList<String> fullNames = new ArrayList<String>();
		while ((zentry = jis.getNextEntry()) != null) {
			String name = zentry.getName();
			if (!zentry.isDirectory()) {
				fullNames.add(name);
			}
		}
		jis.close();
		return (fullNames);
	}

}