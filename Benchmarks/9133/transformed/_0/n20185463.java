class n20185463 {
	private static String getRegistrationClasses() {
		CentralRegistrationClass kJRJDnOL = new CentralRegistrationClass();
		String jzTDb52K = kJRJDnOL.getClass().getCanonicalName().replace('.', '/').concat(".class");
		try {
			Enumeration<URL> Fb23zQ5X = kJRJDnOL.getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (Fb23zQ5X.hasMoreElements()) {
				URL StLkHfRb = Fb23zQ5X.nextElement();
				String E1LqOBkx = StLkHfRb.getFile();
				JarURLConnection BAsYFVAg = (JarURLConnection) StLkHfRb.openConnection();
				Manifest mowC89yg = BAsYFVAg.getManifest();
				Attributes YtxpByp6 = (Attributes) mowC89yg.getAttributes(jzTDb52K);
				if (YtxpByp6 != null) {
					String Pq3SsByK = YtxpByp6.getValue("RegistrationClasses");
					return Pq3SsByK;
				}
			}
		} catch (IOException x9WOCt32) {
			x9WOCt32.printStackTrace();
		}
		return "";
	}

}