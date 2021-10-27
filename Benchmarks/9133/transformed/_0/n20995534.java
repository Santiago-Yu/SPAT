class n20995534 {
	private static Properties loadPropertiesFromClasspath(String MRwK8y8A) {
		Enumeration<URL> jXtZCZk8;
		Properties ku0wRDqj = new Properties();
		try {
			jXtZCZk8 = Thread.currentThread().getContextClassLoader().getResources(MRwK8y8A);
			while (jXtZCZk8.hasMoreElements()) {
				URL CdlldBw9 = jXtZCZk8.nextElement();
				InputStream yzGQqUiS = CdlldBw9.openStream();
				ku0wRDqj.load(yzGQqUiS);
				yzGQqUiS.close();
				logger.config("Load properties from " + CdlldBw9);
			}
		} catch (IOException WMezk0Cm) {
			logger.log(Level.SEVERE, "load properties from classpath \"" + MRwK8y8A + "\" failed", WMezk0Cm);
		}
		return ku0wRDqj;
	}

}