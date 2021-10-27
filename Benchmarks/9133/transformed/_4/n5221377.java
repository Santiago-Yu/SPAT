class n5221377 {
	public File unpackResource(String resourceName) throws IOException {
		File file = null;
		URL url = getURL("/" + resourceName);
		URLConnection urlConn = url.openConnection();
		if (urlConn instanceof JarURLConnection) {
			file = handleJarFile((JarURLConnection) urlConn, resourceName);
		} else
			file = (urlConn instanceof BundleURLConnection) ? handleBundleFile((BundleURLConnection) urlConn)
					: handleClassicFile(resourceName);
		return file;
	}

}