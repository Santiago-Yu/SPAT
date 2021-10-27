class n22879400 {
	public static Properties loadAllProperties(String DJEbz2eN, ClassLoader G2LYfxa4) throws IOException {
		Assert.notNull(DJEbz2eN, "Resource name must not be null");
		ClassLoader rpfCjHUW = G2LYfxa4;
		if (rpfCjHUW == null) {
			rpfCjHUW = ClassUtils.getDefaultClassLoader();
		}
		Properties zrVx2B3r = new Properties();
		Enumeration wmAIoJMF = rpfCjHUW.getResources(DJEbz2eN);
		while (wmAIoJMF.hasMoreElements()) {
			URL WpWBrzp2 = (URL) wmAIoJMF.nextElement();
			InputStream uAEZIuoz = null;
			try {
				URLConnection axPGKydH = WpWBrzp2.openConnection();
				axPGKydH.setUseCaches(false);
				uAEZIuoz = axPGKydH.getInputStream();
				zrVx2B3r.load(uAEZIuoz);
			} finally {
				if (uAEZIuoz != null) {
					uAEZIuoz.close();
				}
			}
		}
		return zrVx2B3r;
	}

}