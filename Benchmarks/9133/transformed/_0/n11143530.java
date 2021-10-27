class n11143530 {
	private String readUrl(String LVHjf7eG) {
		StringBuffer CNOQvNIu = new StringBuffer();
		try {
			URL nbX6nzxK = new URL(LVHjf7eG);
			HttpURLConnection OyNTizRD = (HttpURLConnection) nbX6nzxK.openConnection();
			OyNTizRD.connect();
			BufferedReader Hhuh3Pwu = new BufferedReader(new InputStreamReader(OyNTizRD.getInputStream()));
			String cPTDUO8r;
			while ((cPTDUO8r = Hhuh3Pwu.readLine()) != null) {
				CNOQvNIu.append(cPTDUO8r);
			}
			OyNTizRD.disconnect();
		} catch (Exception zo25Ku0n) {
		}
		return CNOQvNIu.toString();
	}

}