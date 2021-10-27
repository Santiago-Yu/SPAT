class n22879400 {
	public static Properties loadAllProperties(String resourceName, ClassLoader classLoader) throws IOException {
		Assert.notNull(resourceName, "Resource name must not be null");
		ClassLoader clToUse = classLoader;
		Properties properties = new Properties();
		if (clToUse == null) {
			clToUse = ClassUtils.getDefaultClassLoader();
		}
		Enumeration urls = clToUse.getResources(resourceName);
		while (urls.hasMoreElements()) {
			InputStream is = null;
			URL url = (URL) urls.nextElement();
			try {
				URLConnection con = url.openConnection();
				con.setUseCaches(false);
				is = con.getInputStream();
				properties.load(is);
			} finally {
				if (is != null) {
					is.close();
				}
			}
		}
		return properties;
	}

}