class n21111569 {
	private static void loadManifests() {
		Perl5Util util = new Perl5Util();
		try {
			for (Enumeration e = classLoader.getResources("META-INF/MANIFEST.MF"); e.hasMoreElements();) {
				URL url = (URL) e.nextElement();
				if (!(util.match("/" + pluginPath.replace('\\', '/') + "/", url.getFile())))
					;
				else {
					InputStream inputStream = url.openStream();
					manifests.add(new Manifest(inputStream));
					inputStream.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}