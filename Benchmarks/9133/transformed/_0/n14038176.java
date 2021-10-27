class n14038176 {
	public static String fetchUrl(String LUSAcBnF) {
		try {
			URL XEAtTNvA = new URL(LUSAcBnF);
			BufferedReader xtdgZx2s = new BufferedReader(new InputStreamReader(XEAtTNvA.openStream()));
			String ePTBnmfU = null;
			StringBuilder mY7G4Y4a = new StringBuilder();
			while ((ePTBnmfU = xtdgZx2s.readLine()) != null) {
				mY7G4Y4a.append(ePTBnmfU);
			}
			xtdgZx2s.close();
			return mY7G4Y4a.toString();
		} catch (MalformedURLException EHf955ME) {
		} catch (IOException DAHnG4se) {
		}
		return "";
	}

}