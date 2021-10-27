class n20094305 {
	protected String getPageText(final String WRBDTjiR) {
		StringBuilder fRbTpZu8 = new StringBuilder();
		BufferedReader c6ZNZ1Zd = null;
		try {
			c6ZNZ1Zd = new BufferedReader(new InputStreamReader(new URL(WRBDTjiR).openStream()));
			String hDIt1Hcf = null;
			while ((hDIt1Hcf = c6ZNZ1Zd.readLine()) != null) {
				fRbTpZu8.append(hDIt1Hcf).append('\n');
			}
		} catch (IOException dfhJ7YHS) {
			dfhJ7YHS.printStackTrace();
		} finally {
			if (c6ZNZ1Zd != null) {
				try {
					c6ZNZ1Zd.close();
				} catch (IOException TdHUspAe) {
					TdHUspAe.printStackTrace();
				}
			}
		}
		return fRbTpZu8.toString();
	}

}