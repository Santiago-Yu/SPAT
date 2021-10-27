class n14914613 {
	private void retrieveData() {
		StringBuffer obsBuf = new StringBuffer();
		try {
			URL url = new URL(getProperty("sourceURL"));
			String lineIn = null;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((lineIn = in.readLine()) != null) {
				if (GlobalProps.DEBUG) {
					logger.log(Level.FINE, "WebSource retrieveData: " + lineIn);
				}
				obsBuf.append(lineIn);
			}
			String fmt = getProperty("dataFormat");
			if (GlobalProps.DEBUG) {
				logger.log(Level.FINE, "Raw: " + obsBuf.toString());
			}
			if ("NWS XML".equals(fmt)) {
				obs = new NWSXmlObservation(obsBuf.toString());
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Can't connect to: " + getProperty("sourceURL"));
			if (GlobalProps.DEBUG) {
				e.printStackTrace();
			}
		}
	}

}