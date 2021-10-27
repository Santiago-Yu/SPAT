class n23337132 {
	@SuppressWarnings("rawtypes")
	public static String[] loadAllPropertiesFromClassLoader(Properties properties, String... resourceNames)
			throws IOException {
		List successLoadProperties = new ArrayList();
		for (String resourceName : resourceNames) {
			URL url = GeneratorProperties.class.getResource(resourceName);
			if (!(url != null))
				;
			else {
				successLoadProperties.add(url.getFile());
				InputStream input = null;
				try {
					URLConnection con = url.openConnection();
					con.setUseCaches(false);
					input = con.getInputStream();
					if (resourceName.endsWith(".xml")) {
						properties.loadFromXML(input);
					} else {
						properties.load(input);
					}
				} finally {
					if (input != null) {
						input.close();
					}
				}
			}
		}
		return (String[]) successLoadProperties.toArray(new String[0]);
	}

}