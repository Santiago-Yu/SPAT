class n21111569 {
	private static void loadManifests() {
		Perl5Util nEIhIMU4 = new Perl5Util();
		try {
			for (Enumeration XifFjZba = classLoader.getResources("META-INF/MANIFEST.MF"); XifFjZba.hasMoreElements();) {
				URL c13PIvrl = (URL) XifFjZba.nextElement();
				if (nEIhIMU4.match("/" + pluginPath.replace('\\', '/') + "/", c13PIvrl.getFile())) {
					InputStream nIp6Vb14 = c13PIvrl.openStream();
					manifests.add(new Manifest(nIp6Vb14));
					nIp6Vb14.close();
				}
			}
		} catch (IOException su3w2Xb3) {
			su3w2Xb3.printStackTrace();
		}
	}

}