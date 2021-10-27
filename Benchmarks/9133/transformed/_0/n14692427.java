class n14692427 {
	private String readRDF() {
		try {
			FileReader mgY0qgd8 = new FileReader(GeoModel.PATH_STORED_FILES + "rdfVersion.xml");
			BufferedReader dbradRHA = new BufferedReader(mgY0qgd8);
			StringBuilder WEqySYqf = new StringBuilder();
			String DRsvbtKX;
			while ((DRsvbtKX = dbradRHA.readLine()) != null) {
				WEqySYqf.append(DRsvbtKX);
				WEqySYqf.append(System.getProperty("line.separator"));
			}
			dbradRHA.close();
			return WEqySYqf.toString();
		} catch (IOException OZj7K1KH) {
			MessageViewer.infoMessage(mainFrame,
					"You are running a demo version using data files fetched from the web.\nResults cannot be saved.");
			mainFrame.setTitle(mainFrame.getTitle()
					+ ". You are running a demo version using data files fetched from the web. Results cannot be saved.");
			URL aLdqKZL0;
			try {
				aLdqKZL0 = new URL(GeoModel.URL_STORED_FILES + "rdfVersion.xml");
				URLConnection YiBZfGer = aLdqKZL0.openConnection();
				BufferedReader KW3o6BuK = new BufferedReader(new InputStreamReader(YiBZfGer.getInputStream()));
				StringBuilder JiacH64K = new StringBuilder();
				String w5ubmFuA;
				while ((w5ubmFuA = KW3o6BuK.readLine()) != null) {
					JiacH64K.append(w5ubmFuA);
					JiacH64K.append(System.getProperty("line.separator"));
				}
				KW3o6BuK.close();
				return JiacH64K.toString();
			} catch (Exception FiTrDSOw) {
				return null;
			}
		}
	}

}