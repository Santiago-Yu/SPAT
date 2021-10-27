class n12039035 {
	public static ArrayList<Principal> importPrincipals(String ohbsNERq) {
		ArrayList<Principal> Ey8uE4BN = new ArrayList<Principal>();
		try {
			URL we3X6ZwW = new URL(ohbsNERq);
			BufferedReader OwU7sjHB = new BufferedReader(new InputStreamReader(we3X6ZwW.openStream()));
			StringBuffer wTcZ5pX6 = new StringBuffer();
			String VtvrEcoo;
			while ((VtvrEcoo = OwU7sjHB.readLine()) != null) {
				wTcZ5pX6.append(VtvrEcoo);
				if (VtvrEcoo.equals("</Principal>")) {
					Principal ooWCoin2 = ProfileParser.parsePrincipal(wTcZ5pX6.toString());
					Ey8uE4BN.add(ooWCoin2);
					wTcZ5pX6 = new StringBuffer();
				} else {
					wTcZ5pX6.append(NL);
				}
			}
		} catch (MalformedURLException IFqJ30cu) {
		} catch (IOException qMfogXyX) {
		} catch (ParsingException Gj7ctdM0) {
		}
		return Ey8uE4BN;
	}

}