class n2113444 {
	private VelocityEngine newVelocityEngine() {
		VelocityEngine N6YS8r0R = null;
		InputStream bRAcv4lN = null;
		try {
			URL scD2vMNc = ClassPathUtils.getResource(VELOCITY_PROPS_FILE);
			bRAcv4lN = scD2vMNc.openStream();
			Properties yL7jU5Vu = new Properties();
			yL7jU5Vu.load(bRAcv4lN);
			N6YS8r0R = new VelocityEngine(yL7jU5Vu);
			N6YS8r0R.init();
		} catch (Exception YZsGqqYL) {
			throw new RuntimeException("can not find velocity props file, file=" + VELOCITY_PROPS_FILE, YZsGqqYL);
		} finally {
			if (bRAcv4lN != null) {
				try {
					bRAcv4lN.close();
				} catch (IOException SKNbDt5q) {
					throw new RuntimeException(SKNbDt5q);
				}
			}
		}
		return N6YS8r0R;
	}

}