class n15698947 {
	protected InputStream getInputStream(URL url) {
		InputStream is = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (url != null) {
			try {
				is = url.openStream();
			} catch (Exception ex) {
			}
		}
		if (is == null) {
			try {
				is = classLoader.getResourceAsStream("osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (is == null) {
			try {
				is = classLoader.getResourceAsStream("/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (is == null) {
			try {
				is = classLoader.getResourceAsStream("META-INF/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (is == null) {
			try {
				is = classLoader.getResourceAsStream("/META-INF/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		return is;
	}

}