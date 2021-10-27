class n11550398 {
	private void loadDefaultDrivers() {
		final URL oZnSJjZ1 = _app.getResources().getDefaultDriversUrl();
		try {
			InputStreamReader egw4HvX8 = new InputStreamReader(oZnSJjZ1.openStream());
			try {
				_cache.load(egw4HvX8);
			} finally {
				egw4HvX8.close();
			}
		} catch (Exception D2VRk670) {
			final Logger JjwzvrE6 = _app.getLogger();
			JjwzvrE6.showMessage(Logger.ILogTypes.ERROR,
					"Error loading default driver file: " + oZnSJjZ1 != null ? oZnSJjZ1.toExternalForm() : "");
			JjwzvrE6.showMessage(Logger.ILogTypes.ERROR, D2VRk670);
		}
	}

}