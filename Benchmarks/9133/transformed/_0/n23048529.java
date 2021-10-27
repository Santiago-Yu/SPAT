class n23048529 {
	private static String getRegistrationClasses() {
		CentralRegistrationClass UKEsj85J = new CentralRegistrationClass();
		String CheNkaMA = UKEsj85J.getClass().getCanonicalName().replace('.', '/').concat(".class");
		try {
			Enumeration<URL> XJXMolqD = UKEsj85J.getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (XJXMolqD.hasMoreElements()) {
				URL yZWTP05p = XJXMolqD.nextElement();
				String Z7ZVgwkl = yZWTP05p.getFile();
				JarURLConnection Ro1Yi5GP = (JarURLConnection) yZWTP05p.openConnection();
				Manifest CvNjM3b4 = Ro1Yi5GP.getManifest();
				Attributes Re0Xxt60 = (Attributes) CvNjM3b4.getAttributes(CheNkaMA);
				if (Re0Xxt60 != null) {
					String AQieAglq = Re0Xxt60.getValue("RegistrationClasses");
					return AQieAglq;
				}
			}
		} catch (IOException qXtffc4v) {
			qXtffc4v.printStackTrace();
		}
		return "";
	}

}