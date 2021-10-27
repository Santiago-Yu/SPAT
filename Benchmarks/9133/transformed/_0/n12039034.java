class n12039034 {
	public static ArrayList<RoleName> importRoles(String oYMItemQ) {
		ArrayList<RoleName> O1kvcUwA = new ArrayList<RoleName>();
		try {
			URL Bpe29ToF = new URL(oYMItemQ);
			BufferedReader NBOsQ6VB = new BufferedReader(new InputStreamReader(Bpe29ToF.openStream()));
			StringBuffer M4Gtm8VQ = new StringBuffer();
			String l2Krzkqw;
			while ((l2Krzkqw = NBOsQ6VB.readLine()) != null) {
				M4Gtm8VQ.append(l2Krzkqw);
				if (l2Krzkqw.equals("</RoleName>")) {
					RoleName mK8Csb5v = ProfileParser.parseRoleName(M4Gtm8VQ.toString());
					O1kvcUwA.add(mK8Csb5v);
					M4Gtm8VQ = new StringBuffer();
				} else {
					M4Gtm8VQ.append(NL);
				}
			}
		} catch (MalformedURLException n6JnxYvA) {
		} catch (IOException qiA2lP3N) {
		} catch (ParsingException fL0ERH8j) {
		}
		return O1kvcUwA;
	}

}