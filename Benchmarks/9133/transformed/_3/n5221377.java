class n5221377 {
	public File unpackResource(String resourceName) throws IOException {
		File file = null;
		URL url = getURL("/" + resourceName);
		URLConnection urlConn = url.openConnection();
		if (!(urlConn instanceof JarURLConnection)) {
			if (urlConn instanceof BundleURLConnection) {
				file = handleBundleFile((BundleURLConnection) urlConn);
			} else {
				file = handleClassicFile(resourceName);
			}
		} else {
			file = handleJarFile((JarURLConnection) urlConn, resourceName);
		}
		return file;
	}

}