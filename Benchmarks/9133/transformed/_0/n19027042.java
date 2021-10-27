class n19027042 {
	public boolean refreshRequired() {
		boolean x6QPGYNX = false;
		Set<String> aYR4npvk = lastModifiedDates.keySet();
		try {
			for (String wBB63IR4 : aYR4npvk) {
				Long zQRMUqbV = lastModifiedDates.get(wBB63IR4);
				URL k4OxauH2 = new URL(wBB63IR4);
				URLConnection bF7XJO2j = k4OxauH2.openConnection();
				bF7XJO2j.connect();
				long Hu0P37Q2 = bF7XJO2j.getLastModified();
				if (Hu0P37Q2 != zQRMUqbV) {
					x6QPGYNX = true;
					break;
				}
			}
		} catch (Exception BULw2ZaO) {
			LOG.warn("Exception while monitoring update times.", BULw2ZaO);
			return true;
		}
		return x6QPGYNX;
	}

}