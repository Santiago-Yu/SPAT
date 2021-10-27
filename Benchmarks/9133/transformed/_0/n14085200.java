class n14085200 {
	private static String getRegistrationClasses() {
		CentralRegistrationClass gFeYH1GY = new CentralRegistrationClass();
		String jGGSf0Ym = gFeYH1GY.getClass().getCanonicalName().replace('.', '/').concat(".class");
		try {
			Enumeration<URL> agYVBCIW = gFeYH1GY.getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (agYVBCIW.hasMoreElements()) {
				URL WuZ7PgOJ = agYVBCIW.nextElement();
				String ginhlfwn = WuZ7PgOJ.getFile();
				JarURLConnection gQYmXWz4 = (JarURLConnection) WuZ7PgOJ.openConnection();
				Manifest lnomTf9l = gQYmXWz4.getManifest();
				Attributes YB7RBwM2 = (Attributes) lnomTf9l.getAttributes(jGGSf0Ym);
				if (YB7RBwM2 != null) {
					String KTkJaVtx = YB7RBwM2.getValue("RegistrationClasses");
					return KTkJaVtx;
				}
			}
		} catch (IOException xk0e3xCc) {
			xk0e3xCc.printStackTrace();
		}
		return "";
	}

}