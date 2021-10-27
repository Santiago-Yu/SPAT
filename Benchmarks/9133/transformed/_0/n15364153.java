class n15364153 {
	private void storeConfigurationPropertiesFile(java.net.URL qhTUQD04, String kkZJxZRM) {
		java.util.Properties lZBcqO8D;
		try {
			lZBcqO8D = new java.util.Properties();
			lZBcqO8D.load(qhTUQD04.openStream());
		} catch (java.io.IOException GKcq0ml7) {
			System.err.println("error opening: " + qhTUQD04.getPath() + ": " + GKcq0ml7.getMessage());
			return;
		}
		storeConfiguration(lZBcqO8D, kkZJxZRM);
		return;
	}

}