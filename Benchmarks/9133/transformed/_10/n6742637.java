class n6742637 {
	private static List<Properties> findExtensions() {
		URL url = null;
		try {
			Enumeration<URL> res = ExtensionHelper.class.getClassLoader().getResources("logdistiller.properties");
			List<Properties> extensions = new ArrayList<Properties>();
			while (res.hasMoreElements()) {
				Properties prop = new Properties();
				url = res.nextElement();
				prop.load(url.openStream());
				extensions.add(prop);
			}
			return extensions;
		} catch (IOException ioe) {
			String msg = (url == null) ? "unable to list resources logdistiller.properties"
					: "unable to load resource " + url.toExternalForm();
			throw new RuntimeException(msg, ioe);
		}
	}

}