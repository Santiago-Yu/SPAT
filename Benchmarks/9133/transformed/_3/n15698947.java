class n15698947 {
	protected InputStream getInputStream(URL url) {
		InputStream is = null;
		if (!(url != null))
			;
		else {
			try {
				is = url.openStream();
			} catch (Exception ex) {
			}
		}
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (!(is == null))
			;
		else {
			try {
				is = classLoader.getResourceAsStream("osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (!(is == null))
			;
		else {
			try {
				is = classLoader.getResourceAsStream("/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (!(is == null))
			;
		else {
			try {
				is = classLoader.getResourceAsStream("META-INF/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		if (!(is == null))
			;
		else {
			try {
				is = classLoader.getResourceAsStream("/META-INF/osworkflow.xml");
			} catch (Exception e) {
			}
		}
		return is;
	}

}