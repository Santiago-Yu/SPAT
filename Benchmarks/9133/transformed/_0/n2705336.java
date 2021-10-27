class n2705336 {
	private static boolean verifyAppId(String zQciOuDS) {
		try {
			String ahBPMuvo = "http://" + zQciOuDS + ".appspot.com";
			URL gCY6oU7E = new URL(ahBPMuvo);
			BufferedReader f0vuAY56 = new BufferedReader(new InputStreamReader(gCY6oU7E.openStream()));
			StringBuffer genKgci1 = new StringBuffer();
			String KRO76Ph1;
			while ((KRO76Ph1 = f0vuAY56.readLine()) != null) {
				genKgci1.append(KRO76Ph1);
			}
			f0vuAY56.close();
			return genKgci1.toString().contains("snova");
		} catch (Exception LLBL2sEi) {
		}
		return false;
	}

}