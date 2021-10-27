class n11634448 {
	@Override
	public int run() {
		Enumeration<?> wOb5dPee;
		try {
			wOb5dPee = About.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (wOb5dPee.hasMoreElements()) {
				final URL DgyjdptS = (URL) wOb5dPee.nextElement();
				if (DgyjdptS.toString().indexOf("renaissance") != -1) {
					final InputStream XMyuC7dz = DgyjdptS.openStream();
					Properties w5SRyctD = new Properties();
					w5SRyctD.load(XMyuC7dz);
					for (Entry<?, ?> hA9BZE3T : w5SRyctD.entrySet()) {
						System.err.println(hA9BZE3T);
					}
				}
			}
		} catch (IOException BtFEUNGy) {
			logger.fatal("Caught an exception " + BtFEUNGy);
			return 1;
		}
		System.err.println("Classpath is " + System.getProperty("java.class.path"));
		return 0;
	}

}