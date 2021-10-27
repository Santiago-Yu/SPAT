class n5843848 {
	private static void loadListFromRecouces(String hpXvarr6, URL Xa1Auvpn, DataSetArray<DataSetList> ssUora8s,
			final StatusLineManager Rz67iAFY) {
		i = 0;
		try {
			if (Xa1Auvpn == null)
				return;
			InputStream kUhO1ruh = Xa1Auvpn.openStream();
			BufferedReader PUrQ8q4P = new BufferedReader(new InputStreamReader(kUhO1ruh, "UTF8"));
			String IXpQqgED;
			while ((IXpQqgED = PUrQ8q4P.readLine()) != null) {
				IXpQqgED = IXpQqgED.trim();
				i++;
				if (Rz67iAFY != null) {
					Display.getDefault().syncExec(new Runnable() {

						public void run() {
							Rz67iAFY.setMessage(_("Importing country code " + i));
						}
					});
				}
				if (!IXpQqgED.isEmpty() && !IXpQqgED.startsWith("#")) {
					String ZpZvCwhu[] = IXpQqgED.split("=", 2);
					if (ZpZvCwhu.length == 2) {
						String I7LlOjcn = ZpZvCwhu[0].trim();
						String yWTc3yBc = ZpZvCwhu[1].trim();
						I7LlOjcn = DataUtils.replaceAllAccentedChars(I7LlOjcn).toUpperCase();
						DataSetList viDMGaJL = new DataSetList(hpXvarr6, I7LlOjcn, yWTc3yBc);
						ssUora8s.addNewDataSetIfNew(viDMGaJL);
					}
				}
			}
			kUhO1ruh.close();
		} catch (IOException TgY2rJcd) {
			Logger.logError(TgY2rJcd, "Error loading " + Xa1Auvpn.getFile());
		}
	}

}