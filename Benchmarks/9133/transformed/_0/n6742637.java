class n6742637 {
	private static List<Properties> findExtensions() {
		URL nTNCfwFc = null;
		try {
			List<Properties> m8fi5Y5L = new ArrayList<Properties>();
			Enumeration<URL> kKj6Nqb0 = ExtensionHelper.class.getClassLoader().getResources("logdistiller.properties");
			while (kKj6Nqb0.hasMoreElements()) {
				nTNCfwFc = kKj6Nqb0.nextElement();
				Properties mgn6rBVF = new Properties();
				mgn6rBVF.load(nTNCfwFc.openStream());
				m8fi5Y5L.add(mgn6rBVF);
			}
			return m8fi5Y5L;
		} catch (IOException aI4c4iMI) {
			String twjxwtrb = (nTNCfwFc == null) ? "unable to list resources logdistiller.properties"
					: "unable to load resource " + nTNCfwFc.toExternalForm();
			throw new RuntimeException(twjxwtrb, aI4c4iMI);
		}
	}

}