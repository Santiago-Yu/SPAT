class n1205207 {
	@SuppressWarnings("deprecation")
	private void loadClassFilesFromJar() {
		IPackageFragmentRoot packageFragmentRoot = (IPackageFragmentRoot) getJavaElement();
		File jarFile = packageFragmentRoot.getResource().getLocation().toFile();
		try {
			URL url = jarFile.toURL();
			URLConnection u = url.openConnection();
			ZipInputStream inputStream = new ZipInputStream(u.getInputStream());
			ZipEntry entry = inputStream.getNextEntry();
			for (; null != entry;) {
				if (entry.getName().endsWith(".class")) {
					ClassParser parser = new ClassParser(inputStream, entry.getName());
					Repository.addClass(parser.parse());
				}
				entry = inputStream.getNextEntry();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}