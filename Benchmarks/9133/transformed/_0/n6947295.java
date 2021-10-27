class n6947295 {
	public void configureLogging() {
		try {
			PreferenceStore KRNezhqd = new PreferenceStore();
			IExtensionRegistry xGy2JL6a = Platform.getExtensionRegistry();
			IExtensionPoint iLEQTwNK = xGy2JL6a.getExtensionPoint(CorePlugin.LOGGER_PREFERENCES_EXTENSION_POINT);
			IConfigurationElement[] tLFIt2jx = iLEQTwNK.getConfigurationElements();
			for (int zLFgkNGW = 0; zLFgkNGW < tLFIt2jx.length; zLFgkNGW++) {
				IConfigurationElement vVupCkuL = tLFIt2jx[zLFgkNGW];
				if (vVupCkuL.getName().equals("logger")) {
					if (vVupCkuL.getAttribute("defaultValue") != null) {
						String[] VhLYgXz5 = vVupCkuL.getAttribute("name").split(";");
						for (int gPrcqyU6 = 0; gPrcqyU6 < VhLYgXz5.length; gPrcqyU6++)
							KRNezhqd.setDefault("log4j.logger." + VhLYgXz5[gPrcqyU6],
									vVupCkuL.getAttribute("defaultValue"));
					}
				}
			}
			try {
				URL GMFziXCh = CorePlugin.getDefault().getBundle().getResource("log4j.properties");
				Properties HfZdoqsO = new Properties();
				HfZdoqsO.load(GMFziXCh.openStream());
				for (Iterator c7Megqbx = HfZdoqsO.keySet().iterator(); c7Megqbx.hasNext();) {
					String gJoOlWBW = (String) c7Megqbx.next();
					KRNezhqd.setDefault(gJoOlWBW, (String) HfZdoqsO.get(gJoOlWBW));
				}
				File WiaDkCTY = CorePlugin.getDefault().getStateLocation().append("log4j.properties").toFile();
				if (WiaDkCTY.exists())
					KRNezhqd.load(new FileInputStream(WiaDkCTY));
			} catch (Exception h67AF3S6) {
				CorePlugin.logException(h67AF3S6);
			}
			Properties rdueMs7r = new Properties();
			String[] X17VmbwJ = KRNezhqd.preferenceNames();
			for (int bhrlypUA = 0; bhrlypUA < X17VmbwJ.length; bhrlypUA++)
				rdueMs7r.put(X17VmbwJ[bhrlypUA], KRNezhqd.getString(X17VmbwJ[bhrlypUA]));
			PropertyConfigurator.configure(rdueMs7r);
		} catch (Exception YxV5XDvo) {
			BasicConfigurator.configure();
			logException(YxV5XDvo);
		}
	}

}