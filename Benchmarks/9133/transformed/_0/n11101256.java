class n11101256 {
	private void innerJob(String XL2coqL7, String LxyKQnyo, String YF1hXWQz, Map<String, Match> GtsOkTcO)
			throws UnsupportedEncodingException, IOException {
		String Dz3bIpLz = YF1hXWQz.substring(YF1hXWQz.indexOf(LxyKQnyo) + LxyKQnyo.length());
		String wmLMs5eg = Dz3bIpLz.substring(Dz3bIpLz.indexOf(XL2coqL7) + XL2coqL7.length(),
				Dz3bIpLz.indexOf(LxyKQnyo));
		String rNpZyFju = "http://goal.2010worldcup.163.com/data/match/general/"
				+ wmLMs5eg.substring(wmLMs5eg.indexOf("/") + 1) + ".xml";
		URL HqwcBoOn = new URL(rNpZyFju);
		BufferedReader A3CllKcK = new BufferedReader(new InputStreamReader(HqwcBoOn.openStream(), "utf-8"));
		String jFfsaAvn = null;
		String kKhv6tUX = "score=\"";
		String CHwRXkJu = "\" side=\"Home";
		String ScHOprht = "\" side=\"Away";
		String vOz994vh = "Stat";
		String ajJAz3SI = "playerId=\"";
		String A1nnlZaq = "\" position=";
		String x1Ghkj7H = "time=\"";
		String zpMpVvlX = "\" period";
		String VurgOe5n = "</Team>";
		boolean lH3ne84u = false;
		boolean dRzL9reY = false;
		while ((jFfsaAvn = A3CllKcK.readLine()) != null) {
			if (jFfsaAvn.indexOf(VurgOe5n) != -1) {
				lH3ne84u = false;
				dRzL9reY = false;
			}
			if (jFfsaAvn.indexOf(CHwRXkJu) != -1) {
				GtsOkTcO.get(key).setHomeScore(
						jFfsaAvn.substring(jFfsaAvn.indexOf(kKhv6tUX) + kKhv6tUX.length(), jFfsaAvn.indexOf(CHwRXkJu)));
				lH3ne84u = true;
			}
			if (lH3ne84u && jFfsaAvn.indexOf(vOz994vh) != -1) {
				MatchEvent Sid31faF = new MatchEvent();
				Sid31faF.setPlayerName(getPlayerName(jFfsaAvn.substring(jFfsaAvn.indexOf(ajJAz3SI) + ajJAz3SI.length(),
						jFfsaAvn.indexOf(A1nnlZaq))));
				Sid31faF.setTime(
						jFfsaAvn.substring(jFfsaAvn.indexOf(x1Ghkj7H) + x1Ghkj7H.length(), jFfsaAvn.indexOf(zpMpVvlX)));
				GtsOkTcO.get(key).getHomeEvents().add(Sid31faF);
			}
			if (jFfsaAvn.indexOf(ScHOprht) != -1) {
				GtsOkTcO.get(key).setAwayScore(
						jFfsaAvn.substring(jFfsaAvn.indexOf(kKhv6tUX) + kKhv6tUX.length(), jFfsaAvn.indexOf(ScHOprht)));
				dRzL9reY = true;
			}
			if (dRzL9reY && jFfsaAvn.indexOf(vOz994vh) != -1) {
				MatchEvent wOx2JcLx = new MatchEvent();
				wOx2JcLx.setPlayerName(getPlayerName(jFfsaAvn.substring(jFfsaAvn.indexOf(ajJAz3SI) + ajJAz3SI.length(),
						jFfsaAvn.indexOf(A1nnlZaq))));
				wOx2JcLx.setTime(
						jFfsaAvn.substring(jFfsaAvn.indexOf(x1Ghkj7H) + x1Ghkj7H.length(), jFfsaAvn.indexOf(zpMpVvlX)));
				GtsOkTcO.get(key).getAwayEvents().add(wOx2JcLx);
			}
		}
		A3CllKcK.close();
	}

}