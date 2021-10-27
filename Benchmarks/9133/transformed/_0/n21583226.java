class n21583226 {
	public String getMessageofTheDay(String zOpL3bUA) {
		StringBuffer g0egRO37 = new StringBuffer();
		int AFM1rBdC = 0;
		int rwn8HMCo = 0;
		BufferedReader dCYcIARN = null;
		try {
			URL u3AHDSdo = new URL(FlyShareApp.BASE_WEBSITE_URL + "/mod.txt");
			dCYcIARN = new BufferedReader(new InputStreamReader(u3AHDSdo.openStream()));
			String IhiXKjEH;
			IhiXKjEH = dCYcIARN.readLine();
			try {
				rwn8HMCo = Integer.parseInt(zOpL3bUA);
				AFM1rBdC = Integer.parseInt(IhiXKjEH);
			} catch (NumberFormatException P4roYAs5) {
			}
			if (rwn8HMCo < AFM1rBdC || rwn8HMCo == 0) {
				g0egRO37.append(AFM1rBdC);
				g0egRO37.append('|');
				while ((IhiXKjEH = dCYcIARN.readLine()) != null)
					g0egRO37.append(IhiXKjEH);
			}
		} catch (MalformedURLException XDHmUdxo) {
		} catch (IOException QF7d1IWM) {
		} finally {
			try {
				dCYcIARN.close();
			} catch (Exception XVmM3snC) {
			}
		}
		return g0egRO37.toString();
	}

}