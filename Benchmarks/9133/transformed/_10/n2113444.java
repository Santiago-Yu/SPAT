class n2113444 {
	private VelocityEngine newVelocityEngine() {
		InputStream is = null;
		VelocityEngine velocityEngine = null;
		try {
			URL url = ClassPathUtils.getResource(VELOCITY_PROPS_FILE);
			Properties props = new Properties();
			is = url.openStream();
			props.load(is);
			velocityEngine = new VelocityEngine(props);
			velocityEngine.init();
		} catch (Exception e) {
			throw new RuntimeException("can not find velocity props file, file=" + VELOCITY_PROPS_FILE, e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return velocityEngine;
	}

}