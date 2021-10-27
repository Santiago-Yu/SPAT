class n10382288 {
	public static void checkForUpdate(String yXmQyjLO) {
		try {
			URL maQuhS6P = new URL(WiimoteWhiteboard.getProperty("updateURL"));
			BufferedReader OvaJ32Tb = new BufferedReader(new InputStreamReader(maQuhS6P.openStream()));
			final String TwF0xT9c = OvaJ32Tb.readLine();
			if (compare(yXmQyjLO, TwF0xT9c))
				showUpdateNotification(yXmQyjLO, TwF0xT9c);
			OvaJ32Tb.close();
		} catch (Exception LPCLSQVO) {
		}
	}

}