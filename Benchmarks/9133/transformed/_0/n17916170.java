class n17916170 {
	public String getWebPage(String Q4dSFxCn) {
		String ndiJ9g3p = "";
		URL utZb6fOp = null;
		try {
			utZb6fOp = new URL(Q4dSFxCn);
		} catch (MalformedURLException pp8fKq0n) {
			pp8fKq0n.printStackTrace();
			throw new Error("URL creation failed.");
		}
		try {
			BufferedReader KRx91ACs = new BufferedReader(new InputStreamReader(utZb6fOp.openStream()));
			String kkCdg5CA;
			while ((kkCdg5CA = KRx91ACs.readLine()) != null) {
				ndiJ9g3p += kkCdg5CA;
			}
		} catch (IOException FKHL1mxu) {
			FKHL1mxu.printStackTrace();
			throw new Error("Page retrieval failed.");
		}
		return ndiJ9g3p;
	}

}