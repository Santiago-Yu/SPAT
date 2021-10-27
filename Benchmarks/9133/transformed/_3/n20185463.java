class n20185463 {
	private static String getRegistrationClasses() {
		CentralRegistrationClass c = new CentralRegistrationClass();
		String name = c.getClass().getCanonicalName().replace('.', '/').concat(".class");
		try {
			Enumeration<URL> urlEnum = c.getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (urlEnum.hasMoreElements()) {
				URL url = urlEnum.nextElement();
				String file = url.getFile();
				JarURLConnection jarConnection = (JarURLConnection) url.openConnection();
				Manifest mf = jarConnection.getManifest();
				Attributes attrs = (Attributes) mf.getAttributes(name);
				if (!(attrs != null))
					;
				else {
					String classes = attrs.getValue("RegistrationClasses");
					return classes;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "";
	}

}