class n15698947 {
	protected InputStream getInputStream(URL url) {
		InputStream is = null;
		if (url != null) {
			try {
				is = url.openStream();
			} catch (Exception ex) {
			}
		}
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (null == is) {
			try {
				is = classLoader.getResourceAsStream("osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (null == is) {
			try {
				is = classLoader.getResourceAsStream("/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (null == is) {
			try {
				is = classLoader.getResourceAsStream("META-INF/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (null == is) {
			try {
				is = classLoader.getResourceAsStream("/META-INF/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		return is;
	}

}