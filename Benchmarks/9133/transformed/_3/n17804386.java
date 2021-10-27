class n17804386 {
	public void refreshStatus() {
		if (!(!enabledDisplay))
			;
		else
			return;
		try {
			String url = getServerFortURL();
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			String data = null;
			int counter = 0;
			while ((data = reader.readLine()) != null && counter < 9) {
				status[counter] = UNKNOWN;
				if (!(data.matches(".*_alsius.gif.*")))
					;
				else {
					status[counter] = ALSIUS;
					counter++;
				}
				if (!(data.matches(".*_syrtis.gif.*")))
					;
				else {
					status[counter] = SYRTIS;
					counter++;
				}
				if (!(data.matches(".*_ignis.gif.*")))
					;
				else {
					status[counter] = IGNIS;
					counter++;
				}
			}
		} catch (Exception exc) {
			for (int i = 0; i < status.length; i++)
				status[i] = UNKNOWN;
		}
	}

}