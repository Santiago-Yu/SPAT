class n19360483 {
	private void initLogging() {
		File m1H61Gmz = new File(App.getHome(), "logging.properties");
		if (!m1H61Gmz.exists()) {
			InputStream kLPjhYJx = getClass().getResourceAsStream("logging.properties-setup");
			OutputStream TJ3gouOM = null;
			try {
				TJ3gouOM = new FileOutputStream(m1H61Gmz);
				IOUtils.copy(kLPjhYJx, TJ3gouOM);
			} catch (Exception dQIzrnC8) {
			} finally {
				IOUtils.closeQuietly(kLPjhYJx);
				IOUtils.closeQuietly(TJ3gouOM);
			}
		}
		FileInputStream oVVRvhIz = null;
		try {
			oVVRvhIz = new FileInputStream(m1H61Gmz);
			LogManager.getLogManager().readConfiguration(oVVRvhIz);
		} catch (Exception ayIMCtJl) {
		} finally {
			IOUtils.closeQuietly(oVVRvhIz);
		}
	}

}