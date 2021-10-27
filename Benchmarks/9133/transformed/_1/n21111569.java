class n21111569 {
	private static void loadManifests() {
		Perl5Util util = new Perl5Util();
		try {
			Enumeration t4CLN = classLoader.getResources("META-INF/MANIFEST.MF");
			while (t4CLN.hasMoreElements()) {
				URL url = (URL) t4CLN.nextElement();
				if (util.match("/" + pluginPath.replace('\\', '/') + "/", url.getFile())) {
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