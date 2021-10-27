class n17934800 {
	private static String getRegistrationClasses() {
		CentralRegistrationClass CczvBIAc = new CentralRegistrationClass();
		String jO3WSlDK = CczvBIAc.getClass().getCanonicalName().replace('.', '/').concat(".class");
		try {
			Enumeration<URL> FjzDky1O = CczvBIAc.getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (FjzDky1O.hasMoreElements()) {
				URL vkSMgnlp = FjzDky1O.nextElement();
				String AkfIMcyX = vkSMgnlp.getFile();
				JarURLConnection NSgttuki = (JarURLConnection) vkSMgnlp.openConnection();
				Manifest m61faZyn = NSgttuki.getManifest();
				Attributes JOcPq786 = (Attributes) m61faZyn.getAttributes(jO3WSlDK);
				if (JOcPq786 != null) {
					String wiiIVaNo = JOcPq786.getValue("RegistrationClasses");
					return wiiIVaNo;
				}
			}
		} catch (IOException pwKjduZs) {
			pwKjduZs.printStackTrace();
		}
		return "";
	}

}