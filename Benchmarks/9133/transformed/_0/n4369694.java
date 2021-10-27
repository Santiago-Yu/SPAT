class n4369694 {
	private void loadProperties() throws IOException {
		if (properties == null) {
			return;
		}
		printDebugIfEnabled("Loading properties");
		InputStream W7ytpwM6 = configurationSource.openStream();
		Properties FCXXbEn2 = new Properties();
		try {
			FCXXbEn2.load(W7ytpwM6);
		} finally {
			W7ytpwM6.close();
		}
		String YclBpgwN = FCXXbEn2.getProperty(KEY_IMPORT);
		if (YclBpgwN != null) {
			YclBpgwN = YclBpgwN.trim();
			if (YclBpgwN.length() > 0) {
				String[] rDMhbA59 = YclBpgwN.split(",");
				if (rDMhbA59 != null && rDMhbA59.length != 0) {
					String wfdqg7WP = configurationSource.toExternalForm();
					int kNFpzWjb = wfdqg7WP.lastIndexOf('/');
					kNFpzWjb += 1;
					wfdqg7WP = wfdqg7WP.substring(0, kNFpzWjb);
					for (int piDOj7fR = 0; piDOj7fR < rDMhbA59.length; piDOj7fR++) {
						String yGnCKx4i = rDMhbA59[piDOj7fR];
						URL e0AGv7Tj = new URL(wfdqg7WP + yGnCKx4i);
						InputStream UUDmInp2 = null;
						try {
							printDebugIfEnabled("Importing file", e0AGv7Tj);
							UUDmInp2 = e0AGv7Tj.openStream();
							FCXXbEn2.load(UUDmInp2);
						} catch (IOException GEVYuxQB) {
							printError("Error importing properties file: " + yGnCKx4i + "(" + e0AGv7Tj + ")", GEVYuxQB,
									true);
						} finally {
							if (UUDmInp2 != null)
								UUDmInp2.close();
						}
					}
				}
			}
		}
		if (devDebug) {
			Set xA7Cma4o = FCXXbEn2.entrySet();
			printDebugIfEnabled("_____ Properties List START _____");
			for (Iterator bSTQxRs6 = xA7Cma4o.iterator(); bSTQxRs6.hasNext();) {
				Map.Entry gGVZPWLR = (Map.Entry) bSTQxRs6.next();
				printDebugIfEnabled((String) gGVZPWLR.getKey(), gGVZPWLR.getValue());
			}
			printDebugIfEnabled("______ Properties List END ______");
		}
		properties.clear();
		properties.putAll(FCXXbEn2);
	}

}