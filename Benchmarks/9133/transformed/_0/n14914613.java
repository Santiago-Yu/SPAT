class n14914613 {
	private void retrieveData() {
		StringBuffer Dzy2W2hJ = new StringBuffer();
		try {
			URL OjNjsobj = new URL(getProperty("sourceURL"));
			BufferedReader np6A0MaJ = new BufferedReader(new InputStreamReader(OjNjsobj.openStream()));
			String EtiOH0OY = null;
			while ((EtiOH0OY = np6A0MaJ.readLine()) != null) {
				if (GlobalProps.DEBUG) {
					logger.log(Level.FINE, "WebSource retrieveData: " + EtiOH0OY);
				}
				Dzy2W2hJ.append(EtiOH0OY);
			}
			String JGDbDpZR = getProperty("dataFormat");
			if (GlobalProps.DEBUG) {
				logger.log(Level.FINE, "Raw: " + Dzy2W2hJ.toString());
			}
			if ("NWS XML".equals(JGDbDpZR)) {
				obs = new NWSXmlObservation(Dzy2W2hJ.toString());
			}
		} catch (Exception EMDx733r) {
			logger.log(Level.SEVERE, "Can't connect to: " + getProperty("sourceURL"));
			if (GlobalProps.DEBUG) {
				EMDx733r.printStackTrace();
			}
		}
	}

}