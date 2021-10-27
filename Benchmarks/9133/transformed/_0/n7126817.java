class n7126817 {
	private static String getRegistrationClasses() {
		CentralRegistrationClass RxxR6wOR = new CentralRegistrationClass();
		String yhbRNnaO = RxxR6wOR.getClass().getCanonicalName().replace('.', '/').concat(".class");
		try {
			Enumeration<URL> rIQA5siH = RxxR6wOR.getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (rIQA5siH.hasMoreElements()) {
				URL azW9pQos = rIQA5siH.nextElement();
				String IHrrSPQr = azW9pQos.getFile();
				JarURLConnection nEOo65FS = (JarURLConnection) azW9pQos.openConnection();
				Manifest LxwgIU6W = nEOo65FS.getManifest();
				Attributes nNQJMe7e = (Attributes) LxwgIU6W.getAttributes(yhbRNnaO);
				if (nNQJMe7e != null) {
					String gESELr5E = nNQJMe7e.getValue("RegistrationClasses");
					return gESELr5E;
				}
			}
		} catch (IOException xUAdGPJ4) {
			xUAdGPJ4.printStackTrace();
		}
		return "";
	}

}