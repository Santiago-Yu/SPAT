class n6742637 {
	private static List<Properties> findExtensions() {
		URL url = null;
		try {
			List<Properties> extensions = new ArrayList<Properties>();
			Enumeration<URL> res = ExtensionHelper.class.getClassLoader().getResources("logdistiller.properties");
			while (res.hasMoreElements()) {
				url = res.nextElement();
				Properties prop = new Properties();
				prop.load(url.openStream());
				extensions.add(prop);
			}
			return extensions;
		} catch (IOException ioe) {
			String msg;
			if ((url == null))
				msg = "unable to list resources logdistiller.properties";
			else
				msg = "unable to load resource " + url.toExternalForm();
			throw new RuntimeException(msg, ioe);
		}
	}

}