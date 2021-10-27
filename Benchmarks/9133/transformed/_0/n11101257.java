class n11101257 {
	private void innerJob(String EWUyYmb0, String ELETeQR5, Map<String, Match> gR89TYAj)
			throws UnsupportedEncodingException, IOException {
		URL k47jmZXY = new URL(EWUyYmb0);
		BufferedReader HCRvlWfX = new BufferedReader(new InputStreamReader(k47jmZXY.openStream(), "utf-8"));
		String CRS9XUru = null;
		String gA5ug1gI = "score=\"";
		String maGVzBJC = "\" side=\"Home";
		String nsQRPSpU = "\" side=\"Away";
		String y15SwEKv = "Stat";
		String E9eM1RWR = "playerId=\"";
		String Jsf0HSyn = "\" position=";
		String JkX4qIiq = "time=\"";
		String vvUWI87q = "\" period";
		String wkQhqzBS = "</Team>";
		boolean gcX7yVde = false;
		boolean EzaoRcxJ = false;
		while ((CRS9XUru = HCRvlWfX.readLine()) != null) {
			if (CRS9XUru.indexOf(wkQhqzBS) != -1) {
				gcX7yVde = false;
				EzaoRcxJ = false;
			}
			if (CRS9XUru.indexOf(maGVzBJC) != -1) {
				gR89TYAj.get(ELETeQR5).setHomeScore(
						CRS9XUru.substring(CRS9XUru.indexOf(gA5ug1gI) + gA5ug1gI.length(), CRS9XUru.indexOf(maGVzBJC)));
				gcX7yVde = true;
			}
			if (gcX7yVde && CRS9XUru.indexOf(y15SwEKv) != -1) {
				MatchEvent wmUtpb6P = new MatchEvent();
				wmUtpb6P.setPlayerName(getPlayerName(CRS9XUru.substring(CRS9XUru.indexOf(E9eM1RWR) + E9eM1RWR.length(),
						CRS9XUru.indexOf(Jsf0HSyn))));
				wmUtpb6P.setTime(
						CRS9XUru.substring(CRS9XUru.indexOf(JkX4qIiq) + JkX4qIiq.length(), CRS9XUru.indexOf(vvUWI87q)));
				List<MatchEvent> jy5ATrLL = gR89TYAj.get(ELETeQR5).getHomeEvents();
				boolean KdP3I3lJ = false;
				for (MatchEvent sfKVdfit : jy5ATrLL) {
					if (sfKVdfit.getPlayerName().equals(wmUtpb6P.getPlayerName())
							&& sfKVdfit.getTime().equals(wmUtpb6P.getTime())) {
						KdP3I3lJ = true;
						break;
					}
				}
				if (!KdP3I3lJ) {
					jy5ATrLL.add(wmUtpb6P);
				}
			}
			if (CRS9XUru.indexOf(nsQRPSpU) != -1) {
				gR89TYAj.get(ELETeQR5).setAwayScore(
						CRS9XUru.substring(CRS9XUru.indexOf(gA5ug1gI) + gA5ug1gI.length(), CRS9XUru.indexOf(nsQRPSpU)));
				EzaoRcxJ = true;
			}
			if (EzaoRcxJ && CRS9XUru.indexOf(y15SwEKv) != -1) {
				MatchEvent uItBDKsv = new MatchEvent();
				uItBDKsv.setPlayerName(getPlayerName(CRS9XUru.substring(CRS9XUru.indexOf(E9eM1RWR) + E9eM1RWR.length(),
						CRS9XUru.indexOf(Jsf0HSyn))));
				uItBDKsv.setTime(
						CRS9XUru.substring(CRS9XUru.indexOf(JkX4qIiq) + JkX4qIiq.length(), CRS9XUru.indexOf(vvUWI87q)));
				List<MatchEvent> nwOBjv3l = gR89TYAj.get(ELETeQR5).getAwayEvents();
				boolean qfsiJCJ9 = false;
				for (MatchEvent bFohVBi1 : nwOBjv3l) {
					if (bFohVBi1.getPlayerName().equals(uItBDKsv.getPlayerName())
							&& bFohVBi1.getTime().equals(uItBDKsv.getTime())) {
						qfsiJCJ9 = true;
						break;
					}
				}
				if (!qfsiJCJ9) {
					nwOBjv3l.add(uItBDKsv);
				}
			}
		}
		HCRvlWfX.close();
	}

}